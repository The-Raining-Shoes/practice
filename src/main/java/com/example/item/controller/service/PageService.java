package com.example.item.controller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.item.entity.entityInfo.GoodsInfo;
import com.example.item.repostory.index.WpInfoRepository;

@Service
public class PageService {
	
	@Autowired 
	JdbcTemplate jdbc;
	@Autowired
	WpInfoRepository wpInfoRepository;

	// 查询所有的榴莲
	public List<GoodsInfo> findAllGoodsInfo() {
		List<GoodsInfo> goodsInfoList =  wpInfoRepository.findAll();
		return goodsInfoList;
	}

	//保存榴莲
	public GoodsInfo saveGoods(GoodsInfo goodsInfo) {
		GoodsInfo goodsDb = wpInfoRepository.save(goodsInfo);
		return goodsDb;
	}

	public Map<String, List<String>> getThierPage() {
		String querySql = "select goods_src from goods_info";
		Map<String,List<String>> result = new HashMap<>();
		List<Map<String, Object>> list = jdbc.queryForList(querySql);
		List<String> lists = new ArrayList<>();
		for (Map<String, Object> map : list) {
			lists.add(map.get("GOODS_SRC").toString());
		}
		result.put("imgList", lists);
		return result;
	}
	
	

}
