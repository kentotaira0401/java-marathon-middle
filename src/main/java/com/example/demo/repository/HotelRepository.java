package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

/**
 * hotelsテーブル操作用のリポジトリ.
 * 
 * @author kento.taira
 *
 */
@Repository
public class HotelRepository {

	private final static String TABLE_NAME = "hotels";

	/** NamedParameterJdbcTemplateオブジェクトを使用するための定義. */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** ResultSetオブジェクトからHotelオブジェクトに変換するためのクラス実装&インスタンス化. */
	private final static RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		/*
		 * Hotel hotel = new Hotel(); hotel.setId(rs.getInt("id"));
		 */
		Integer id = rs.getInt("id");
		String hotelName = rs.getString("hotel_name");
		String nearestStation = rs.getString("nearest_station");
		Integer price = rs.getInt("price");
		return new Hotel(id, hotelName, nearestStation, price);
	};

	/**
	 * 受け取ったpriceを使ってDBから情報を受け取りList化する.
	 * 
	 * @param price
	 *            価格
	 * @return 検索されたホテル情報List
	 */
	public List<Hotel> findUnderPrice(Integer price) {

		String sql = "select id, hotel_name, nearest_station, price from " + TABLE_NAME
				+ " where price <= :price order by price;";
		SqlParameterSource param = new MapSqlParameterSource("price", price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

		return hotelList;
	}
}
