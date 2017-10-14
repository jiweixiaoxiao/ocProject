package com.online.college.core.news.service;

import com.online.college.common.page.TailPage;
import com.online.college.core.member.vo.ResultVo;
import com.online.college.core.news.domain.News;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 新闻模块的处理类
 * User: jiwei
 * Date: 2017-10-11
 * Time: 16:22
 */

public interface InewsService {
    //增加一条新闻
    public String insertNews(News news) throws IOException;

    //删除一条新闻
    public String deleteNews(Integer id) throws IOException;

    //删除多条新闻
    public  String deleteNewsList(List<Integer> integerList);

    //分页查询新闻列表
    public TailPage<News> queryPage(News news,TailPage<News> tailPage);

    //查找一条新闻
    //可根据（id,newsName,或者内容中的某一段内容，来查）
    public  News queryOnePage(News news);

    //更新一条新闻
    public String updateNews(News news);

}
