package org.mengker.dreamdiary;

import org.mengker.dream.Dream;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class RecordActivity extends Activity {

	private Dream dream;
	private int lucidity = Dream.NORMAL;
	private String content;
	private RadioGroup lucidityRadioGroup;
	private TextView testDreamRecordTextView;
	private EditText dreamRecordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		lucidityRadioGroup = (RadioGroup) this.findViewById(R.id.lucidityRadioGroup);
		dreamRecordEditText = (EditText) this.findViewById(R.id.dreamRecordEditText);
this.testDreamRecordTextView = (TextView) this.findViewById(R.id.testDreamRecordTextView);
		lucidityRadioGroup.setOnCheckedChangeListener(new LucidityRadioOnCheckedChangeListener());
		dreamRecordEditText.setOnEditorActionListener(new ContentOnEditorActionListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}
	
	class LucidityRadioOnCheckedChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.normalRadio:
				lucidity = Dream.NORMAL;
				break;
			case R.id.halfLucidRadio:
				lucidity = Dream.HALFLUCID;
				break;
			case R.id.lucidRadio:
				lucidity = Dream.LUCID;
				break;
			default:
				lucidity = Dream.NORMAL;
			}
		}

	}
	
	class ContentOnEditorActionListener implements OnEditorActionListener{

		@Override
		public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
			// TODO Auto-generated method stub
			return false;
		}

		
		
	}

}


