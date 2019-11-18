package com.bawei.haoshilong.prensenter;

import com.bawei.haoshilong.base.BasePresenter;
import com.bawei.haoshilong.contract.Icontract;
import com.bawei.haoshilong.model.Mymodel;

import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:41
 *@Description:${p层}
 **/public class MyPresenter extends BasePresenter implements Icontract.IPresenter {
    Mymodel mymodel;

    public MyPresenter() {
        mymodel=new Mymodel();
    }

    //方法
    @Override
    public void toRequest(String url, Map<String, String> map) {
            mymodel.DoPost(url, map, new Icontract.CallBack() {
                @Override
                public void success(String json) {
                    //回调json串
                    v.success(json);
                }

                @Override
                public void error(String er) {

                }
            });
    }


}
