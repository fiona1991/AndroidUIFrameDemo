package com.fiona.uidemo.ui.account;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import com.fiona.uidemo.ui.base.ButterKnifeFragment;
import com.fiona.uidemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasePasswordFragment extends ButterKnifeFragment {

	public static final String TAG = BasePasswordFragment.class
			.getCanonicalName();

	private int PASSWORD_MIN_LENGTH;
	private int PASSWORD_MAX_LENGTH;
	Bundle mBundle;

	@Bind(R.id.passwordEditText1)
	EditText mPasswordEditText1;

	@Bind(R.id.checkBox1)
	CheckBox mCheckBox1;

	@Bind(R.id.nextButton)
	TextView mNextButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBundle = getArguments();
		PASSWORD_MIN_LENGTH = getResources().getInteger(
				R.integer.password_min_length);
		PASSWORD_MAX_LENGTH = getResources().getInteger(
				R.integer.password_max_length);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.register_password, null);
		ButterKnife.bind(this, view);
		mPasswordEditText1.addTextChangedListener(mPasswordWatcher);
		mPasswordEditText1.setText("");
		mCheckBox1.setOnCheckedChangeListener(mCheckBoxListener1);
		return view;
	}

	private TextWatcher mPasswordWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			refreshSubmitButton();
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
		}
	};

	OnCheckedChangeListener mCheckBoxListener1 = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				mPasswordEditText1
						.setTransformationMethod(HideReturnsTransformationMethod
								.getInstance());
			} else {
				mPasswordEditText1
						.setTransformationMethod(PasswordTransformationMethod
								.getInstance());
			}
			mPasswordEditText1.setSelection(mPasswordEditText1.getText()
					.toString().length());
		}
	};

	private void refreshSubmitButton() {
		String password1 = mPasswordEditText1.getText().toString().trim();
		if (password1.length() >= PASSWORD_MIN_LENGTH 
				&& password1.length() <= PASSWORD_MAX_LENGTH) {
			mNextButton.setEnabled(true);
		} else {
			mNextButton.setEnabled(false);
		}
	}

	@OnClick(R.id.nextButton)
	public void nextClick() {}

}
