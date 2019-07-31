package org.ytl.common;

import okhttp3.OkHttpClient;

public class MyHttpClient {
	static MyHttpClient mMyHttpClient;
	private OkHttpClient mOkHttpClient = null;

	public static MyHttpClient getInstance() {
		if (mMyHttpClient == null) {
			mMyHttpClient = new MyHttpClient();
		}
		return mMyHttpClient;
	}

	private MyHttpClient() {
		
	}
	
	public OkHttpClient getOkHttpClient() {
		if (mOkHttpClient == null) {
			mOkHttpClient = new OkHttpClient();
		}
		return mOkHttpClient;
	}
}
