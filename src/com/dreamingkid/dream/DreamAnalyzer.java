package com.dreamingkid.dream;

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


public class DreamAnalyzer {
	private List<Dream> dreams;
	
	//static methods
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
		
		topWords = new Entry[wordArray.length <topX ? wordList.size():topX];
		for(int i = 0; i < topWords.length; i++){
			topWords[i] = wordArray[i];
		}
		
		return topWords;
	}
	
	//private methods
	private Calendar calcAvgTime(Date[] timeArray) {
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
	
	//public methods
	public void setDreams(List<Dream> dreams){
		this.dreams = dreams;
	}
	
	public float avgLucidityRate() {
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

	public Calendar avgSleepStartTime() {

		int size = dreams.size();
		Date[] timeArray = new Date[size];
		for (int i = 0; i < size; i++) {
			timeArray[i] = dreams.get(i).getSleep().getBeginTime();
		}
		return calcAvgTime(timeArray);
	}

	public Calendar avgSleepEndTime() {
		int size = dreams.size();
		Date[] timeArray = new Date[size];
		for (int i = 0; i < size; i++) {
			timeArray[i] = dreams.get(i).getSleep().getEndTime();
		}
		return calcAvgTime(timeArray);
	}

	public long avgSleepDuration(){
		long duration = this.avgSleepEndTime().getTime().getTime() - this.avgSleepStartTime().getTime().getTime();
		return duration;
	}
	
	public Map.Entry<String, Integer>[] mostOftenWords(int topX) {
		ArrayList<String> contents = new ArrayList<String> ();
		for(int i = 0; i < dreams.size(); i++){
			String content = "";

			content = content + dreams.get(i).getContent();

			contents.add(content);
		}
		return mostOftenWords((String[])contents.toArray(), topX);
	}
}
