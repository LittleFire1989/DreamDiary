package org.mengker.dreamdiary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mengker.bean.User;
import org.mengker.net.Operation;
import org.mengker.util.WriteJson;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	 private EditText etUsername=null;
	 private EditText etEmail = null;
	 private EditText etPassword = null;
	 private EditText etRePassword = null;
	 private TextView tvCreateAccount= null;
	 private Button cButton = null;
	 
	 String jsonString=null;
	 ProgressDialog dialog;
     
	 String username;
	 String password;
	 String email;
	 String rePassword;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register);
                
                etUsername=(EditText)findViewById(R.id.addUsernameEditText);
           	    etEmail=(EditText)findViewById(R.id.addEmailEditText);
           	    etPassword=(EditText)findViewById(R.id.addPasswordEditText);
           	    etRePassword=(EditText)findViewById(R.id.rePasswordEditText);
           	    tvCreateAccount=(TextView)findViewById(R.id.createAccountTextView);
           	    cButton= (Button)findViewById(R.id.createButton);
           	    dialog=new ProgressDialog(RegisterActivity.this);
           	    dialog.setTitle("Registering");
           	    dialog.setMessage("In progress");
           	    
           	    cButton.setOnClickListener(new SubmitOnclick());
        }
        
        private class SubmitOnclick implements OnClickListener
    	{
    		public void onClick(View v) {
    			username=etUsername.getText().toString().trim();
    			password=etPassword.getText().toString().trim();
    			rePassword = etRePassword.getText().toString().trim();
    			email = etEmail.getText().toString().trim();
    			
    			if (username == null || username.length() == 0) 
    			{  
    				etUsername.requestFocus();
    				etUsername.setError("Please input username correctly");			
    				return ;
    			}
    			System.out.println(password + " and " + rePassword);
    			if (!password.equals(rePassword)) 
    			{  
    				etUsername.requestFocus();
    				etUsername.setError("Please input password correctly");			
    				return ;
    			}

    			dialog.show();
    			new Thread(new Runnable() {

    				public void run() {

    					Operation operaton=new Operation();
    					
    					System.out.println("username---->"+username);
    					System.out.println("password--->"+ password);
    					User user=new User(username, password, email);
    					
    					List<User> list=new ArrayList<User>();
    					list.add(user);
    					WriteJson writeJson=new WriteJson();
    					
    					jsonString= writeJson.getJsonData(list);
                        System.out.println(jsonString); 
    					String result= operaton.register("Register", jsonString);
    					Message msg=new Message();
    					System.out.println("result---->"+result);
    					msg.obj=result;
    					handler1.sendMessage(msg);
    				}
    			}).start();

    		}
    	}
        
        Handler handler1=new Handler()
    	{
    		@Override
    		public void handleMessage(Message msg) {
    			dialog.dismiss();
    			String msgobj=msg.obj.toString();
    			if(msgobj.equals("t"))
    			{
    				Toast.makeText(RegisterActivity.this, "Register success", 0).show();
    				Intent intent=new Intent();
    				intent.setClass(RegisterActivity.this, LoginActivity.class);
    				startActivity(intent);
    			}
    			else {
    				Toast.makeText(RegisterActivity.this, "Register unsuccessful", 0).show();
    			}
    			super.handleMessage(msg);
    		}	
    	};

}
