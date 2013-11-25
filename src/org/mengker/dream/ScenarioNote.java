package org.mengker.dream;

import java.util.ArrayList;
import java.util.Date;

/*
 * To be modified:
 * 1. get and set for recordings
 * 2. the implementation for recording
 */

public class ScenarioNote {
	private String content;
	private Date lastEditedTime;
	private ArrayList<Recording> recordings;

	// gets
	public String getContent() {
		return content;
	}

	public Date getLastEditedTime() {
		return this.lastEditedTime;
	}

	// sets
	public void setContent(String content) {
		this.content = content;
	}

	public void setLastEditedTime(Date lastEditedTime) {
		this.lastEditedTime = lastEditedTime;
	}

	// others
	public void edit() {

	}

	public void delete() {

	}

	class Recording {
		private Date startTime;
		private Date endTime;
		
		//gets
		public Date getStartTime(){
			return this.startTime;
		}
		public Date getEndTime(){
			return this.endTime;
		}
		
		//sets
		public void setStartTime(Date startTime){
			this.startTime = startTime;
		}
		public void setEndTime(Date endTime){
			this.endTime = endTime;
		}
		
		//others

		public void record() {
			
		}

		public void delete() {

		}
	}
}
