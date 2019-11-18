package com.bawei.haoshilong.view;

import android.content.Intent;
import android.widget.ImageView;

import com.bawei.haoshilong.R;
import com.bawei.haoshilong.app.MyApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:11:51
 *@Description:${DESCRIPTION}
 **/public class Glidea {
    public static void Too(String url, ImageView zs_img){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)//错误图
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))//圆形
                .placeholder(R.drawable.ic_launcher_foreground)//占位图
                .into(zs_img);
    }
}
