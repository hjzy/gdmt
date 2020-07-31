package com.train.gdmt.announcement.service;

import com.train.gdmt.announcement.model.Announcement;

import java.util.List;


public interface AnnouncementService {
    Announcement getAnnouncement(String announceNum);
    List<Announcement> findAllAnnouncements();
}
