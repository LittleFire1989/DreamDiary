package org.mengker.dream;

import java.util.Calendar;
import java.util.Date;

/*
 * To be modified:
 * Move the analyze methods from Dream to DreamAnalyzer
 */

public class DreamAnalyzer {
	private float avgLucidityRate;
	private Calendar avgSleepStartTime;
	private Calendar avgSleepEndTime;
	private String[] mostOftenWords;

	public DreamAnalyzer(float avgLucidityRate, Calendar avgSleepStartTime,
			Calendar avgSleepEndTime, String[] mostOftenWords) {
		this.avgLucidityRate = avgLucidityRate;
		this.avgSleepStartTime = avgSleepStartTime;
		this.avgSleepEndTime = avgSleepEndTime;
		this.mostOftenWords = mostOftenWords;
	}
	
	public DreamAnalyzer(DreamNotebook notebook){
		this.avgLucidityRate = notebook.avgLucidityRate();
		this.avgSleepStartTime = notebook.avgSleepStartTime();
		this.avgSleepEndTime = notebook.avgSleepEndTime();
//		this.mostOftenWords = notebook.mostOftenWords();
	}
}
