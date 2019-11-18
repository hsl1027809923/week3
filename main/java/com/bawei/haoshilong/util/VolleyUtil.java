package com.bawei.haoshilong.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.haoshilong.app.MyApp;
import com.bawei.haoshilong.contract.Icontract;

import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:44
 *@Description:${工具类}
 **/public class VolleyUtil {
    //创建队列
    RequestQueue queue= Volley.newRequestQueue(MyApp.context);
    //单例模式
    public static VolleyUtil util=new VolleyUtil();
    private VolleyUtil() {
    }
    public static VolleyUtil getInstance(){
        return util;
    }


    //网络
    public boolean getNet(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }


    //post请求
    public void toPost(String url, final Map<String,String>map, final Icontract.CallBack callBack){
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("aa","response"+response);
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                if (map!=null){
                    Log.i("map","map"+map);
                    return map;

                }
                return super.getParams();
            }
        };
        queue.add(request);
    }
}
