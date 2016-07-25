package com.feicui.app.news.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences π§æﬂ¿‡
 */
public class SharedUtil {
	private static final String KEY_NAME="config";
    
	public static boolean getBoolean(Context context,String key,boolean defaultValue){
		SharedPreferences sp=context.getSharedPreferences(KEY_NAME, Context.MODE_PRIVATE);
		return sp.getBoolean(key,defaultValue);
	}
	
	public static void setBoolean(Context context,String key,boolean defaultValue){
		SharedPreferences sp=context.getSharedPreferences(KEY_NAME, Context.MODE_PRIVATE);
		sp.edit().putBoolean(key, defaultValue).commit();
	}
}
