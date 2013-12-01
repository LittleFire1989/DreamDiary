package org.mengker.share;

import java.util.ArrayList;
import java.util.List;

import org.mengker.dreamdiary.R;
import org.mengker.dreamdiary.R.layout;
import org.mengker.dreamdiary.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ShareActivity extends Activity {
	private List<Share> wbList;
	private LinearLayout loadingLayout=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share);
		
		loadList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.share, menu);
		return true;
	}
	
	private void loadList() {
		//loadingLayout=(LinearLayout)findViewById(R.id.loadingLayout);
		
		
			// 显示当前用户名称
			//TextView showName = (TextView) findViewById(R.id.showName);
			//showName.setText("TestUserName");

			
			
			if (true) {
				//connection
							
							if (wbList == null) {
								wbList = new ArrayList<Share>();
							}
							Share w = new Share("shareid","userid","message","username");
							/*
							w.setId();
							w.setUserId(userId);
							w.setUserName(userName);
							w.setTime(time);
							w.setText(text);

							w.setHaveImage(haveImg);
							w.setUserIcon(userIcon);
							wbList.add(w);
							*/
							wbList.add(w);
							 w = new Share("shareid2","userid2","message2","username2");
							 wbList.add(w);
			}

			if (wbList != null) {
				
				ShareAdapter adapater = new ShareAdapter();
				ListView Msglist = (ListView) findViewById(R.id.Msglist);
				
				Msglist.setAdapter(adapater);
			
			}
				
		 //loadingLayout.setVisibility(View.GONE);
	}
	public class ShareAdapter extends BaseAdapter {
		

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return wbList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return wbList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if (convertView == null) {
				convertView = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.share, null);
			}

			
			//ImageView tempIV = (ImageView) convertView.findViewById(R.id.wbicon);
			TextView tempTV = (TextView) convertView.findViewById(R.id.dreamDetailstextView);
			//wh.wbtime = (TextView) convertView.findViewById(R.id.wbtime);
			TextView tempUser = (TextView) convertView.findViewById(R.id.userNameTextView);
			//wh.wbimage = (ImageView) convertView.findViewById(R.id.wbimage);
			Share wb = wbList.get(position);
			if (wb != null) {
				convertView.setTag(wb.getShareID());
				tempTV.setText(wb.getUserName());
				tempUser.setText(wb.getMessage(), TextView.BufferType.SPANNABLE);
				// textHighlight(wh.wbtext, new char[] { '#' }, new char[] {
				// '#' });
			//	textHighlight(wh.wbtext, new char[] { '@' }, new char[] {
				// ':',' ' });
				//textHighlight2(wh.wbtext, "http://", " ");

			}

			return convertView;
		}

	}

}

