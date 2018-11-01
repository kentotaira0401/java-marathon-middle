package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.resource.HttpResource;

import com.example.demo.domain.League;
import com.example.demo.repository.BaseballRepository;

/**
 * 受け取った情報をrequestスコープに入れるコントローラ
 * 
 * @author kento.taira
 *
 */
@Controller
@RequestMapping("/baseballLeague")
public class BaseballLeagueController {

	/**
	 * repositoryのfindAllメソッドで引っ張ってきた情報を全てLeague型のListに入れて
	 * キーがleaguesのrequestスコープに入れる
	 * その後初期画面表示
	 * 
	 * @param model　モデル
	 * @return 初期画面
	 */
	@RequestMapping("/teamList")
	public String teamList(Model model) {
		List<League> list = repository.findAll();
		model.addAttribute("leagues", list);
		return "teamList";
	}
	// private HttpResource application;

	@Autowired
	private BaseballRepository repository;

	/**
	 * repositoryのloadメソッドで引っ張ってきた情報をLeague型のleagueに入れて
	 * キーがleagueのrequestスコープに入れる
	 * その後出力画面表示
	 * 
	 * @param model　モデル
	 * @param id　ID
	 * @return　出力画面
	 */
	@RequestMapping("/load")
	public String load(Model model, Integer id) {

		League league = repository.load(id);
		model.addAttribute("league", league);

		return "profile";

	}

}
