package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.HotelRepository;

/**
 * 受け取ったpriceで絞り込んだ情報を受け取り、
 * requestスコープに入れるコントローラ.
 * 
 * @author kento.taira
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelRepository repository;

	/**
	 * 初期画面表示.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("/index")
	public String index() {
		return "practice_10km/index";
	}

	/**
	 * 入力された値段以下のホテル情報を出力する.
	 * ↑↑わかりやすい
	 * 
	 * ↓↓わかりにくい
	 * 入力されたpriceを受け取り、その情報を元にfindByPrice()する.
	 * findByPrice()した情報（一泊料金price円以下のホテル情報）をrequestスコープに入れて出力画面に返す.
	 * 
	 * @param model
	 *            モデル
	 * @param price
	 *            金額
	 * @return 出力画面
	 */
	@RequestMapping("/search")
	public String search(Model model, Integer price) {

		List<Hotel> hotelList = repository.findUnderPrice(price);
		model.addAttribute("hotels", hotelList);

		return "practice_10km/index";
	}

}
