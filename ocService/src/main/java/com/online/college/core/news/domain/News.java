package com.online.college.core.news.domain;

import java.util.Date;

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

    private String newsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public Date getNewsTimes() {
        return newsTimes;
    }

    public void setNewsTimes(Date newsTimes) {
        this.newsTimes = newsTimes;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public String getNewsAuthorinfo() {
        return newsAuthorinfo;
    }

    public void setNewsAuthorinfo(String newsAuthorinfo) {
        this.newsAuthorinfo = newsAuthorinfo == null ? null : newsAuthorinfo.trim();
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    public String getNewsImages() {
        return newsImages;
    }

    public void setNewsImages(String newsImages) {
        this.newsImages = newsImages == null ? null : newsImages.trim();
    }

    public String getNewsAdmin() {
        return newsAdmin;
    }

    public void setNewsAdmin(String newsAdmin) {
        this.newsAdmin = newsAdmin == null ? null : newsAdmin.trim();
    }

    public Date getNewUpdatetime() {
        return newUpdatetime;
    }

    public void setNewUpdatetime(Date newUpdatetime) {
        this.newUpdatetime = newUpdatetime;
    }

    public Integer getNewsDelete() {
        return newsDelete;
    }

    public void setNewsDelete(Integer newsDelete) {
        this.newsDelete = newsDelete;
    }

    public String getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(String newsMark) {
        this.newsMark = newsMark == null ? null : newsMark.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
}