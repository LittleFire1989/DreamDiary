package com.dreamingkid.dreamdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dreamingkid.dream.Dream;

public class DreamDatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "dreams.sqlite";
	private static final int VERSION = 1;
	
	private static final String TABLE_DREAM = "dream";
	private static final String COLUMN_DREAM_CONTENT = "content";
	private static final String COLUMN_DREAM_TITLE = "title";
	private static final String COLUMN_DREAM_EDIT_TIME = "edit_time";

	public DreamDatabaseHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//Create the "sleep" table
		db.execSQL("create table sleep "
				+ "(sleep_id integer primary key autoincrement, begin_time integer, end_time integer");
				
		//Create the "dream" table
		db.execSQL("create table dream (" +
				"dream_id integer primary key autoincrement, sleep_id integer references sleep(sleep_id) "
				+ "content text, title text, edit_time integer)");
		//Create the "label" table
		db.execSQL("create table label (label_name varchar(20) primary key, "
				+ "description text, available_num integer, used_num integer)");
		
		//Create the "dream_labels" table
		db.execSQL("create table dream_labels (dream_id integer primary key references dream(dream_id), "
				+ "label_name varchar(20) primary key references label(label_name))");
		
		//Create the "recording" table
		db.execSQL("create table recording (recording_id integer primary key autoincrement, "
				+ "dream_id integer references dream(dream_id), record_time integer, duration integer)");
		
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// Implement schema changes and data massage here when upgrading
		
	}
	
	public long insertDream(Dream d){
		// Hasn't deal with the attribute sleep_id
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_DREAM_CONTENT, d.getContent());
		cv.put(COLUMN_DREAM_TITLE, d.getTitle());
		cv.put(COLUMN_DREAM_EDIT_TIME, d.getLastEditedTime().getTime());
		return getWritableDatabase().insert(TABLE_DREAM, null, cv);
	}
	
}
