import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.util.CommonUtil;
import com.online.college.common.web.SessionContext;
import com.online.college.core.news.domain.News;
import com.online.college.core.news.service.impl.NewsServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class NewsServiceImplTest extends TestCase {

    @Autowired
    private NewsServiceImpl newsService;

    @Test
    public void testInsertNews() throws Exception {
        News news = new News();
        //String name = SessionContext.getUsername();
       // System.out.println("name=============================="+name);
        news.setNewsAdmin("张三");
        news.setNewsAuthor("梁祝");
        news.setNewsTitle("以工匠精神引领高技能人才培养");
        news.setNewsContent("世界上的制造业强国，都有一支数量充足的高素质技术技能人才队伍，也都有适合自己国家的技术技能人才培养制度。具体到我国，主要由中、高等职业院校和企业承担培养高技能人才和技术工人的任务。在“中国制造2025”的机遇与挑战面前，职业院校技术技能人才培养需要用工匠精神来引领。具体而言，就是要用“慢”的精神陶铸职业信念，用“专”的信念提升职业能力，用“创”的理念助推职业发展，用“德”的秉性重塑师生关系，让工匠精神渗透到教育教学全过程。");

        //图片上传
        byte[] buff = CommonUtil.getFileBytes(new File("D://jiwei.jpg"));
        String key = QiniuStorage.uploadImage(buff);
        news.setNewsImages(key);

        String result = newsService.insertNews(news);
        System.out.println(result);
    }

    public void testDeleteNews() throws Exception {
    }

    public void testDeleteNewsList() throws Exception {
    }

    public void testQueryPage() throws Exception {
    }

    public void testQueryOnePage() throws Exception {
    }

    public void testUpdateNews() throws Exception {
    }

}