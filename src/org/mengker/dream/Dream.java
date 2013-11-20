package org.mengker.dream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* To be modified:
 * publish()
 * editDream()
 * inner class: Note, Recording
 * Move the analyze methods from Dream to DreamAnalyzer
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

	public static float avgLucidityRate(List<Dream> dreams) {
		int numOfLucidDream = 0;
		int numOfHalfLucidDream = 0;
		float avgLucidityRate = 0f;

		if (dreams == null || dreams.size() == 0)
			return avgLucidityRate;
		else {
			for (int i = 0; i < dreams.size(); i++) {
				if (dreams.get(i).getLucidity() == Dream.LUCID) {
					numOfLucidDream++;
					continue;
				}
				if (dreams.get(i).getLucidity() == Dream.HALFLUCID) {
					numOfHalfLucidDream++;
				}
			}
			avgLucidityRate = ((float) numOfLucidDream + 0.5f * numOfHalfLucidDream)
					/ dreams.size();
			return avgLucidityRate;
		}
	}

	public static Calendar avgSleepStartTime(List<Dream> dreams) {

		int size = dreams.size();
		Date[] timeArray = new Date[size];
		for (int i = 0; i < size; i++) {
			timeArray[i] = dreams.get(i).getSleepStartTime();
		}
		return calcAvgTime(timeArray);
	}

	public static Calendar avgSleepEndTime(List<Dream> dreams) {
		int size = dreams.size();
		Date[] timeArray = new Date[size];
		for (int i = 0; i < size; i++) {
			timeArray[i] = dreams.get(i).getSleepEndTime();
		}
		return calcAvgTime(timeArray);
	}

	private static Calendar calcAvgTime(Date[] timeArray) {
		int length = timeArray.length;
		GregorianCalendar[] calendars = new GregorianCalendar[length];
		int total = 0;
		int avg = 0;
		int avgHour = 0;
		int avgMin = 0;
		GregorianCalendar avgCalendar = new GregorianCalendar();

		for (int i = 0; i < length; i++) {
			calendars[i].setTime(timeArray[i]);
			int hour = calendars[i].get(Calendar.HOUR_OF_DAY);
			int min = calendars[i].get(Calendar.MINUTE);
			int time = min + hour * 60;
			total = total + time;
		}

		avg = total / length;
		avgHour = avg / 60;
		avgMin = avg % 60;
		avgCalendar.set(Calendar.HOUR_OF_DAY, avgHour);
		avgCalendar.set(Calendar.MINUTE, avgMin);

		return avgCalendar;
	}

	public static Map.Entry<String, Integer>[] mostOftenWords(String[] contents, int topX) {

		HashMap<String, Integer> wordList = new HashMap<String, Integer>();
		Matcher m;
		Pattern p = Pattern.compile("\\w+");
		Entry<String, Integer>[] topWords;

		for (int i = 0; i < contents.length; i++) {
			String content = contents[i];
			m = p.matcher(content);
			while (m.find()) {
				String word = m.group();
				if (wordList.containsKey(word)) {
					wordList.put(word, wordList.get(word) + 1);
				} else {
					wordList.put(word, 1);
				}
			}
		}
		Map.Entry<String, Integer>[] wordArray = (Map.Entry<String, Integer>[])wordList.entrySet().toArray();
		Arrays.sort(wordArray, new Comparator<Map.Entry<String, Integer>>(){

			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				if(o1.getValue() > o2.getValue())
					return 1;
				else if(o1.getValue() == o2.getValue())
					return 0;
				else
					return -1;
			}
		});
		
		Arrays.sort(wordArray, Collections.reverseOrder());
		
		topWords = new Entry[wordArray.length < topX ? wordList.size():topX];
		for(int i = 0; i < topWords.length; i++){
			topWords[i] = wordArray[i];
		}
		
		return topWords;
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
