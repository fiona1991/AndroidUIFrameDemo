package com.fiona.uidemo.ui.account;

import android.os.Bundle;

import com.fiona.uidemo.R;
import com.fiona.uidemo.ui.base.BaseTopbarActivity;

public class LoginByMCodeActivity extends BaseTopbarActivity {
	public static final String TAG = LoginByMCodeActivity.class.getCanonicalName();
	
	private String mCurrentTag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String title = "";
		Class<?> clazz = null;

		clazz = LoginByMCodeFragment.class;
		title = getString(R.string.account_login_by_mcode_title);

		setTitle(title);
		updateContent(LoginByMCodeFragment.TAG, clazz, null);
	}
	
}
