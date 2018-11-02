package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Shop;
import com.example.demo.form.ShopForm;
import com.example.demo.repository.ShopRepository;

/**
 * 絞り込んだ情報をrequestスコープに入れるコントローラ.
 * 
 * @author kento.taira
 *
 */
@Controller
@Transactional
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopRepository repository;
	
	@ModelAttribute
	public ShopForm setUpForm() {
		return new ShopForm();
	}
	
	/**
	 * 初期画面出力.
	 * 
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		
		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("白", "白");
		colorMap.put("青", "青");
		colorMap.put("黄色", "黄色");
		model.addAttribute("colorMap", colorMap);
		//System.out.println(colorMap);
		return "practice_15km/index";
	}
	
	/**
	 * 
	 * 入力された値で絞り込んだ洋服情報をrequestスコープに入れて出力.
	 * 
	 * @param model　モデル
	 * @param gender　性別
	 * @param color　色
	 * @return　入力情報を保持した出力画面
	 */
	@RequestMapping("/search")
	public String search(Model model, ShopForm form) {
		Integer gender = form.getGender();
		String color = form.getColor();
		List<Shop> shopList = repository.search(gender, color);
		model.addAttribute("shops",shopList);
		
		String returnValue = index(model);
		return returnValue;
	}
	
	
}
