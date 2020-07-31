package com.train.gdmt.announcement.controller;


import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.announcement.service.AnnouncementService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "redirect:/announcement/findAllAnnouncement";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "announcement-add";
    }



    public String toLogin() {
        return "login-simple";
    }

    @RequestMapping("addAnnouncement")
    public String addAnnouncement(Announcement announcement,HttpServletRequest request){
  /*      if(){

        }*/
        announcementService.addAnnouncement(announcement);
        request.setAttribute("message","添加用户成功！");
        //return "Announcement-Admin";
        return "redirect:/announcement/findAllAnnouncement";
    }
}
