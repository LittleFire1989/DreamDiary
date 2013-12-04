package org.mengker.net;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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



import android.util.Log;



public class Operation {
	
	public static void main (String args) {
		Operation o = new Operation();
		
	}
	
	public String login(String url,String username,String password) 
	{    
		String result = null;
		ConnNet connNet=new ConnNet();
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		try {
			HttpEntity entity=new UrlEncodedFormEntity(params, HTTP.UTF_8);
			HttpPost httpPost=connNet.gethttPost(url);
			System.out.println(httpPost.toString());
			httpPost.setEntity(entity);
			HttpClient client=new DefaultHttpClient();
			HttpResponse httpResponse=client.execute(httpPost);
			System.out.println(httpResponse.getStatusLine().getStatusCode());
			if (httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK) 
			{
				result=EntityUtils.toString(httpResponse.getEntity(), "utf-8");			
			}
			else
			{
				result="未能获得结果";
			}
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (ClientProtocolException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}
}
