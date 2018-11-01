package com.example.demo.domain;

/**
 * shop情報を表すドメイン.
 * 
 * @author kento.taira
 *
 */
public class Shop {

	/** id */
	private Integer id;
	/** 性別 */
	private Integer gender;
	/** 価格 */
	private Integer price;
	/** カテゴリー */
	private String category;
	/** ジャンル */
	private String genre;
	/** 色 */
	private String color;
	/** サイズ */
	private String size;

	public Shop() {
		super();
	}

	public Shop(Integer id, Integer gender, Integer price, String category, String genre, String color, String size) {
		super();
		this.id = id;
		this.gender = gender;
		this.price = price;
		this.category = category;
		this.genre = genre;
		this.color = color;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", gender=" + gender + ", price=" + price + ", category=" + category + ", genre="
				+ genre + ", color=" + color + ", size=" + size + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
