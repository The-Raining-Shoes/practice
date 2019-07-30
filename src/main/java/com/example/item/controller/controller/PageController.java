package com.example.item.controller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.item.controller.service.PageService;
import com.example.item.entity.entityInfo.GoodsInfo;

@RestController
@RequestMapping("/page")
public class PageController {

	@Autowired
	PageService pageService;

	// 主页面
	@RequestMapping("/index")
	public ModelAndView returnIndex() {
		return new ModelAndView("/home/index");
	}

	// 主页面
		@RequestMapping("/index2")
		public ModelAndView returnIndex2() {
			return new ModelAndView("/home/index2");
		}
	
	// 我的页面
	@RequestMapping("/mypage")
	public ModelAndView returnMyPage() {
		return new ModelAndView("/home/my");
	}

	// 注册页面
	@RequestMapping("/register")
	public ModelAndView returnRegist() {
		return new ModelAndView("/home/register");
	}

	// 登陆页面
	@RequestMapping("/login")
	public ModelAndView registIndex() {
		return new ModelAndView("/home/login");
	}

	// 新增榴莲
	@RequestMapping("/memory")
	public ModelAndView memoryPage() {
		return new ModelAndView("/home/memory");
	}

	// 榴莲详情
	@RequestMapping("/detail")
	@ResponseBody
	public ModelAndView memoryPage(String goodsId, String goodsName, String goodsStory, String goodsSrc,String goodsPrice) {
		Map<String, String> result = new HashMap<>();
		result.put("goodsId", goodsId);
		result.put("goodsName", goodsName);
		result.put("goodsStory", goodsStory);
		result.put("goodsSrc", goodsSrc);
		return new ModelAndView("/home/story",result);
	}

	// 他们的榴莲
	@RequestMapping("/they")
	public ModelAndView theyPage() {
		// Map<String,List<String>> result = new HashMap<>();
		// result = pageService.getThierPage();
		return new ModelAndView("/home/they");
	}

	// 跳转到他们的榴莲页面
	@RequestMapping("/test1")
	public ModelAndView reseachIndex() {
		return new ModelAndView();
	}

	// 跳转到我的榴莲
	@RequestMapping("/test2")
	public ModelAndView MyIndex() {
		return new ModelAndView();
	}

	// 查询所有的榴莲并封装成List返回
	@RequestMapping("/queryImg")
	@ResponseBody
	public Map<String, List<GoodsInfo>> findAllGoods() {
		List<GoodsInfo> goodsInfoList = pageService.findAllGoodsInfo();
		Map<String, List<GoodsInfo>> result = new HashMap<>();
		result.put("result", goodsInfoList);
		return result;
	}

	// 保存榴莲
	@RequestMapping("test4")
	@ResponseBody
	public Map<String, String> saveGoods(GoodsInfo goodsInfo) {
		GoodsInfo goodsDb = pageService.saveGoods(goodsInfo);
		Map<String, String> result = new HashMap();
		String str = "";
		if (goodsInfo == null) {
			str = "保存失败";
		} else {
			str = "保存成功";
		}
		result.put("result", str);
		return result;
	}

}
