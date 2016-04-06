package com.fiona.uidemo.ui;

import android.os.Bundle;

import com.fiona.uidemo.R;
import com.fiona.uidemo.ui.base.ExitActivity;

/**
 * Created by chenfiona on 16/4/6.
 */
public class MainActivity extends ExitActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        super.initView();
    }
}
