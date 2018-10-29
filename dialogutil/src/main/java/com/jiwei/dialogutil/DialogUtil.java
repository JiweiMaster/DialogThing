package com.jiwei.dialogutil;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by 18099 on 2018/10/29.
 */

public class DialogUtil {
    private Context context;
    public DialogUtil(Context context){
        this.context = context;
    }

    /**
     *
     * @param loadText    the text dialog loading
     * @param cancelable  can be cancled by click blank area
     * @return
     */

    public Dialog getLoadingDialog(String loadText,Boolean cancelable){
        AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.LoadingDialog);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_dialog_layout,null);
        ImageView loadingImageView = view.findViewById(R.id.loadingImageView);
        TextView loadingTextView = view.findViewById(R.id.loadingTextView);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context).load(R.drawable.loading).apply(options).into(loadingImageView);

        if(loadText != null){
            loadingTextView.setText(loadText);
        }
        builder.setCancelable(cancelable);
        builder.setView(view);
        Dialog dialog = builder.create();
        return dialog;
    }
}
