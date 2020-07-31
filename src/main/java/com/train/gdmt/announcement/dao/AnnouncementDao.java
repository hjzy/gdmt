package com.train.gdmt.announcement.dao;

import com.train.gdmt.announcement.model.Announcement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:09
 */



@Mapper//表示mybatis中负责实体和sql映射的类
@Repository//注册userdao作为一个bean
public interface AnnouncementDao {


    @Select("select * from Announcement where announce_Num=#{announceNum}")
    Announcement getAnnouncement(String announceNum);

    @Select("select * from Announcement")
    List<Announcement> getAllAnnouncement();

    @Delete("delete from Announcement where announce_Num=#{announceNum}")
    int deleteAnnouncement(String announceNum);
    @Insert("INSERT INTO Announcement (Announce_Title ,  Announce_Time , Announce_Content ) " +
            "VALUES (#{announceTitle},#{announceTime},#{announceContent})")
    public  void addAnnouncement(Announcement announcement);

}
