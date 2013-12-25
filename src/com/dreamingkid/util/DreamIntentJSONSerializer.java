package com.dreamingkid.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;

import com.dreamingkid.dream.Dream;

public class DreamIntentJSONSerializer {
	private Context mContext;
	private String mFilename;
	
	public DreamIntentJSONSerializer(Context c, String f){
		mContext = c;
		mFilename = f;
	}
	
	public void saveCrimes(ArrayList<Dream> dreams)
			throws JSONException, IOException{
		// Build an array in JSON
		JSONArray array = new JSONArray();
		for(Dream d: dreams){
			array.put(d.toJSON());
		}
		
		//Write the file to disk
		Writer writer = null;
		try{
			OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
			writer = new OutputStreamWriter(out);
			writer.write(array.toString());
		}
		finally{
			if(writer != null)
				writer.close();
		}
		
	}
}
