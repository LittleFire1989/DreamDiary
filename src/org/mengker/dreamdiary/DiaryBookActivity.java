package org.mengker.dreamdiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DiaryBookActivity extends Activity {
	Button createNewDreamDiary;
	DiaryBookActivity da = this;

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
