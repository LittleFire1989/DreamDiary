package org.mengker.dreamdiary;

import org.mengker.dream.Dream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RecordActivity extends Activity {
	
	private Dream dream;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}

}
