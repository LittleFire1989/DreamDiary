package org.mengker.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.mengker.share.Share;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonUtil {
	
	
	public List<Share> StringFromJson (String jsondata)
	{     
		Type listType = new TypeToken<List<Share>>(){}.getType();
		Gson gson=new Gson();
		ArrayList<Share> list=gson.fromJson(jsondata, listType);
		return list;

	}
}
