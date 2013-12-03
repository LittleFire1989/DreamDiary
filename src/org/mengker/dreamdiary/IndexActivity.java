package org.mengker.dreamdiary;

import org.mengker.share.ShareActivity;

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
			
		setContentView(R.layout.activity_index);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}
	
	public void startLoginActivity(View view) {
	    Intent intent = new Intent(this, LoginActivity.class);
	    startActivity(intent);
	}
	
	public void startRegisterActivity(View view) {
	    Intent intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
	}
	
	public void startRecordActivity(View view) {
	    Intent intent = new Intent(this, NewDreamActivity.class);
	    startActivity(intent);
	}
	
	public void startShareActivity(View view) {
	    Intent intent = new Intent(this, ShareActivity.class);
	    startActivity(intent);
	}
	
	public void startDreamsActivity(View view) {
	    Intent intent = new Intent(this, DiaryBookActivity.class);
	    startActivity(intent);
	}

}
