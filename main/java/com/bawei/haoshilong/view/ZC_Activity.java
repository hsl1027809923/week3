package com.bawei.haoshilong.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.haoshilong.R;
import com.bawei.haoshilong.base.BaseActivity;
import com.bawei.haoshilong.base.BasePresenter;
import com.bawei.haoshilong.bean.Beana;
import com.bawei.haoshilong.prensenter.MyPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:41
 *@Description:${注册页面}
 **/
public class ZC_Activity extends BaseActivity {


    private MyPresenter myPresenter;
    private EditText zc_edita;
    private EditText zc_editb;
    private Button zc_but_zc;
    private String phone;
    private String pwd;

    //设置数据
    @Override
    protected void initData() {

        zc_but_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = zc_edita.getText().toString().trim();
                pwd = zc_editb.getText().toString().trim();
                Map<String,String> map=new HashMap<>();
                map.put("phone", phone);

                map.put("pwd", pwd);
                myPresenter.toRequest("http://172.17.8.100/small/user/v1/register",map);
            }
        });
    }
    //初始化控件
    @Override
    protected void initView() {
        zc_edita=findViewById(R.id.zc_edita);
        zc_editb=findViewById(R.id.zc_editb);
        zc_but_zc=findViewById(R.id.zc_but_zc);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_zc_;
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
        String pd = beana.getStatus();
        Log.i("pd","pd0000:"+pd);
        if (pd.equals("0000")||pd.equals("1001")){
            Intent intent=new Intent(ZC_Activity.this,MainActivity.class);
//            intent.putExtra("phone",phone);
//            intent.putExtra("pwd",pwd);
            startActivity(intent);
        }
    }


}
