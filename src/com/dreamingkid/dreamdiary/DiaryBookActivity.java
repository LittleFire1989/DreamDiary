package com.dreamingkid.dreamdiary;

import java.util.ArrayList;

import com.dreamingkid.dreamdiary.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

/*
 * Programming plan:
 * Step 1: create a simple dream with AddDreamActivity, the data then are stored in the phone
 * Step 2: new dreams and old dreams can be displayed in the diary book
 * Step 3: every item in the list can be edit or delete, edit dream is another activity
 */


public class DiaryBookActivity extends ListActivity {
	Button createNewDreamDiary;
	ArrayList<String> items = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary_book);
		createNewDreamDiary = (Button) this
				.findViewById(R.id.addDream);
		createNewDreamDiary.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(DiaryBookActivity.this,
						AddDreamActivity.class);
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
/*
 * The first version only has the dream record function
 * 
	// navigate
	public void startDiaryBookActivity(View view) {
		Intent intent = new Intent(this, DiaryBookActivity.class);
		startActivity(intent);
	}

	public void startExploreActivity(View view) {
		Intent intent = new Intent(this, ExploreActivity.class);
		startActivity(intent);
	}

	 public void startMeActivity(View view) {
	 Intent intent = new Intent(this, MeActivity.class);
	 startActivity(intent);
	 }
*/

}
