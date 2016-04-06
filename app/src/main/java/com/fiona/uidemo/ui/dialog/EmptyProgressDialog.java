package com.fiona.uidemo.ui.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.fiona.uidemo.R;

public class EmptyProgressDialog extends Dialog {
	private Context mContext;

	public EmptyProgressDialog(Context context) {
		super(context, R.style.CustomDialog);
		// TODO Auto-generated constructor stub
		mContext = context;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    View view = getLayoutInflater()
	    		.inflate(R.layout.general_empty_progressbar, null);
		setContentView(view);
	}
}
