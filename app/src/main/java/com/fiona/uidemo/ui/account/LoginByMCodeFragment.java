package com.fiona.uidemo.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fiona.uidemo.R;


public class LoginByMCodeFragment extends BasePhonenumberFragment {
	
	public static final String TAG = LoginByMCodeFragment.class.getCanonicalName();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = super.onCreateView(inflater, container, savedInstanceState);
		mNextButton.setText(R.string.account_login);
		return view;
	}
	
	@Override
	public void mcodeClick(){
		String phoneNumber = mPhonenumberEditText.getText().toString();
	}

	public void mcodeEvent(){
		//TODO
	}
	
	@Override
	public void nextClick() {
		String phoneNumber = mPhonenumberEditText.getText().toString();
		String mcode = mMcodeEditText.getText().toString();

		//TODO

		Intent intent = new Intent(getActivity(), LoginActivity.class);
		getActivity().startActivity(intent);
		getActivity().finish();

	}


	public void loginEvent(){
		//TODO
	}
	
}
