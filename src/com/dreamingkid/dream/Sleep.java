package com.dreamingkid.dream;

import java.util.ArrayList;
import java.util.Date;

public class Sleep {
	private Date beginTime;
	private Date endTime;
	private ArrayList<Dream> dreams;
	
	// gets
	public Date getBeginTime() {
		
		return beginTime;
	}
	
	public Date getEndTime() {
		
		return endTime;
	}
	
	public ArrayList<Dream> getDreams(){
		return dreams;
	}
	
	//sets
	public void setBeginTime(Date beginTime){
		this.beginTime = beginTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	
	public void setDreams(ArrayList<Dream> dreams){
		this.dreams = dreams;
	}
}
