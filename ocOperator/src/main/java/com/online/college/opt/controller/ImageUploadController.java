package com.online.college.opt.controller;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-11
 * Time: 23:59
 */
@Controller
@RequestMapping("/imageUpload")
public class ImageUploadController {
    @RequestMapping("/upload")
    public String uplpad(@RequestParam("upload") MultipartFile file,//
                     HttpServletRequest request, //
                     HttpServletResponse response) {
        String url = null;
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");

        try {
            InputStream inputStream = file.getInputStream();
            byte[] bytes = CommonUtil.getFileBytes(inputStream);
            String key = QiniuStorage.uploadImage(bytes);
            System.out.println("key = " + key);
            url = QiniuStorage.getUrl(key);
            System.out.println("url = " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.getSize() > 4000 * 1024) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",''," + "'文件大小不得大于4MB');");
            out.println("</script>");
            return null;
        }
        //TODO 跨域问题
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + url + "','')");
        out.println("</script>");

        return null;

    }
}
