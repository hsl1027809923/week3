package com.bawei.haoshilong.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.haoshilong.R;
import com.bawei.haoshilong.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:9:28
 *@Description:${展示页面}
 **/
public class ZS_Activity extends AppCompatActivity {

    private ImageView zs_img;
    private TextView zs_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zs_);
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    private void initData() {
        String headPic = getIntent().getStringExtra("headPic");
        Log.i("Aa","aa"+headPic);
        String nickName = getIntent().getStringExtra("nickName");
        zs_name.setText(nickName+"");
        //gride
//        Glidea.Too(headPic,zs_img);

    }

    private void initView() {
        zs_img = findViewById(R.id.zs_img);
        zs_name = findViewById(R.id.zs_name);
    }


}
