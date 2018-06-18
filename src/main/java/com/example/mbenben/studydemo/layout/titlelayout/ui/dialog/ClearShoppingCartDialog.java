package com.example.mbenben.studydemo.layout.titlelayout.ui.dialog;

import android.view.View;
import android.view.WindowManager;

import com.example.mbenben.studydemo.R;

import butterknife.OnClick;

/**
 * Created by ${GongWenbo} on 2018/5/22 0022.
 *
 * 原项目GItHub:https://github.com/GongWnbo/SuperRecycleView
 */
public class ClearShoppingCartDialog extends BaseDialog {

    private ShoppingCartDialogListener mShoppingCartDialogListener;

    @Override
    protected void init() {

    }

    @Override
    public float setAlpha() {
        return 0.4f;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_clear_shopping_cart;
    }

    @OnClick({R.id.tv_shopping_cart_clear, R.id.tv_shopping_cart_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_shopping_cart_clear:
                if (mShoppingCartDialogListener != null) {
                    mShoppingCartDialogListener.clear();
                }
                dismiss();
                break;
            case R.id.tv_shopping_cart_cancel:
                dismiss();
                break;
        }
    }

    public void setShoppingCartDialogListener(ShoppingCartDialogListener shoppingCartDialogListener) {
        mShoppingCartDialogListener = shoppingCartDialogListener;
    }

    public interface ShoppingCartDialogListener {

        void clear();

    }
}
