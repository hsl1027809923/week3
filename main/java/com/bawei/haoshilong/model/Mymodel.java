package com.bawei.haoshilong.model;

import com.bawei.haoshilong.contract.Icontract;
import com.bawei.haoshilong.util.VolleyUtil;

import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:44
 *@Description:${m层}
 **/public class Mymodel {
    public void DoPost(String url, Map<String,String> map, Icontract.CallBack callBack){
        VolleyUtil.getInstance().toPost(url,map,callBack);
    }
}
