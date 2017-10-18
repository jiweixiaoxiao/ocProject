package com.online.college.rest.test;
import com.online.college.common.web.SpringBeanFactory;
import com.online.college.rest.controller.PictureOperController;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class PictureOperControllerTest extends TestCase{

    public void testPicInsert(){
        PictureOperController pictureOperController  = (PictureOperController) SpringBeanFactory.getBean("pictureOperController");
       String reult =  pictureOperController.insertPic("D://");
        System.out.println(reult);
    }
}