package com.online.college.rest.controller;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.util.CommonUtil;
import com.online.college.core.member.vo.ResultVoUtils;
import com.online.college.core.picture.service.PictureService;
import com.online.college.core.picture.service.impl.PictureServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-18
 * Time: 16:38
 */
@Controller
@RequestMapping("/picOper")
public class PictureOperController {
    @Autowired
   private PictureService pictureService;
    @RequestMapping("/picInsert")
    @ResponseBody
    public String insertPic(String picpath){
        String result  = pictureService.insertOnePic("D:\\pic\\"+picpath);
            return result;
    }
}
