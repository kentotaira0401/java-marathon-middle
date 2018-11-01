package com.example.demo.domain;

/**
 * ホテルの情報を表すドメイン
 * 
 * @author kento.taira
 *
 */
public class Hotel {
	/** id */
	private Integer id;
	/** ホテル名 */
	private String hotelName;
	/** 最寄り駅 */
	private String nearestStation;
	/** 一泊料金 */
	private Integer price;

	public Hotel() {
		super();
	}

	public Hotel(String hotelName, String nearestStation, Integer price) {
		super();
		this.hotelName = hotelName;
		this.nearestStation = nearestStation;
		this.price = price;
	}

	
	
	public Hotel(Integer id, String hotelName, String nearestStation, Integer price) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.nearestStation = nearestStation;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", hotelName=" + hotelName + ", nearestStation=" + nearestStation + ", price="
				+ price + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
