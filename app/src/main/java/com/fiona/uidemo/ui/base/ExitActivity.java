package com.fiona.uidemo.ui.base;

import android.view.KeyEvent;

import com.fiona.uidemo.R;
import com.fiona.uidemo.utils.ToastUtil;

/**
 * 连按两次返回键退出
 * Created by chenfiona on 16/4/6.
 */
public class ExitActivity extends ButterKnifeActivity{

    private long mExitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtil.showInForeground(getApplicationContext(),
                        String.format(getString(R.string.general_exit_hint),
                                getString(R.string.app_name)));
                mExitTime = System.currentTimeMillis();
            }else{
                // TODO 手动结束一些服务等 以后再加
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
