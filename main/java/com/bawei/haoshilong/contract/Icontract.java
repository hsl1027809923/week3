package com.bawei.haoshilong.contract;

import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:48
 *@Description:${契约类}
 **/public interface Icontract {
        //v
    public interface IView{
        void success(String json);
    }

    //Ip
    public interface IPresenter{
        void toRequest(String url, Map<String,String> map);
    }

    //callBack
    public interface CallBack{
        void success(String json);
        void error(String er);
    }
}
