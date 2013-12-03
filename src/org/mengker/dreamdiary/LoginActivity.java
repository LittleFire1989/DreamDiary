package org.mengker.dreamdiary;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final EditText mEditText1 = (EditText) findViewById(R.id.usernameEditText);
		final EditText mEditText2 = (EditText) findViewById(R.id.passwordEditText);
		final Button mButton1 = (Button) findViewById(R.id.loginButton);
		final Button mButton2 = (Button) findViewById(R.id.facebookLoginButton);
		final Button mButton3 = (Button) findViewById(R.id.registerButton);
		mEditText1.setHint("Username");
		mEditText2.setHint("Password");
		// ~~~~~~~~~~~~~~鐧诲綍~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		mButton1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean flag = false;
				String q = mEditText1.getText().toString();
				String pass = mEditText2.getText().toString();
				Intent intent2 = new Intent();
				Intent intent3 = new Intent();
				intent2.setClass(LoginActivity.this, RegisterActivity.class);
				intent3.setClass(LoginActivity.this, NewDreamActivity.class);
				RegisterActivity qq = new RegisterActivity();
				qq.QDatabase = openOrCreateDatabase(qq.DATABASE_NAME,
						MODE_PRIVATE, null);// 鎵撳紑鏁版嵁搴�
				// ~~~~~~~~~~~~~~~~~~鐢–ursor绫绘潵鎺ユ敹鏌ヨ鍒扮殑鏁版嵁~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				Cursor cursor = qq.QDatabase.query(qq.TABLE_NAME, new String[] {
						qq.QQ, qq.PASS }, null, null, null, null, null);
				// ~~~~~~~~~~~~~~~~~鐢╠o..while寰幆楠岃瘉鏂囨湰妗嗚緭鍏ョ殑鍐呭鏄惁鍜屾暟鎹簱鐨勫惢鍚堬紝鏄氨灏唂lag鏀逛负true~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				if (cursor != null) {
					if (cursor.moveToFirst()) {
						do {
							if (q.equals(cursor.getString(0))
									&& pass.equals(cursor.getString(1))) {
								flag = true;
							}
						} while (cursor.moveToNext());
					}
				}
				// ~~~~~~~~~~~~~~~~~~~楠岃瘉~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				if (flag) {
					startActivity(intent2);
				} else {
					startActivity(intent3);
				}
				qq.QDatabase.close();// 鍏抽棴
			}
		});
		// ~~~~~~~~~~~~~~~閲嶇疆~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		mButton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				mEditText1.setText("");
				mEditText2.setText("");
			}
		});
		// ~~~~~~~~~~~~~~娉ㄥ唽QQ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		mButton3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
}