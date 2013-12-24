package com.dreamingkid.dreamdiary;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;








import com.dreamingkid.dreamdiary.R;
import com.dreamingkid.net.Operation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//sas
public class LoginActivity extends Activity {
	private EditText etusername = null;
	private EditText etpassword = null;
	private Button loginButton;
	private Button skipButton;
	private Button mButton2;
	private Button mButton3 ;
	private String username;
	private String password;
	ProgressDialog p;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		etusername = (EditText) findViewById(R.id.usernameEditText);
		etpassword = (EditText) findViewById(R.id.passwordEditText);
		loginButton = (Button) findViewById(R.id.loginButton);
		skipButton = (Button) findViewById(R.id.skipButton);
		mButton2 = (Button) findViewById(R.id.facebookLoginButton);
		mButton3 = (Button) findViewById(R.id.registerButton);
		
		p=new ProgressDialog(LoginActivity.this);
		p.setTitle("Connecting to Server");
		p.setMessage("In Progress");
		
		etusername.setHint("Username");
		etpassword.setHint("Password");
		
		loginButton.setOnClickListener(new LoginOnclick() );
		
		skipButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(LoginActivity.this, DiaryBookActivity.class);
				startActivity(intent);
				finish();
				
			}
			
		});

		mButton2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				etusername.setText("");
				etpassword.setText("");
			}
		});
		
		mButton3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	
	private class LoginOnclick implements OnClickListener
	{	
		
		public void onClick(View view) {
			username=etusername.getText().toString().trim();
			if (username==null||username.length()<=0) 
			{		
				etusername.requestFocus();
				etusername.setError("Invalid Username");
				return;
			}else 
			{
				username=etusername.getText().toString().trim();
			}
			
			password=etpassword.getText().toString().trim();
			if (password==null||password.length()<=0) 
			{		
				etpassword.requestFocus();
				etpassword.setError("Invalid password");
				return;
			}else 
			{
				password=etpassword.getText().toString().trim();
			}
			p.show();
			new Thread(new Runnable() {

				public void run() {
					Operation operaton=new Operation();
					String result=operaton.login("Login", username, password);		
					Message msg=new Message();
					msg.obj=result;
					handler.sendMessage(msg);
				}
			}).start();

		}
	}	
	Handler handler=new Handler(){
		@Override
		public void handleMessage(Message msg) {
			String string=(String) msg.obj;
			p.setMessage(string);
			p.dismiss();
			if(string.equals("Successful")) {
				Toast.makeText(LoginActivity.this, string, 0).show();
				Intent intent = new Intent(LoginActivity.this, DiaryBookActivity.class);
				startActivity(intent);
				//finish();
			}
			if(string == null|| string.length() == 0) etusername.setText("Nothing");
			else etusername.setText(string);
			//Toast.makeText(LoginActivity.this, string, 0).show();
			super.handleMessage(msg);
		}	
	};
}