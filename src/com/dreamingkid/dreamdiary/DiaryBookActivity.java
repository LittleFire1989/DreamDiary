package com.dreamingkid.dreamdiary;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/*
 * Programming plan:
 * Step 0: display with fancy list;
 *       click the items will navigate to the view dream
 * Step 1: create a simple dream with AddDreamActivity, the data then are stored in the phone
 * Step 2: new dreams and old dreams can be displayed in the diary book
 * Step 3: every item in the list can be edit or delete, edit dream is another activity
 */

public class DiaryBookActivity extends ListActivity {
	Button addDream;
	ArrayList<String> items = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diary_book);

		// implement the add dream button's function
		addDream = (Button) this.findViewById(R.id.addDream);
		addDream.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(DiaryBookActivity.this,
						AddDreamActivity.class);
				startActivity(intent);
			}
		});
		
		//initialize the test data of items
		items.add("2013-12-23 Dream 1");
		items.add("2013-12-24 Dream 2");
		items.add("2013-12-25 Dream 3");
		items.add("2013-12-23 Dream 4");
		items.add("2013-12-24 Dream 5");
		items.add("2013-12-25 Dream 6");
		items.add("2013-12-23 Dream 7");
		items.add("2013-12-24 Dream 8");
		items.add("2013-12-25 Dream 9");
		items.add("2013-12-23 Dream 10");
		items.add("2013-12-24 Dream 11");
		items.add("2013-12-25 Dream 12");
		items.add("2013-12-23 Dream 1");
		items.add("2013-12-24 Dream 2");
		items.add("2013-12-25 Dream 3");
		items.add("2013-12-23 Dream 4");
		items.add("2013-12-24 Dream 5");
		items.add("2013-12-25 Dream 6");
		items.add("2013-12-23 Dream 7");
		items.add("2013-12-24 Dream 8");
		items.add("2013-12-25 Dream 9");
		items.add("2013-12-23 Dream 10");
		items.add("2013-12-24 Dream 11");
		items.add("2013-12-25 Dream 12");
		items.add("2013-12-23 Dream 1");
		items.add("2013-12-24 Dream 2");
		items.add("2013-12-25 Dream 3");
		items.add("2013-12-23 Dream 4");
		items.add("2013-12-24 Dream 5");
		items.add("2013-12-25 Dream 6");
		items.add("2013-12-23 Dream 7");
		items.add("2013-12-24 Dream 8");
		items.add("2013-12-25 Dream 9");
		items.add("2013-12-23 Dream 10");
		items.add("2013-12-24 Dream 11");
		items.add("2013-12-25 Dream 12");

		// The test version temporally doesn't retrieve data from
		// AddDreamActivity

		// get information from new dream
		// Intent intent = getIntent();
		//
		// String dreamTime = intent.getStringExtra("dream_time");
		// String dreamTitle = intent.getStringExtra("dream_title");
		//
		// if(dreamTime!=null && dreamTitle != null){
		// items.add(dreamTime + " " + dreamTitle);
		//
		// }
		//
		// String itemArray[] = new String[items.size()];
		// for(int i = 0; i < itemArray.length; i++){
		// itemArray[i] = (String)items.get(i);
		// }

		setListAdapter(new LabeledAdapter(this));
	}
	
	private String getModel(int position){
		return ((LabeledAdapter)getListAdapter()).getItem(position);
	}
	
	@Override
	public void onListItemClick(ListView parent, View v, int position, long id){
		// The method is to be modified
		// Some tag of item should be attached to specify which dream it is, so that in the ViewDreamActivity,
		// the app can retrieve data of the specific dream from the local database according to the tag
		Intent intent = new Intent(DiaryBookActivity.this,
				ViewDreamActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diary_book, menu);
		return true;
	}
	/*
	 * The first version only has the dream record function
	 * 
	 * // navigate public void startDiaryBookActivity(View view) { Intent intent
	 * = new Intent(this, DiaryBookActivity.class); startActivity(intent); }
	 * 
	 * public void startExploreActivity(View view) { Intent intent = new
	 * Intent(this, ExploreActivity.class); startActivity(intent); }
	 * 
	 * public void startMeActivity(View view) { Intent intent = new Intent(this,
	 * MeActivity.class); startActivity(intent); }
	 */
	
	class LabeledAdapter extends ArrayAdapter<String>{
		Activity context;
		
		LabeledAdapter(Activity context){
			super(context, R.layout.activity_diary_book_row, items);
			
			this.context = context;
		}
		
		public View getView (int position, View convertView, ViewGroup parent){
			View row = convertView;
			ViewWrapper wrapper = null;
			
			if(row == null){
				LayoutInflater inflater = context.getLayoutInflater();
				row = inflater.inflate(R.layout.activity_diary_book_row, null);
				wrapper = new ViewWrapper(row);
				row.setTag(wrapper);
			}
			else{
				wrapper = (ViewWrapper)row.getTag();
			}
			
			wrapper.getDreamAbsTextView().setText(items.get(position));
			
			//the if condition is for test purpose
			//the implementation should be modified in the future
			if(items.get(position).contains("7")){
				wrapper.getDreamTypeTextView().setText("Lucid");
			}
			
			return (row);
		}
	}
	
	class ViewWrapper{
		View base;
		TextView dreamAbsTextView = null;
		TextView dreamTypeTextView = null;
		
		ViewWrapper(View base){
			this.base = base;
		}
		
		TextView getDreamAbsTextView(){
			if(dreamAbsTextView == null){
				dreamAbsTextView = (TextView)base.findViewById(R.id.dreamAbsTextView);
			}
			return (dreamAbsTextView);
		}
		
		TextView getDreamTypeTextView(){
			if(dreamTypeTextView == null){
				dreamTypeTextView = (TextView)base.findViewById(R.id.dreamTypeTextView);
			}
			return (dreamTypeTextView);
		}
		
	}

}
