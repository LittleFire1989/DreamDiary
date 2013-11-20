package org.mengker.dream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class DreamNotebook {
	private ArrayList<Dream> dreams;

	public float avgLucidityRate() {
		return Dream.avgLucidityRate(this.dreams);
	}

	public Calendar avgSleepStartTime() {
		return Dream.avgSleepStartTime(this.dreams);
	}

	public Calendar avgSleepEndTime() {
		return Dream.avgSleepEndTime(this.dreams);
	}

	public Entry<String, Integer>[] mostOftenWords() {
		ArrayList<String> contents = new ArrayList<String>();
		for(int i = 0; i < dreams.size(); i++){
			contents.add(dreams.get(i).getNote().getContent());
		}
		return Dream.mostOftenWords((String[]) contents.toArray(), 10);
	}
}
