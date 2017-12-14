package com.soccer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="league")
public class League {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	private int lyear;
	private String season;
	private String title;
	
	public League() {
		super();
	}
	
	public League(int lyear, String season, String title) {
		this.lyear = lyear;
		this.season = season;
		this.title = title;
	}
	
	public League(int lid, int lyear, String season, String title) {
		this.lid = lid;
		this.lyear = lyear;
		this.season = season;
		this.title = title;
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getLyear() {
		return lyear;
	}
	public void setLyear(int lyear) {
		this.lyear = lyear;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "League [lid=" + lid + ", lyear=" + lyear + ", season=" + season + ", title=" + title + "]";
	}
	
	
	
	
}
