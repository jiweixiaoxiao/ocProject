package com.online.college.core.picture.domain;

public class Picture {
    private Integer id;

    private String pictureKey;

    private Integer pictureSpacetype;

    private String pictureSpacename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureKey() {
        return pictureKey;
    }

    public void setPictureKey(String pictureKey) {
        this.pictureKey = pictureKey == null ? null : pictureKey.trim();
    }

    public Integer getPictureSpacetype() {
        return pictureSpacetype;
    }

    public void setPictureSpacetype(Integer pictureSpacetype) {
        this.pictureSpacetype = pictureSpacetype;
    }

    public String getPictureSpacename() {
        return pictureSpacename;
    }

    public void setPictureSpacename(String pictureSpacename) {
        this.pictureSpacename = pictureSpacename == null ? null : pictureSpacename.trim();
    }
}