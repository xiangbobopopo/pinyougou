package com.pingyougou.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;



@RequestMapping("/upload")
public class fileUploadController {
	@Value("FILE_SERVER_URL")
	private String file_server_url;
	public Result upload(MultipartFile file){
		String filename = file.getOriginalFilename();
		String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
		try {
			util.FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extensionName);
			String url=file_server_url+fileId;
			return new Result(true, url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result(false, "长传失败!");
	}
}
