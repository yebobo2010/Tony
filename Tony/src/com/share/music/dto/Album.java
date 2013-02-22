package com.share.music.dto;

import java.io.Serializable;

/**
 * 专辑
 * 
 * @author Administrator
 * 
 */
public class Album implements Serializable {
	private static final long serialVersionUID = 8517633545835124349L;
	private String artistName;// 专辑的名称
	private int id;
	private String image;// 图片
	private String name;// 歌曲的名称
	private double rating;

	public String getArtistName() {
		return this.artistName;
	}

	public int getId() {
		return this.id;
	}

	public String getImage() {
		return this.image;
	}

	public String getName() {
		return this.name;
	}

	public double getRating() {
		return this.rating;
	}

	public void setArtistName(String paramString) {
		this.artistName = paramString;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public void setImage(String paramString) {
		this.image = paramString;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}

	public void setRating(double paramDouble) {
		this.rating = paramDouble;
	}
}