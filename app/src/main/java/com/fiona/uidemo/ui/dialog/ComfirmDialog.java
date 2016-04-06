package com.fiona.uidemo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fiona.uidemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chenfiona on 16/4/1.
 */
public class ComfirmDialog extends Dialog {

    public interface CallBack {
        public void ok();
        public void cancel();
    }


    private String mMsg;
    private Object mTag;
    private boolean mCancelable = true;

    private CallBack mCallBack;

    @Bind(R.id.titleTextView)
    TextView mTitleTextView;
    @Bind(R.id.leftTextView)
    TextView mCancelTextView;
    @Bind(R.id.rightTextView)
    TextView mOKTextView;

    public static ComfirmDialog showComfirmDialog(Context context, String msg, Object tag) {
        ComfirmDialog dialog = new ComfirmDialog(context, msg, tag);
        return dialog;
    }

    public ComfirmDialog(Context context, String msg, Object tag) {
        super(context, R.style.ConfirmDialog);
        mMsg = msg;
        mTag = tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView() {
        View rootView = getLayoutInflater().inflate(R.layout.dialog_confirm, null);
        setContentView(rootView);
        ButterKnife.bind(this);
        mTitleTextView.setText(mMsg);
        mCancelTextView.setText(R.string.general_cancel);
        mOKTextView.setText(R.string.general_ok);

    }

    @OnClick(R.id.leftTextView)
    public void cancel(){
        dismiss();
        if(mCallBack != null)
            mCallBack.cancel();

    }

    @OnClick(R.id.rightTextView)
    public void ok(){
        if(mCallBack != null)
            mCallBack.ok();
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
        mCancelable = flag;
    }

    public void setCallBack(CallBack callBack){
        this.mCallBack = callBack;
    }

    @Override
    public void dismiss() {
        ButterKnife.unbind(this);
        super.dismiss();
    }
}
