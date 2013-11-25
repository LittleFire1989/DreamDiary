package org.mengker.dreamdiary;

import org.mengker.dream.Dream;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class RecordActivity extends Activity {

	private Dream dream;
	private int lucidity = Dream.NORMAL;
	private String content;
	private RadioGroup lucidityRadioGroup;
	private TextView testDreamRecordTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record);
		lucidityRadioGroup = (RadioGroup) this
				.findViewById(R.id.lucidityRadioGroup);
this.testDreamRecordTextView = (TextView) this.findViewById(R.id.testDreamRecordTextView);
		lucidityRadioGroup
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

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
testDreamRecordTextView.setText(String.valueOf(lucidity));
					}

				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.record, menu);
		return true;
	}

}
