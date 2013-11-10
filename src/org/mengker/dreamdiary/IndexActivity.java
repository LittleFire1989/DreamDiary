package org.mengker.dreamdiary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends Activity {
	
	Button testLoginActivityButton;
	Button testRegisterActivityButton;
	Button testRecordActivityButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		testLoginActivityButton= (Button) findViewById(R.id.testLoginActivityButton);
		testRegisterActivityButton= (Button) findViewById(R.id.testRegisterActivityButton);
		testRecordActivityButton= (Button) findViewById(R.id.testRecordActivityButton);
		
//		final Intent loginIntent = new Intent(this, LoginActivity.class);
//		final Intent RecordIntent = new Intent(this, RecordActivity.class);
//		final Intent RegisterIntent = new Intent(this, RegisterActivity.class);
//		
		setContentView(R.layout.activity_index);
		
//		testLoginActivityButton.setOnClickListener(new OnClickListener(){
//			public void onClick(View v) {
//
//				startActivity(loginIntent);
//				
//			}
//		});
//		
//		testRegisterActivityButton.setOnClickListener(new OnClickListener(){
//			public void onClick(View v) {
//
//				startActivity(RecordIntent);
//				
//			}
//		});
//		
//		testRecordActivityButton.setOnClickListener(new OnClickListener(){
//			public void onClick(View v) {
//
//				startActivity(RegisterIntent);
//				
//			}
//		});
//		
//		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}
