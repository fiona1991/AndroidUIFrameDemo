package com.fiona.uidemo.ui.account;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.fiona.uidemo.R;
import com.fiona.uidemo.ui.base.ButterKnifeFragment;
import com.fiona.uidemo.utils.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasePhonenumberFragment extends ButterKnifeFragment {
	
	public static final String TAG = BasePhonenumberFragment.class.getCanonicalName();
	
	private int PHONE_NUMBER_LENGTH;
	private int MCODE_LENGTH;
	Bundle mBundle;
	
	@Bind(R.id.phonenumberEditText)
	EditText mPhonenumberEditText;
	
	@Bind(R.id.mcodeEditText)
	EditText mMcodeEditText;
	
	@Bind(R.id.mcodeButton)
	TextView mMCodeButton;
	
	@Bind(R.id.nextButton)
	TextView mNextButton;
	
	protected boolean mCountDownFinished = true;
	
	
	protected CountDownTimer mMcodeCountDownTimer = new CountDownTimer(Constant.McodeCountDown*1000, 1000) {
		
		@Override
		public void onTick(long millisUntilFinished) {
			String msg = String.format(getResources().getString(R.string.general_mcode_countdown)
					, (millisUntilFinished / 1000));
			mMCodeButton.setText(msg);
			mCountDownFinished = false;
			refreshMcodeButton();
		}
		
		@Override
		public void onFinish() {
			mMCodeButton.setText(R.string.account_get_mcode);
			mCountDownFinished = true;
			refreshMcodeButton();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBundle = getArguments();
		PHONE_NUMBER_LENGTH = getResources().getInteger(
				R.integer.phone_number_length);
		MCODE_LENGTH = getResources().getInteger(
				R.integer.mcode_length);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.register_phonenumber, null);
		ButterKnife.bind(this, view);
		mPhonenumberEditText.addTextChangedListener(mTextWatcher);
		mMcodeEditText.addTextChangedListener(mTextWatcher);
		refreshNextButton();
		refreshMcodeButton();
		return view;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mMcodeCountDownTimer.cancel();
	}
	
	private TextWatcher mTextWatcher = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			refreshNextButton();
			refreshMcodeButton();
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {}
		
		@Override
		public void afterTextChanged(Editable s) {}
	};
	
	private void refreshNextButton() {
		String phoneNumber = mPhonenumberEditText.getText().toString();
		String mcode = mMcodeEditText.getText().toString();
		if(phoneNumber.length() == PHONE_NUMBER_LENGTH
				&& mcode.length() == MCODE_LENGTH){
			mNextButton.setEnabled(true);
		}else{
			mNextButton.setEnabled(false);
		}
	}
	
	private void refreshMcodeButton(){
		String phoneNumber = mPhonenumberEditText.getText().toString();
		
		if(phoneNumber.length() == PHONE_NUMBER_LENGTH){
			mMCodeButton.setEnabled((true && mCountDownFinished));
		}else{
			mMCodeButton.setEnabled(false);
		}
	}
	
	@OnClick(R.id.mcodeButton)
	public void mcodeClick(){}
	
	@OnClick(R.id.nextButton)
	public void nextClick() {}
	
}
