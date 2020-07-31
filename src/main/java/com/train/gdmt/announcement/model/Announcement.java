package com.train.gdmt.announcement.model;

import lombok.Data;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:10
 */

@Data//自动生成set和get方法
public class Announcement {

       private int  announceNum;
       private String announceTitle;
       private String announceTime;
       private String announceContent;

}

