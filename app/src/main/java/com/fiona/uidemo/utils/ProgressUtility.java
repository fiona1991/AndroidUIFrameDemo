package com.fiona.uidemo.utils;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;

import com.fiona.uidemo.R;
import com.fiona.uidemo.ui.dialog.CustomProgressDialog;
import com.fiona.uidemo.ui.dialog.EmptyProgressDialog;

public class ProgressUtility {

	private static Dialog mProgress = null;
	public static int mCurrentKey = 0;

	/**
	 * 
	 * @param context
	 * @param msg
	 * @param key
	 * @param back
	 *            按返回键的时候是否消失
	 */
	public static void showProgress(Context context, int key, String msg,
			boolean back) {
		if (context == null) {
			return;
		}
		dismissProgress();
		mCurrentKey = key;
		try {
			if(TextUtils.isEmpty(msg)){
				mProgress = new EmptyProgressDialog(context);
			} else {
				mProgress = new CustomProgressDialog(context, msg);
			}
			mProgress.setCancelable(false);
			if (!back) {
				mProgress.setOnKeyListener(new DialogInterface.OnKeyListener() {

					@Override
					public boolean onKey(DialogInterface dialog, int keyCode,
							KeyEvent event) {
						if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
							return true;
						} else {
							return false;
						}
					}
					
				});
			}
			mProgress.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showProgress(Context context, int key, String msg) {
		showProgress(context, key, msg, true);
	}

	public static void showProgress(Context context, int key) {
		showProgress(context, key, context.getString(R.string.general_wait), true);
	}

	public static void dismissProgress(int key) {
		if (mCurrentKey == key && mProgress != null && mProgress.isShowing()) {
			try {
				mProgress.dismiss();
			} catch (Exception e) {
			}
		}
	}

	public static void dismissProgress() {
		if (mProgress != null && mProgress.isShowing()) {
			try {
				mProgress.dismiss();
			} catch (Exception e) {
			}
		}
	}
}
