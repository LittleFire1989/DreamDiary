package org.mengker.dreamdiary;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WelcomeMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome_main, menu);
		return true;
	}

}