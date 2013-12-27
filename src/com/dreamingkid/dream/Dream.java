package com.dreamingkid.dream;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/* To be modified:
 * publish()
 * editDream()
 * inner class:  Note, Recording
 *  
 */

public class Dream {
	public static String[] DEFAULT_KEYWORDS = { "middle school", "fly", "chase" };
	public static final int NORMAL = 1;
	public static final int HALFLUCID = 2;
	public static final int LUCID = 3;
	
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_CONTENT = "content";
	private static final String JSON_DATE = "date";

	private String[] keywords;
	private int lucidity;
	private Date lastEditedTime;
	private String content;
	private ArrayList<Recording> recordings;
	private String title; 
	private Sleep sleep;
	private ArrayList<Label> labels;

	// Methods that set and get attributes
	public void setLabels(ArrayList<Label> labels){
		this.labels = labels;
	}
	
	public void setSleep(Sleep s){
		sleep = s;
	}
	
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public void setLucidity(short lucidity) {
		this.lucidity = lucidity;
	}

	public void setLastEditedTime(Date lastEditedTime) {
		this.lastEditedTime = lastEditedTime;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setContent(String c){
		content = c;
	}

	
	//gets
	public ArrayList<Label> getLables(){
		return labels;
	}
	
	public Sleep getSleep(){
		return sleep;
	}
	
	public String[] getKeywords() {
		return this.keywords;
	}

	public int getLucidity() {
		return this.lucidity;
	}

	public Date getLastEditedTime() {
		return this.lastEditedTime;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		
		return content;
	}

	// publish

	public void publish() {

	}

	// edit Dream

	public void editDream() {

	}

	// constructors

	public Dream() {
		keywords = Dream.DEFAULT_KEYWORDS;
		lucidity = Dream.NORMAL;
		lastEditedTime = new Date();
	}

	public Dream(short lucidity, String[] keywords) {
		this.lucidity = lucidity;
		this.keywords = keywords;
	}
	
	public Dream(JSONObject json) throws JSONException{
		title = json.getString(JSON_TITLE);
		
		content = json.getString(JSON_CONTENT);
		
//		lastEditedTime = (Date)json.get(JSON_DATE);
	}
	
	// use JSON

	public Object toJSON() throws JSONException {
		//To be modified: the data relations are not designed, after redesign the database, 
		//this part should be updated.
		JSONObject json = new JSONObject();
		
		String lastEditedTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		lastEditedTime = sdf.format(this.lastEditedTime);
		
		json.put(JSON_TITLE, title);
		json.put(JSON_CONTENT, content);
		json.put(JSON_DATE, lastEditedTime);
		return json;
		
	}
	
	public String toString(){
		return title;
	}
}
