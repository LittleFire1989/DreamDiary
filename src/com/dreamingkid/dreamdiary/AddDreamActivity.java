package com.dreamingkid.dreamdiary;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamingkid.dream.Dream;
import com.dreamingkid.dream.Scenario;

/*
 * Programming plan:
 * Step 0: display with fancy list; click the items will navigate to the view dream
 * --> Complete
 * Step 1: create a simple dream with AddDreamActivity, the data then are stored in the phone
 * Step 2: new dreams and old dreams can be displayed in the diary book
 * Step 3: every item in the list can be edit or delete, edit dream is another activity
 */

public class AddDreamActivity extends Activity {
	ImageView saveImageButton;
	EditText dreamContentEditText;
	TextView textLoadDataTextView;
	
	private DiaryBook book;
	private Dream d;
	
	String dreamTime = "dreamTime";
	String dreamTitle = "dreamTitle";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_dream);

		// define widgets
		saveImageButton = (ImageView) this.findViewById(R.id.saveImageView);
		dreamContentEditText = (EditText) this
				.findViewById(R.id.dreamContentEditText);
		textLoadDataTextView = (TextView) this.findViewById(R.id.textLoadDataTextView);

		saveImageButton
				.setOnClickListener(new SaveImageViewOnClickListener());

		book = new DiaryBook(this.getBaseContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_dream, menu);
		return true;
	}
	

	class SaveImageViewOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			d = new Dream();
			
			d.setAbstraction(dreamContentEditText.getText().toString());
			d.setLastEditedTime(new Date());
			
			Scenario s= new Scenario();
			s.setContent(dreamContentEditText.getText().toString());
			ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
			scenarios.add(s);
			d.setScenarios(scenarios);
			
			book.addDream(d);
			
			book.saveDreams();
		}

	}

}
