package com.train.gdmt.announcement.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.announcement.service.AnnouncementService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("announcement")
public class AnnouncementControl {

    @Autowired
    private AnnouncementService announcementService;

    private static final Logger LOGGER = Logger.getLogger(AnnouncementControl.class);

    @RequestMapping("findAllAnnouncement")
    public String findAllAnnouncements(HttpServletRequest request, HttpServletResponse response) {
        List<Announcement> announcementList = announcementService.findAllAnnouncements();
        request.setAttribute("announcement", announcementList);
        return "Announcement-Admin";
    }

    @RequestMapping("view")
    public String viewAnnouncement(HttpServletRequest request, HttpServletResponse response) {
        String announceNum = request.getParameter("num");
        Announcement viewAnnouncement = announcementService.getAnnouncement(announceNum);
        List<Announcement> announcementList = announcementService.findAllAnnouncements();
        request.setAttribute("announcement", viewAnnouncement);
        return "announcement-content";
    }

    @RequestMapping("delete")
    public String deleteAnnouncement(HttpServletRequest request, HttpServletResponse response) {
        String announceNum = request.getParameter("num");
        int returnid = announcementService.deleteAnnouncements(announceNum);
        return "redirect:/announcement/page";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "announcement-add";
    }


    /**
     * 分页
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("page")
    public String page(Model model, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println("Page Number>>>>>>>>>>>>" + pageNum);
        //引入分页查询，在查询之前获取当前页记录
        PageHelper.startPage(pageNum, pageSize);

        //分页查询
        // List<PurchaseNote> bills = pnService.findAllBills();
        List<Announcement> announcementList = announcementService.findAllAnnouncements();
//        List<String> sdj1 = new ArrayList<>();
//
//        for (Announcement bill:announcementList) {
//            sdj1.add(crService.findSDJ1(""+bill.getPurchApplyId()));
//        }

        //包装查询结果
        PageInfo pageInfo = new PageInfo(announcementList, 1);
        pageInfo.setList(announcementList);
        //model.addAttribute("sdj1",sdj1);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("addUrl","http://localhost:8081/announcement/toAdd");
        //获取当前页
        model.addAttribute("pageNum", pageNum);
        //获取一页显示的条
        model.addAttribute("pageSize", pageSize);
        //是否为第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否为最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "Announcement-Admin";
    }


    @RequestMapping("addAnnouncement")
    public String addAnnouncement(Announcement announcement, HttpServletRequest request) {
  /*      if(){

        }*/
        announcementService.addAnnouncement(announcement);
        request.setAttribute("message", "添加公告成功！");
        //return "Announcement-Admin";
        return "redirect:/announcement/page";
    }
}
