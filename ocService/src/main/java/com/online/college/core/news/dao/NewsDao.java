package com.online.college.core.news.dao;

import com.online.college.common.page.TailPage;
import com.online.college.core.news.domain.News;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-11
 * Time: 10:47
 */
public interface NewsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    List<News> queryPage(News news, TailPage<News> page);

    int getTotalItemsCount();

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}
