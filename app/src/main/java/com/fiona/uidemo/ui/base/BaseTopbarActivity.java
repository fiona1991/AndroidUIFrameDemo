package com.fiona.uidemo.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fiona.uidemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseTopbarActivity extends ButterKnifeActivity {
	public static final String TAG = BaseTopbarActivity.class.getCanonicalName();
	
	@Bind(R.id.topbarView)
	View mTopbarView;
	@Bind(R.id.titleTextView)
	TextView mTitleTextView;
	@Bind(R.id.subtitleTextView)
	TextView mSubtitleTextView;
	@Bind(R.id.backImageView)
	ImageView mBackImageView;
	@Bind(R.id.operationContainer)
	LinearLayout mOperationContainer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	@Override
	public void initView(){
		setContentView(getLayoutResID());
		initOtherView();
		super.initView();
	}

	public void initOtherView(){}

	public int getLayoutResID() {
		return R.layout.base_topbar_activity;
	}
	
	@Override
	@OnClick(R.id.backImageView)
	public void onBackPressed() {
		super.onBackPressed();
	}
	
	public void setTitle(CharSequence text){
		mTitleTextView.setText(text);
	}
	
	public void setTitle(int resid){
		mTitleTextView.setText(resid);
	}
	
	public void setSubTitle(CharSequence text){
		mSubtitleTextView.setText(text);
	}
	
	public void setSubTitle(int resid){
		mSubtitleTextView.setText(resid);
	}

	public void updateContent(String tag, Class<?> clazz, Bundle bundle){
		FragmentTransaction ft = this.getSupportFragmentManager()
				.beginTransaction();
		Fragment fragment = Fragment.instantiate(this, clazz.getName(), bundle);
		ft.replace(R.id.emptyContainer, fragment, tag);
		ft.commit();
	}

	public void addContent(View view){
		FrameLayout container = (FrameLayout) findViewById(R.id.emptyContainer);
		container.addView(view);
	}

	protected void addBaseView(View v, LinearLayout.LayoutParams param) {
		LinearLayout rootView = (LinearLayout) findViewById(R.id.operationContainer);
		rootView.addView(v, param);
	}
	
}
