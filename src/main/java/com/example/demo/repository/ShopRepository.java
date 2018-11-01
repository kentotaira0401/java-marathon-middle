package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Shop;

/**
 * shopテーブル操作用のリポジトリ.
 * 
 * @author kento.taira
 *
 */
@Repository
public class ShopRepository {

	private final static String TABLE_NAME = "shops";

	@Autowired
	private NamedParameterJdbcTemplate template;

	/** ResultSetオブジェクトからShopオブジェクトに変換するためのクラス実装&インスタンス化. */
	private final static RowMapper<Shop> SHOP_ROW_MAPPER = (rs, i) -> {

		Shop shop = new Shop();
		shop.setId(rs.getInt("id"));
		shop.setGender(rs.getInt("gender"));
		shop.setPrice(rs.getInt("price"));
		shop.setCategory(rs.getString("category"));
		shop.setGenre(rs.getString("genre"));
		shop.setColor(rs.getString("color"));
		shop.setSize(rs.getString("size"));
		return shop;
		// ↑↓どっちでもよい？？
		/*
		 * Integer id = rs.getInt("id"); Integer gender = rs.getInt("gender"); Integer
		 * price = rs.getInt("price"); String category = rs.getString("category");
		 * String genre = rs.getString("genre"); String color = rs.getString("color");
		 * String size = rs.getString("size");
		 * 
		 * return new Shop(id, gender, price, category, genre, color, size);
		 */
	};

	/**
	 * 受け取ったgenderとcolorで絞り込んだ情報をList化して返す.
	 * 
	 * @param gender
	 *            性別
	 * @param color
	 *            色
	 * @return 洋服情報
	 */
	public List<Shop> search(Integer gender, String color) {

		String sql = "select id,gender,price,category,genre,color,size from " + TABLE_NAME
				+ " where gender = :gender and color = :color";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		List<Shop> shopList = template.query(sql, param, SHOP_ROW_MAPPER);

		return shopList;
	}

}
