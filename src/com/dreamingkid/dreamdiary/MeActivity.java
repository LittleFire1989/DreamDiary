package com.dreamingkid.dreamdiary;

import java.util.ArrayList;

import com.dreamingkid.dreamdiary.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

public class MeActivity extends ListActivity {
	ArrayList<String> items = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_me);
		
		String[] itemArray;
		
		items.add(this.getResources().getString(R.string.me_me));
		items.add(this.getResources().getString(R.string.me_facebook));
		items.add(this.getResources().getString(R.string.me_dream_reports));
		items.add(this.getResources().getString(R.string.me_settings));
		
		itemArray = new String[items.size()];
		itemArray = items.toArray(itemArray);
		
		setListAdapter(new ArrayAdapter<String>(this,
				 android.R.layout.simple_list_item_1, itemArray));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.me, menu);
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

	 public void startMeActivity(View view) {
	 Intent intent = new Intent(this, MeActivity.class);
	 startActivity(intent);
	 }
}
