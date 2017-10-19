package com.online.college.core.picture.service;

import com.online.college.common.page.TailPage;
import com.online.college.core.picture.domain.Picture;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-18
 * Time: 15:41
 */
public interface PictureService {
    /*
    插入一张图片
     */
    public String insertOnePic(String path);
    /*
    插入多张图片
     */
    public String insertMorePic(List<Picture> pictureList);
    /*
    删除一张图片
     */
    public String deleteOnePic(Integer integer);
    /*
   删除多张图片
    */
    public String deleteMorePic(Integer[] integers);
    /*
   更新一张图片
    */
    public String updateOnePic(Picture picture);
    /*
   更新多张图片
    */
    public String updateMorePic(List<Picture> pictureList);
    /*
   查找一张图片
    */
    public Picture findOnePic(Picture picture);
    /*
   分页查找多张图片
    */
    public TailPage<Picture> findMorePic(Picture picture,TailPage<Picture> tailPage);
    /*
   把图片推送到Redis中
    */
    public String pushPicPathToRedis(List<Picture> list);
}
