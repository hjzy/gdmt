package com.train.gdmt.announcement.service.impl;

import com.train.gdmt.announcement.dao.AnnouncementDao;
import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.announcement.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public Announcement getAnnouncement(String announceNum) {

        return announcementDao.getAnnouncement(announceNum);
    }

    @Override
    public List<Announcement> findAllAnnouncements() {
        return announcementDao.getAllAnnouncement();
    }

    @Override
    public int deleteAnnouncements(String announceNum) {
        return announcementDao.deleteAnnouncement(announceNum);
    }


}
