package com.dreamingkid.dream;

public class Label {
	public static String LUCID = "LUCID";
	public static String HALFlUCID = "HALFlUCID";
	public static String OBE ="OBE";
	public static String LAYERED = "LAYERED";
	public static String WONDERFUL = "WONDERFUL";
	public static String SEXUAL = "SEXUAL";
	public static String MUTUAL = "MUTUAL";
	public static String PREDICTIVE = "PREDICTIVE";
	public static String NIGHTMARE = "NIGHTMARE";
	public static String DIVINE = "DIVINE"; 
	
	private String name;
	private int number;
	
	// sets
	public void setName(String name){
		this.name=name;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	// gets
	public String getName(){
		return name;
	}
	
	public int getNumber(){
		return number;
	}
	
}