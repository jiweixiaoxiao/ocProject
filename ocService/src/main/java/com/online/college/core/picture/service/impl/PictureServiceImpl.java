package com.online.college.core.picture.service.impl;

import com.online.college.common.page.TailPage;
import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.util.CommonUtil;
import com.online.college.core.member.vo.ResultVoUtils;
import com.online.college.core.picture.dao.PictureMapper;
import com.online.college.core.picture.domain.Picture;
import com.online.college.core.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-18
 * Time: 15:57
 */
@Service
public class PictureServiceImpl implements PictureService{
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public String insertOnePic(String path) {
        byte[] buff = CommonUtil.getFileBytes(new File(path));
        String key = QiniuStorage.uploadImage(buff);
        Picture picture = new Picture();
        picture.setPictureKey(key);
        picture.setPictureSpacetype(1);
        picture.setPictureSpacename("mydatasource");
        Integer resultNum = pictureMapper.insert(picture);
        if (resultNum<0){
            return ResultVoUtils.message("插入失败，请稍后再试","120");
        }
        String url = "http://uzhi.myjava.vip/"+key;
        return url;
    }

    @Override
    public String insertMorePic(List<Picture> pictureList) {
        return null;
    }

    @Override
    public String deleteOnePic(Integer integer) {
        return null;
    }

    @Override
    public String deleteMorePic(Integer[] integers) {
        return null;
    }

    @Override
    public String updateOnePic(Picture picture) {
        return null;
    }

    @Override
    public String updateMorePic(List<Picture> pictureList) {
        return null;
    }

    @Override
    public Picture findOnePic(Picture picture) {
        return null;
    }

    @Override
    public TailPage<Picture> findMorePic(Picture picture, TailPage<Picture> tailPage) {
        return null;
    }

    @Override
    public String pushPicPathToRedis(List<Picture> list) {
        return null;
    }
}
