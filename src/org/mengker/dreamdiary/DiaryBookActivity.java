package org.mengker.dreamdiary;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class DiaryBookActivity extends ListActivity {
	Button createNewDreamDiary;
	ArrayList<String> items;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary_book);
		createNewDreamDiary = (Button) this.findViewById(R.id.createNewDreamDiary);
		createNewDreamDiary.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(DiaryBookActivity.this, NewDreamActivity.class);
			    startActivity(intent);
			    finish();
			}
		});
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String dreamTime = extras.getString("dream_time");
			String dreamTitle = extras.getString("dream_title");
			items.add(dreamTime+" "+dreamTitle);
		}
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				(String[])items.toArray()));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dreams, menu);
		return true;
	}
	
	//navigate	
	public void startDiaryBookActivity(View view) {
	    Intent intent = new Intent(this, DiaryBookActivity.class);
	    startActivity(intent);
	}
	
	public void startExploreActivity(View view) {
	    Intent intent = new Intent(this, ExploreActivity.class);
	    startActivity(intent);
	}
	
//	public void startMeActivity(View view) {
//	    Intent intent = new Intent(this, MeActivity.class);
//	    startActivity(intent);
//	}

}
