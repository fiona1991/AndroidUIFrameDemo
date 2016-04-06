package com.fiona.uidemo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fiona.uidemo.R;

import butterknife.ButterKnife;

public class ToastUtil {
	
	public static void showToast(Context context, int resID){
		showCustomToast(context, resID);
	}
	
	public static void showToast(Context context, String msg){
		showCustomToast(context, msg);
	}
	
	public static void showInForeground(Context context, int resID){
		if(!DeviceUtil.isApplicationBroughtToBackground(context))
			showCustomToast(context, resID);
	}
	
	public static void showInForeground(Context context, String msg){
		if(!DeviceUtil.isApplicationBroughtToBackground(context))
			showCustomToast(context, msg);
	}
	
	private static void showCustomToast(Context context, Object message)
	{
		View toastRootView = LayoutInflater.from(context).inflate(R.layout.toast_custom, null);
		if (toastRootView == null)
			return;

		TextView messageTextView = ButterKnife.findById(toastRootView, R.id.messageTextView);
		if(message instanceof String)
			messageTextView.setText((String)message);
		else if(message instanceof Integer)
			messageTextView.setText((Integer)message);
		else 
			return;
		
		Toast toast = new Toast(context);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastRootView);
		toast.show();
	}

}
