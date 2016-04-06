package com.fiona.uidemo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.fiona.uidemo.R;

import butterknife.ButterKnife;

public class CustomProgressDialog extends Dialog {
	TextView mMsgTextView;
	private Context mContext;
	private String mMsg;
	 

	public CustomProgressDialog(Context context, String msg) {
		super(context, R.style.CustomDialog);
		mContext = context;
		mMsg = msg;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		View view = getLayoutInflater().inflate(
				R.layout.general_progress_dialog, null);
		setContentView(view);
		mMsgTextView = ButterKnife.findById(view, R.id.msgTextView);
		if(!TextUtils.isEmpty(mMsg))
			mMsgTextView.setText(mMsg);

	}
	
	public void setMessage(CharSequence message) {
		mMsgTextView.setText(message);
	}
}
