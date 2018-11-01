package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.League;

/**
 * base_ballテーブル操作用のリポジトリ
 * 
 * @author kento.taira
 *
 */
@Repository
public class BaseballRepository {

	private final static String TABLE_NAME = "baseball_teams";

	/**
	 * ResultSetオブジェクトからLeagueオブジェクトに変換するためのクラス実装&インスタンス化
	 */
	private final static RowMapper<League> LEAGUELIST_ROW_MAPPER = (rs, i) -> {
		Integer id = rs.getInt("id");
		String leagueName = rs.getString("league_name");
		String teamName = rs.getString("team_name");
		String headquarters = rs.getString("headquarters");
		String inauguration = rs.getString("inauguration");
		String history = rs.getString("history");
		return new League(id, leagueName, teamName, headquarters, inauguration, history);
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 全件検索（チーム情報一覧を取得する）.
	 * 
	 * @return　チーム情報をListに入れて全件を返す
	 */
	public List<League> findAll() {
		String sql = "select id, league_name, team_name, headquarters, inauguration, history from " + TABLE_NAME;

		List<League> list = template.query(sql, LEAGUELIST_ROW_MAPPER);
		return list;
	}

	
	/**
	 * 1件検索（チーム情報1件を取得する）.
	 * 
	 * @param id チームID
	 * @return チーム情報1件を返す
	 */
	public League load(Integer id) {
		// System.out.println("id="+id);
		String sql = "select id, league_name, team_name, headquarters, inauguration, history from " + TABLE_NAME
				+ " where id = :id;";
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		League league = template.queryForObject(sql, param, LEAGUELIST_ROW_MAPPER);

		return league;
	}

}
