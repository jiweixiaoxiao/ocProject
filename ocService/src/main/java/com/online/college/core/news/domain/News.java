package com.online.college.core.news.domain;

import lombok.Data;

import java.util.Date;

@Data
public class News {
    private Integer id;

    private String newsTitle;

    private Date newsTimes;

    private String newsAuthor;

    private String newsAuthorinfo;

    private String newsSource;

    private String newsImages;

    private String newsAdmin;

    private Date newUpdatetime;

    private Integer newsDelete;

    private String newsMark;

    private Integer newsBrowsenum;

    private Integer newsRecommendnum;

    private String newsContent;


}