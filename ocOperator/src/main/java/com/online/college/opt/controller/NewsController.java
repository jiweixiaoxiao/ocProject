package com.online.college.opt.controller;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.SessionContext;
import com.online.college.core.news.domain.News;
import com.online.college.core.news.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-11
 * Time: 23:13
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping("/pageList")
    public ModelAndView pageList(News news, TailPage<News> page){
        ModelAndView modelAndView = new ModelAndView("cms/news/newsList");

        page = newsService.queryPage(news,page);
        page.setPageSize(5);
        modelAndView.addObject("page",page);
        modelAndView.addObject("curNav","news");
        modelAndView.addObject("news",news);
        return modelAndView;
    }

    @RequestMapping("/insertNews")
    public String newsInsert(News news){
        try {
            String result = newsService.insertNews(news);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/deleteNews")
    public String newsDelete(Integer id){
        try {
            return newsService.deleteNews(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/toAddNew")
    public ModelAndView toAddNewsPages(){
        ModelAndView modelAndView = new ModelAndView("cms/news/addNews");
        modelAndView.addObject("curNav","news");
        return modelAndView;
    }


}
