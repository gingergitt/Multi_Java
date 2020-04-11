package com.sds.finalpj.vo;

public class UserInterest {

	int userinterest;
	String userid;
	String living;
	String food;
	String fashion;
	String culture;
	String etc;

	public UserInterest() {
		super();
	}

	public UserInterest(int userinterest, String userid, String living, String food, String fashion, String culture,
			String etc) {
		super();
		this.userinterest = userinterest;
		this.userid = userid;
		this.living = living;
		this.food = food;
		this.fashion = fashion;
		this.culture = culture;
		this.etc = etc;
	}

	public int getUserinterest() {
		return userinterest;
	}

	public void setUserinterest(int userinterest) {
		this.userinterest = userinterest;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLiving() {
		return living;
	}

	public void setLiving(String living) {
		this.living = living;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getFashion() {
		return fashion;
	}

	public void setFashion(String fashion) {
		this.fashion = fashion;
	}

	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

}
