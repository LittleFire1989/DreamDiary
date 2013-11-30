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
		// ~~~~~~~~~~~~~~登录~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		mButton1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean flag = false;
				String q = mEditText1.getText().toString();
				String pass = mEditText2.getText().toString();
				Intent intent2 = new Intent();
				Intent intent3 = new Intent();
				intent2.setClass(LoginActivity.this, RegisterActivity.class);
				intent3.setClass(LoginActivity.this, RecordActivity.class);
				RegisterActivity qq = new RegisterActivity();
				qq.QDatabase = openOrCreateDatabase(qq.DATABASE_NAME,
						MODE_PRIVATE, null);// 打开数据库
				// ~~~~~~~~~~~~~~~~~~用Cursor类来接收查询到的数据~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				Cursor cursor = qq.QDatabase.query(qq.TABLE_NAME, new String[] {
						qq.QQ, qq.PASS }, null, null, null, null, null);
				// ~~~~~~~~~~~~~~~~~用do..while循环验证文本框输入的内容是否和数据库的吻合，是就将flag改为true~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
				// ~~~~~~~~~~~~~~~~~~~验证~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				if (flag) {
					startActivity(intent2);
				} else {
					startActivity(intent3);
				}
				qq.QDatabase.close();// 关闭
			}
		});
		// ~~~~~~~~~~~~~~~重置~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		mButton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				mEditText1.setText("");
				mEditText2.setText("");
			}
		});
		// ~~~~~~~~~~~~~~注册QQ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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