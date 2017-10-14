package com.online.college.core.news.service.impl;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.SessionContext;
import com.online.college.core.member.vo.ResultVo;
import com.online.college.core.member.vo.ResultVoUtils;
import com.online.college.core.news.dao.NewsDao;
import com.online.college.core.news.domain.News;
import com.online.college.core.news.service.InewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-11
 * Time: 16:42
 */
@Service
public class NewsServiceImpl implements InewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public String insertNews(News news) throws IOException {
        if (StringUtils.isEmpty(news.getNewsTitle())
                && StringUtils.isEmpty(news.getNewsContent())) {
            return ResultVoUtils.success("标题或内容不能为空", "110");
        }
        String userName =  SessionContext.getUsername();
        if(StringUtils.isEmpty(userName)){
            throw new RuntimeException("服务器异常，请重新登录");
        }
        news.setNewsAdmin(userName);
        int result = newsDao.insertSelective(news);
        if (result < 1) {
            return ResultVoUtils.success("插入失败，请稍后再试", "111");
        }
        return ResultVoUtils.success("插入成功", "112");
    }

    @Override
    public String deleteNews(Integer id) throws IOException {
        int result = newsDao.deleteByPrimaryKey(id);
        if(result>0){
                ResultVoUtils.message("删除成功","100");
        }
        return ResultVoUtils.message("删除失败","101");
    }

    @Override
    public String deleteNewsList(List<Integer> integerList) {
        return null;
    }

    @Override
    public TailPage<News> queryPage(News news, TailPage<News> tailPage) {
        List<News> newsList = newsDao.queryPage(news,tailPage);
        int total = newsDao.getTotalItemsCount();
        tailPage.setItemsTotalCount(total);
        tailPage.setItems(newsList);
        return tailPage;
    }

    @Override
    public News queryOnePage(News news) {
        return null;
    }

    @Override
    public String updateNews(News news) {

        return null;
    }

}
