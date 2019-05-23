package com.example.item.controller.service;

import java.util.List;

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
	
	

}
