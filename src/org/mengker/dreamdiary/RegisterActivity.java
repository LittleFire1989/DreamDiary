package org.mengker.dreamdiary;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
        Button mButton2=null;
        public  SQLiteDatabase QDatabase=null;
        public  String DATABASE_NAME="QQDataBase.db";
        public  String TABLE_NAME="myqq";
        public  String QQ="qq";
        public  String PASS="pass";
        TextView mTextView3=null;
        String sql="create table QQ(qq text primary key,pass text not null)";
        //String sql="insert into QQ(qq,pass) value("+QQ+","+PASS+")";
        private final String CREATE_TABLE="create table if not exists "+TABLE_NAME+" ("+QQ+" int primary key, "+PASS+" text)";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                // TODO Auto-generated method stub
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register);
                final EditText mEditText1=(EditText)findViewById(R.id.editText1);
                final EditText mEditText2=(EditText)findViewById(R.id.editText2);
                mTextView3=(TextView)findViewById(R.id.textView3);
                final Button mButton=(Button)findViewById(R.id.button1);
                mButton2=(Button)findViewById(R.id.button2);
                //~~~~~~~~~~~~~~注册QQ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                mButton.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                // TODO Auto-generated method stub
                                QDatabase=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
                                QDatabase.execSQL(CREATE_TABLE);
                                ContentValues cv=new ContentValues();
                                cv.put(QQ, mEditText1.getText().toString());
                                cv.put(PASS, mEditText2.getText().toString());
                                QDatabase.insert(TABLE_NAME, null, cv);
                                showData();
                                QDatabase.close();
                                
                        }
                });
                //~~~~~~~~~~~~~~~~~删除QQ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                mButton2.setOnClickListener(new OnClickListener() {
                        
                        @Override
                        public void onClick(View v) {
                                // TODO Auto-generated method stub
                                QDatabase=openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
                                String whereClause="QQ=?";
                                String[] whereArgs={mEditText1.getText().toString()};
                                QDatabase.delete(TABLE_NAME, whereClause, whereArgs);
                                showData();
                                QDatabase.close();
                        }
                });
        }
        public void showData(){
                mTextView3.setText("QQ用户资料"+"\n");
                mTextView3.append("QQ\t\t密码\n");
                String str[]={QQ,PASS};
                Cursor cur=QDatabase.query(TABLE_NAME, str, null, null, null, null, null);
                if(cur!=null){
                        if(cur.moveToFirst()){
                                do {
                                        String qqString=cur.getString(0);
                                        String passString=cur.getString(1);
                                        mTextView3.append(qqString+"\t\t"+passString+"\n");
                                } while (cur.moveToNext());
                        }
                }
        }

}
