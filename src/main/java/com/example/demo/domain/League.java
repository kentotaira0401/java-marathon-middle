package com.example.demo.domain;

/**
 * 野球チームの情報を表すドメイン
 * 
 * @author kento.taira
 *
 */
public class League {
	/** id */
	private Integer id;
	/** リーグ名 */
	private String leagueName;
	/** チーム名 */
	private String teamName;
	/** 本拠地 */
	private String headQuarters;
	/** 発足 */
	private String inauguration;
	/** 歴史 */
	private String history;

	public League() {
		super();
	}

	public League(Integer id, String leagueName, String teamName, String headQuarters, String inauguration,
			String history) {
		super();
		this.id = id;
		this.leagueName = leagueName;
		this.teamName = teamName;
		this.headQuarters = headQuarters;
		this.inauguration = inauguration;
		this.history = history;
	}

	@Override
	public String toString() {
		return "LeagueList [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headQuarters="
				+ headQuarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadQuarters() {
		return headQuarters;
	}

	public void setHeadQuarters(String headQuarters) {
		this.headQuarters = headQuarters;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

}
