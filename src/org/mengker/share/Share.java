package org.mengker.share;

public class Share {
	private String shareID;
	private String userID;
	private String message;
	private String userName;
	private String posttime;
	
	public Share(String shareID, String userID, String message, String userName,String posttime ) {
		super();
		this.shareID = shareID;
		this.userID = userID;
		this.message = message;
		this.userName = userName;
		this.posttime = posttime;
	}
	
	
	public String getPosttime() {
		return posttime;
	}


	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}


	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getShareID() {
		return shareID;
	}
	public void setShareID(String shareID) {
		this.shareID = shareID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
