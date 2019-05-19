package com.example.item.controller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service
public class CommentService {
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * 获取评论列表
	 * @return
	 * @Map<String,Object>
	 */
	public Map<String,Object> getElement() {
		String sql1 = "select * from comment_list where tie_state = 1";
		String sql2 = "select * from comment_answer";
		List<Map<String, Object>> a = jdbc.queryForList(sql1);
		List<Map<String, Object>> b = jdbc.queryForList(sql2);
		Map<String, Object> result = new HashMap<>();
		result.put("tie_list",JSON.toJSONString(a));
		result.put("tie_info",JSON.toJSONString(b));
		return result;
	}

	/**
	 * 用户回复评论
	 * @param 
	 * @return
	 * @Map<String,Object>
	 */
	public Map<String, Object> getAnswer(Map<String, String> param) {
		Map<String,Object> result = new HashMap<>();
	//	String tie_son = (String) session.getAttribute("userName");
		String tie_son = "自传数据";
		String tie_id = param.get("main_id");
		String tie_content = param.get("answer_content");
		String tie_father = param.get("tie_username");
		String sql = "insert into comment_answer (tie_id,answer_content,answer_father,answer_son,create_time) values('"+tie_id+"','"+tie_content+"',"
				+ "'"+tie_father+"','"+tie_son+"',SYSDATE())";
		int ifTrue = jdbc.update(sql);
		if(ifTrue>0) {
			result.put("code", 1);
		}
		return result;
	}
	
}