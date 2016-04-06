package com.fiona.uidemo.ui.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Otto为了性能，代码意图清晰，@Subscribe，@Produce方法必须定义在直接的作用类上，而不能定义在基类而被继承。
 * Created by chenfiona on 16/4/6.
 */
public class SubscribeActivity extends AnimationActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 注册订阅
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //TODO 解绑订阅
    }
}
