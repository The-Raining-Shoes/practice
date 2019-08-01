package com.example.item.controller.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.item.reportSource.ResJdbcTemplate;

public class ExportTestService {
	
	@Autowired
	public static ResJdbcTemplate jdbc;
	
	public static void main(String[] args) {
		String querySql = "SELECT ";
		jdbc.queryForList(querySql);	
	}
}
