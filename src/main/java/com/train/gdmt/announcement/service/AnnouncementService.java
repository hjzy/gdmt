package com.train.gdmt.announcement.service;

import com.train.gdmt.announcement.model.Announcement;

import java.util.List;


public interface AnnouncementService {
    Announcement login(String username);
    List<Announcement> findAllAnnouncements();
}
