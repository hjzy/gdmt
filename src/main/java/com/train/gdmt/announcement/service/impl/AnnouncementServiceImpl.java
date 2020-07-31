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
    public Announcement login(String announceTitle) {
        return announcementDao.getAnnouncement(announceTitle);
    }

    @Override
    public List<Announcement> findAllAnnouncements() {
        return announcementDao.getAllAnnouncement();
    }
}
