package com.demo.chenke.basiclib.mvpbase.baseImpl;

import android.content.DialogInterface;
import android.os.Bundle;

import com.demo.chenke.basiclib.mvpbase.BasePresenter;
import com.demo.chenke.basiclib.mvpbase.BaseView;
import com.demo.chenke.basiclib.utils.ActivityManager;
import com.demo.chenke.otherlib.customview.LoadingDialog;

/**
 * Created by chenke on 2018/4/26.
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity implements DialogInterface.OnDismissListener, BaseView {
    public LoadingDialog dialog;
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().removeActivity(this);//将当前activity移除管理栈
        if (presenter != null) {
            presenter.detach();//在presenter中解绑释放view
            presenter = null;
        }
        super.onDestroy();
    }

    /**
     * 在子类中初始化对应的presenter
     *
     * @return 相应的presenter
     */
    public abstract P initPresenter();

    @Override
    public void showLoadingDialog(String msg) {
        if (dialog == null) {
            dialog = new LoadingDialog(this);
            dialog.setOnDismissListener(this);
        }
        dialog.setMessage(msg);
        dialog.show();
    }

    /**
     * 按钮操作
     */
    @Override
    public void dismissLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /**
     * 如果是网络加载，则展示过度视图
     *
     * @param msg
     */
    @Override
    public void showLoading(String msg) {

    }

    /**
     * 展示网络加成成功后的content
     */
    @Override
    public void showContent() {

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (presenter != null) {
            presenter.unDisposable();//在presenter中解绑释放view
        }
    }
}
