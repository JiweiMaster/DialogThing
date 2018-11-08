package com.jiwei.dialogthing;

import android.app.Dialog;
import android.os.Build;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiwei.dialogutil.DialogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DialogUtil dialogUtil = new DialogUtil(this);
//        Dialog dialog = dialogUtil.getLoadingDialog("加载中",true);
//        dialog.show();

//        final PictureDialog pictureDialog = new PictureDialog(this);
//        pictureDialog.setPictureUrl("http://192.168.30.116:8000/Media/StationImg/187/1e9e5caa41e2785ed4535d50d864a1b1.png");
//        pictureDialog.setOnIconItemClick(new PictureDialog.IconItemListener() {
//
//            @Override
//            public void deleteImageView() {
//                Toast.makeText(MainActivity.this,"删除对话",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onDownloadItemClick() {
//                Toast.makeText(MainActivity.this,"下载图片",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        pictureDialog.dialog.show();



    }
}
