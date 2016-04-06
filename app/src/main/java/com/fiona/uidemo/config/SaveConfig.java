package com.fiona.uidemo.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SaveConfig {
	
	public static void saveSettings(Context context, String name, String key, int value){
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt(key, (Integer)value);
		editor.commit();
	}
	
	public static void saveSettings(Context context, String name, String key, long value){
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putLong(key, (Long)value);
		editor.commit();
	}
	
	public static void saveSettings(Context context, String name, String key, boolean value){
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean(key, (Boolean)value);
		editor.commit();
	}
	
	public static void saveSettings(Context context, String name, String key, float value){
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putFloat(key, (Float)value);
		editor.commit();
	}
	
	public static void saveSettings(Context context, String name, String key, String value){
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString(key, (String)value);
		editor.commit();
	}
	
	public static int getSettingsInt(Context context, String name, String key, int defaultValue){
		if (context == null) {
			return defaultValue;
		}
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		return sp.getInt(key, defaultValue);
	}
	
	public static long getSettingsLong(Context context, String name, String key, Long defaultValue){
		if (context == null) {
			return defaultValue;
		}
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		return sp.getLong(key, defaultValue);
	}
	
	public static boolean getSettingsBoolean(Context context, String name, String key, boolean defaultValue){
		if (context == null) {
			return defaultValue;
		}
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		return sp.getBoolean(key, defaultValue);
	}
	
	public static float getSettingsFloat(Context context, String name, String key, float defaultValue){
		if (context == null) {
			return defaultValue;
		}
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		return sp.getFloat(key, defaultValue);
	}
	
	public static String getSettingsString(Context context, String name, String key, String defaultValue){
		if (context == null) {
			return defaultValue;
		}
		SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
		return sp.getString(key, defaultValue);
	}
	
	
	

}
