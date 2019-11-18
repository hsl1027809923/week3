package com.bawei.haoshilong.base;

import com.bawei.haoshilong.contract.Icontract;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:31
 *@Description:${presenter基类}
 **/public class BasePresenter<V extends BaseActivity> {
    public V v;
    //绑定方法
    public void Attach(V v){
        this.v=v;
    }
    //解绑方法
    public void UAttach(){
        if (v!=null){
            v=null;
        }
    }
}
