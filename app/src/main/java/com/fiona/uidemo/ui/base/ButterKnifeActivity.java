package com.fiona.uidemo.ui.base;

import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by chenfiona on 16/4/6.
 */
public class ButterKnifeActivity extends SubscribeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView(){
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
