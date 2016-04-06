package com.fiona.uidemo.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.fiona.uidemo.R;
import com.fiona.uidemo.ui.MainActivity;
import com.fiona.uidemo.ui.base.AnimationActivity;
import com.fiona.uidemo.ui.base.ExitActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chenfiona on 16/4/6.
 */
public class LoginActivity extends ExitActivity{

    private int PASSWORD_MIN_LENGTH;
    private int PASSWORD_MAX_LENGTH;
    private int PHONE_NUMBER_LENGTH;

    @Bind(R.id.registerButton)
    TextView mRegisterButton;
    @Bind(R.id.loginButton)
    TextView mLoginButton;
    @Bind(R.id.forgetTextView)
    TextView mForgetTextView;
    @Bind(R.id.mcodeTextView)
    TextView mMcodeTextView;
    @Bind(R.id.phonenumberEditText)
    EditText mPhonenumberEditText;
    @Bind(R.id.passwordEditText)
    EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        loginClick();
    }

    private void initData() {
        PASSWORD_MIN_LENGTH = getResources().getInteger(
                R.integer.password_min_length);
        PASSWORD_MAX_LENGTH = getResources().getInteger(
                R.integer.password_max_length);
        PHONE_NUMBER_LENGTH = getResources().getInteger(
                R.integer.phone_number_length);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginButton.setEnabled(false);
        mPhonenumberEditText.addTextChangedListener(mTextWatcher);
        mPasswordEditText.addTextChangedListener(mTextWatcher);
        super.initView();
    }

    @OnClick(R.id.forgetTextView)
    public void forgetPasswordClick() {}

    @OnClick(R.id.mcodeTextView)
    public void loginByMcodeClick() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, LoginByMCodeActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        if (AnimationActivity.OpenAnimation)
            overridePendingTransition(AnimationActivity.OpenEnter, AnimationActivity.OpenExit);
    }

    @OnClick(R.id.loginButton)
    public void loginClick() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        if(AnimationActivity.OpenAnimation)
            overridePendingTransition(AnimationActivity.OpenEnter, AnimationActivity.OpenExit);
        finish();
    }

    @OnClick(R.id.registerButton)
    public void registerClick() {

    }


    private TextWatcher mTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            refreshLoginButton();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        private void refreshLoginButton() {
            String phoneNumber = mPhonenumberEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();
            if (phoneNumber.length() == PHONE_NUMBER_LENGTH
                    && (password.length() >= PASSWORD_MIN_LENGTH && password.length() <= PASSWORD_MAX_LENGTH)) {
                mLoginButton.setEnabled(true);
            } else {
                mLoginButton.setEnabled(false);
            }
        }
    };
}
