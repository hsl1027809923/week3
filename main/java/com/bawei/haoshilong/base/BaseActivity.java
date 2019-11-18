package com.bawei.haoshilong.base;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.haoshilong.contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:28
 *@Description:${activity基类}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Icontract.IView {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(Layout());
        p= Payout();
        //绑定方法
        if (p!=null){
            p.Attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int Layout();
    protected abstract P Payout();
    //解绑方法

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.UAttach();
            p=null;
        }
    }
}
