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
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Service
public class PageService {
	
	@Autowired 
	JdbcTemplate jdbc;
	@Autowired
	WpInfoRepository wpInfoRepository;

	// 查询所有的榴莲
	public List<GoodsInfo> findAllGoodsInfo() {
		JdbcTemplate DB = new JdbcTemplate(getMysqlResDBDs(10));
		List<GoodsInfo> goodsInfoList =  wpInfoRepository.findAll();
		return goodsInfoList;
	}

	public static HikariDataSource getMysqlResDBDs(int poolSize) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(
            "jdbc:mysql://136.25.35.190:28904/resdb?useUnicode=true&characterEncoding=utf-8&useSSL=false&tinyInt1isBit=false");
        config.setUsername("crmapp");
        config.setPassword("crmapp1qaz!QAZ");
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setMaximumPoolSize(poolSize);
        HikariDataSource ds = new HikariDataSource(config);
        return ds;
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
