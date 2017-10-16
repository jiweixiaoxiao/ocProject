package com.online.college.service;

import java.io.File;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.storage.ThumbModel;
import com.online.college.common.util.CommonUtil;

public class QiNiuTest extends TestCase {
	Logger log = Logger.getLogger(AppTest.class);


	public void testImages() {
		//测试上传图片
		//byte[] buff = CommonUtil.getFileBytes(new File("D://2222.mp4"));
		//String key = QiniuStorage.uploadImage(buff);
		//System.out.println("key = " + key);
		
	//	String key = "/default/all/0/0b75266553d24506a1df015f2b52d2f8.jpeg";
		//测试下载图片
		String url = QiniuStorage.getUrl("uizhivedio");
		System.out.println("url = " + url);

		//测试下载不同大小的图片
//		url = QiniuStorage.getUrl(key,ThumbModel.THUMB_256);
//		System.out.println("url = " + url);
		
	}
}

