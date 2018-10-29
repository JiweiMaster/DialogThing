package com.jiwei.dialogthing;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiwei.dialogutil.DialogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogUtil dialogUtil = new DialogUtil(this);
        Dialog dialog = dialogUtil.getLoadingDialog("加载中",true);
        dialog.show();

    }
}
