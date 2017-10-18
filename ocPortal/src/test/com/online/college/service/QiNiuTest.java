package com.online.college.service;

import java.io.File;

import com.online.college.core.picture.service.PictureService;
import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.storage.ThumbModel;
import com.online.college.common.util.CommonUtil;

public class QiNiuTest extends TestCase {
	Logger log = Logger.getLogger(AppTest.class);


	public void testImages() {
		//测试上传图片
		byte[] buff = CommonUtil.getFileBytes(new File("D://pic//2.jpg"));
		String key = QiniuStorage.uploadImage(buff);
		System.out.println("key = " + key);
		//String key = "/default/all/0/80aa87d3de0e4e8295ea5a735cf80499";
		//测试下载图片
		//String url = QiniuStorage.getUrl(key);
		//System.out.println("url = " + url);

		//测试下载不同大小的图片
//		url = QiniuStorage.getUrl(key,ThumbModel.THUMB_256);
//		System.out.println("url = " + url);
		
	}
}

