package com.dreamingkid.dreamdiary;

import com.dreamingkid.dreamdiary.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewDreamActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_dream);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dream_edit, menu);
		return true;
	}

}
