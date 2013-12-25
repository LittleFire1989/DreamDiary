package com.dreamingkid.dreamdiary;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.dreamingkid.dream.Dream;
import com.dreamingkid.util.DreamIntentJSONSerializer;

public class DiaryBook {
	private static final String TAG = "DiaryBook";
	private static final String FILENAME = "dreams.json";
	
	public ArrayList<Dream> mDreams;
	private DreamIntentJSONSerializer mSerializer;
	
	private static DiaryBook sDiaryBook;
	private Context mAppContext;
	
	public DiaryBook(Context appContext){
		mAppContext = appContext;
		mSerializer = new DreamIntentJSONSerializer(mAppContext, FILENAME);
		
		try{
			mDreams = mSerializer.loadDreams();
		} catch(Exception e){
			mDreams = new ArrayList<Dream>();
			Log.e(TAG, "Error loading dreams: ", e);
		}
	}
	
	public void addDream(Dream d){
		mDreams.add(d);
	}
	
	public boolean saveDreams(){
		// In a real-world application, you would want to alert the user if saving fails,
		// for example, with a Toast or a dialog.
		try{
			mSerializer.saveCrimes(mDreams);
			Log.d(TAG, "dreams saved to file");
			return true;
		} catch(Exception e){
			Log.e(TAG, "Error saving crimes: ", e);
			return false;
		}
	}
}
