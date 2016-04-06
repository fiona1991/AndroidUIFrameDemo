package com.fiona.uidemo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Otto为了性能，代码意图清晰，@Subscribe，@Produce方法必须定义在直接的作用类上，而不能定义在基类而被继承。
 * Created by chenfiona on 16/4/6.
 */
public class SubscribeFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 注册订阅
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO 解绑订阅
    }
}
