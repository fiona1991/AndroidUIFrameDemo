package com.fiona.uidemo.ui.base;


import android.support.v4.app.FragmentActivity;

import com.fiona.uidemo.R;

public class AnimationActivity extends FragmentActivity {
	public static final String TAG = AnimationActivity.class.getCanonicalName();
	
	public static final boolean OpenAnimation = true;
	public static final int OpenEnter = R.anim.a1;
	public static final int OpenExit = R.anim.a2;
	public static final int CloseEnter = R.anim.a3;
	public static final int CloseExit = R.anim.a4;
	
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if(AnimationActivity.OpenAnimation)
			overridePendingTransition(AnimationActivity.CloseEnter, AnimationActivity.CloseExit);
	}

}
