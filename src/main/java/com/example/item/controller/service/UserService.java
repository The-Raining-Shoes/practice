package com.example.item.controller.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserService {
	
	@Autowired 
	JdbcTemplate jdbc;
	
	//实现图片和表单信息一起上传功能
	public Map<String, String> userComplete(@RequestParam("file") MultipartFile file,Map<String,String> param){
		Map<String,String> result = new HashMap<>();
	    String fileName = file.getOriginalFilename();
	    System.out.println(fileName);
	    String filePath = ("src/main/resources/static/img/");
	    try {
	        uploadFile(file.getBytes(), filePath, fileName);
	    } catch (Exception e) {
	        
	    }
	    result.put("code", "1");
	    // 保存货物
	    this.saveGoods(param,filePath,fileName);
		return result;
	}
	
	private boolean saveGoods(Map<String, String> param, String filePath, String fileName) {
		boolean iftrue = false;
		String sql = "insert into goods_info (GOODS_TYPE,GOODS_NAME,USER_ID,CREATE_DATE,GOODS_TIME,GOODS_COST,GOODS_IS_SHOW,GOODS_STORY,GOODS_SRC)values('"+param.get("goodsType")+"','"+param.get("goodsName")+"',"
				+ "'"+param.get("userId")+"',now()+,'"+param.get("goodsTime")+"','"+param.get("goodsCost")+"','"+param.get("goodsIsShow")+"','"+param.get("goodsStory")+"','"+param.get("goodsSrc")+"'";
		int a = jdbc.update(sql);
		if(1==a) {
			iftrue = true;
		}
		return iftrue;
		
	}

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();   
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	
	//用户注册方法
	public boolean userRegist(Map<String,String> param) {
		boolean iftrue = false;
		String sql = "insert into user_info (USER_NAME,USER_PASSWORD,USER_TEL,USER_SEX,USER_AGE,CREATE_DATE)values('"+param.get("username")+"','"+param.get("userPassword")+"',"
				+ "'"+param.get("phone")+"','"+param.get("sex")+"','"+param.get("age")+"',now())";
		int a = jdbc.update(sql);
		if(1==a) {
			iftrue = true;
		}
		return iftrue;
	}
	
	//ajax验证用户名
	public boolean nameCheck(Map<String,String> param) {
		boolean iftrue = false;
		String sql = "select * from user_info where user_name='"+param.get("username")+"'";
		List<Map<String, Object>> a = jdbc.queryForList(sql);
		if(a.size() != 0) {
			iftrue = true;
		}
		return iftrue;
	}
	
	//ajax验证电话
	public boolean phoneCheck(Map<String, String> param) {
		boolean iftrue = false;
		String sql = "select * from user_info where user_phone='"+param.get("phone")+"'";
		List<Map<String, Object>> a = jdbc.queryForList(sql);
		if(a.size() != 0) {
			iftrue = true;
		}
		return iftrue;
	}
	//用户登陆方法
	public boolean userLogin(Map<String, String> param) {
		boolean iftrue = false;
		String sql = "select * from user_info where user_name='"+param.get("userName")+"' and user_password='"+param.get("userPassword")+"'";
		List<Map<String, Object>> a = jdbc.queryForList(sql);
		if(a.size() != 0) {
			iftrue = true;
		}
		return iftrue;
	}
	
}
