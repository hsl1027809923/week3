package com.bawei.haoshilong.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.haoshilong.R;
import com.bawei.haoshilong.base.BaseActivity;
import com.bawei.haoshilong.base.BasePresenter;
import com.bawei.haoshilong.bean.BeanB;
import com.bawei.haoshilong.bean.Beana;
import com.bawei.haoshilong.prensenter.MyPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:28
 *@Description:${主页面登陆注册}
 **/
public class MainActivity extends BaseActivity {


    private MyPresenter myPresenter;
    private EditText android_edita;
    private EditText android_editb;
    private Button android_but_zc;
    private Button android_but_dl;
    private String tr1;
    private String tr2;

    @Override
    protected void initData() {

        //登陆点击
        android_but_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr1 = android_edita.getText().toString();
                tr2 = android_editb.getText().toString();
                Log.i("pwd","pwd:"+tr2);
                Map<String,String> map=new HashMap<>();
                map.put("phone", tr1);
                map.put("pwd", tr2);
                myPresenter.toRequest("http://172.17.8.100/small/user/v1/login",map);
            }
        });
        //设置数据
        //注册点击跳转
        android_but_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ZC_Activity.class);
                startActivity(intent);
            }
        });
    }
    //初始化控件
    @Override
    protected void initView() {
        android_edita=findViewById(R.id.android_edita);
        android_editb=findViewById(R.id.android_editb);
        android_but_zc=findViewById(R.id.android_but_zc);
        android_but_dl=findViewById(R.id.android_but_dl);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Payout() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }


    @Override
    public void success(String json) {
        Gson gson=new Gson();
        Beana beana = gson.fromJson(json, Beana.class);
        String status = beana.getStatus();
        Log.i("beana","beana"+status);
        //解析3
        Gson gson1=new Gson();
        BeanB beanB = gson1.fromJson(json, BeanB.class);
        String headPic = beanB.getResult().getHeadPic();
        String nickName = beanB.getResult().getNickName();
        if (status.equals("0000")){
            Intent intent=new Intent(MainActivity.this,ZS_Activity.class);
            //④　登录成功后跳转到图2，把头像和用户昵称传递到图2。
            intent.putExtra("headPic",headPic+"");

            intent.putExtra("nickName",nickName);
            startActivity(intent);
        }
    }
}
