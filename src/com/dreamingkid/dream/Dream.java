package com.dreamingkid.dream;


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
	private Date sleepStartTime;
	private Date sleepEndTime;
	private Date lastEditedTime;
	private ArrayList<ScenarioNote> scenarios;
	private String abstraction; 

	// Methods that set and get attributes

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public void setLucidity(short lucidity) {
		this.lucidity = lucidity;
	}

	public void setSleepStartTime(Date sleepStartTime) {
		this.sleepStartTime = sleepStartTime;
	}

	public void setSleepEndTime(Date sleepEndTime) {
		this.sleepEndTime = sleepEndTime;
	}

	public void setLastEditedTime(Date lastEditedTime) {
		this.lastEditedTime = lastEditedTime;
	}
	
	public void setScenarios(ArrayList<ScenarioNote> scenarios){
		this.scenarios = scenarios;
	}
	public void setAbstraction(String abstraction){
		this.abstraction = abstraction;
	}

	
	//gets
	public String[] getKeywords() {
		return this.keywords;
	}

	public int getLucidity() {
		return this.lucidity;
	}

	public Date getSleepStartTime() {
		return this.sleepStartTime;
	}

	public Date getSleepEndTime() {
		return this.sleepEndTime;
	}

	public Date getLastEditedTime() {
		return this.lastEditedTime;
	}
	
	public ArrayList<ScenarioNote> getScenarios(){
		return this.scenarios;
	}
	public String getAbstraction(){
		return this.abstraction;
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
		sleepEndTime = new Date();
	}

	public Dream(short lucidity, String[] keywords) {
		this.lucidity = lucidity;
		this.keywords = keywords;
	}
	
	public Dream(JSONObject json) throws JSONException{
		abstraction = json.getString(JSON_TITLE);
		
		scenarios = new ArrayList<ScenarioNote>();
		ScenarioNote s = new ScenarioNote();
		s.setContent(json.getString(JSON_CONTENT));
		scenarios.add(s);
		
		lastEditedTime = (Date)json.get(JSON_DATE);
	}
	
	// use JSON

	public Object toJSON() throws JSONException {
		//To be modified: the data relations are not designed, after redesign the database, 
		//this part should be updated.
		JSONObject json = new JSONObject();
		json.put(JSON_TITLE, abstraction);
		json.put(JSON_CONTENT, scenarios.get(0).getContent());
		json.put(JSON_DATE, lastEditedTime);
		return json;
		
	}
	
	public String toString(){
		return abstraction;
	}
	

	
	// inner classes: Note, Recording
}
