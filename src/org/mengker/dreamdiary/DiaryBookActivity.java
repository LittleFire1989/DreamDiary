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
	ArrayList<String> items = new ArrayList<String>();
	String[] testItems = {"best", "second", "first"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary_book);
		createNewDreamDiary = (Button) this
				.findViewById(R.id.createNewDreamDiary);
		createNewDreamDiary.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(DiaryBookActivity.this,
						NewDreamActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// get information from new dream
		Intent intent = getIntent();

		String dreamTime = intent.getStringExtra("dream_time");
		String dreamTitle = intent.getStringExtra("dream_title");
		
		if(dreamTime!=null && dreamTitle != null){
			items.add(dreamTime + " " + dreamTitle);
		}
		
		String itemArray[] = new String[items.size()];
		for(int i = 0; i < itemArray.length; i++){
			itemArray[i] = (String)items.get(i);
		}
		 setListAdapter(new ArrayAdapter<String>(this,
		 android.R.layout.simple_list_item_1, itemArray));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dreams, menu);
		return true;
	}

	// navigate
	public void startDiaryBookActivity(View view) {
		Intent intent = new Intent(this, DiaryBookActivity.class);
		startActivity(intent);
	}

	public void startExploreActivity(View view) {
		Intent intent = new Intent(this, ExploreActivity.class);
		startActivity(intent);
	}

	// public void startMeActivity(View view) {
	// Intent intent = new Intent(this, MeActivity.class);
	// startActivity(intent);
	// }

}
