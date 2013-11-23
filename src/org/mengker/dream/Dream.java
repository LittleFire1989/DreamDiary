package org.mengker.dream;


import java.util.Date;

/* To be modified:
 * publish()
 * editDream()
 * inner class: Note, Recording
 *  
 */

public class Dream {
	public static String[] DEFAULT_KEYWORDS = { "middle school", "fly", "chase" };
	public static final short NORMAL = 1;
	public static final short HALFLUCID = 2;
	public static final short LUCID = 3;

	private String[] keywords;
	private short lucidity;
	private Date sleepStartTime;
	private Date sleepEndTime;
	private Date lastEditedTime;
	private Note note;
	private Recording[] recordings;

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

	public void setNote(Note note) {
		this.note = note;
	}

	public void setRecordings(Recording[] recordings) {
		this.recordings = recordings;
	}

	public String[] getKeywords() {
		return this.keywords;
	}

	public short getLucidity() {
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
	public Note getNote() {
		
		return this.note;
	}
	public Recording[] getRecordings() {
		return this.recordings;
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

	class Note {
		private String content;
		private Date lastEditedTime;
		
		// gets		
		public String getContent(){
			return content;
		}
		public Date getLastEditedTime(){
			return this.lastEditedTime;
		}
		
		// sets
		public void setContent(String content){
			this.content = content;
		}
		public void setLastEditedTime(Date lastEditedTime){
			this.lastEditedTime = lastEditedTime;
		}
		
		
		// others
		public void edit() {

		}

		public void delete() {

		}
	}

	class Recording {
		private Date startTime;
		private Date endTime;

		public void record() {

		}

		public void delete() {

		}
	}
}
