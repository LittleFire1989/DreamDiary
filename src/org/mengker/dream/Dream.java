package org.mengker.dream;


import java.util.ArrayList;
import java.util.Date;

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

	
	// inner classes: Note, Recording
}
