package com.jiwei.dialogthing;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 18099 on 2018/11/1.
 */

public class PictureDialog {
    Dialog dialog;
    Context context;
    IconItemListener iconItemListener;
    File pictureFile;
    SubsamplingScaleImageView pictureImageView;
    LinearLayout deleteImageViewLayout;
    LinearLayout downLoadImageViewLayout;
    LinearLayout closeImageViewLayout;
    public interface IconItemListener{
        void deleteImageView();
        void onDownloadItemClick();
    }

    public PictureDialog(final Context context){
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_picture_looking,null);
        deleteImageViewLayout = view.findViewById(R.id.pictureDeleteLayout);
        downLoadImageViewLayout = view.findViewById(R.id.pictureDownloadLayout);
        pictureImageView = view.findViewById(R.id.pictureDiv);
        closeImageViewLayout = view.findViewById(R.id.dialgo_closeLayout);

        deleteImageViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconItemListener.deleteImageView();
            }
        });
        downLoadImageViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconItemListener.onDownloadItemClick();
            }
        });
        closeImageViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog = new Dialog(context,R.style.pictureDialog);
        dialog.setContentView(view);
    }

    public void setPictureUrl(final String url){
        Observable.create(new ObservableOnSubscribe<File>() {
            @Override
            public void subscribe(ObservableEmitter<File> emitter) throws Exception {
                RequestOptions options = new RequestOptions();
                pictureFile = Glide.with(context).load(url).apply(options)
                        .downloadOnly(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL).get();
                emitter.onNext(pictureFile);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) throws Exception {
                        pictureImageView.setImage(ImageSource.uri(pictureFile.getAbsolutePath()));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("Exception","error=>"+throwable.getMessage());
                    }
                });
    }

    public void setOnIconItemClick(IconItemListener iconItemListener){
        this.iconItemListener = iconItemListener;
    }

    public File getDownLoadPicture(){
        return pictureFile;
    }

    public void setIconDeleteVisibility(boolean isShow){
        if(isShow == true){
            deleteImageViewLayout.setVisibility(View.VISIBLE);
        }else{
            deleteImageViewLayout.setVisibility(View.GONE);
        }
    }

    public void setIconDownLoadVisibility(boolean isShow){
        if(isShow == true){
            deleteImageViewLayout.setVisibility(View.VISIBLE);
        }else{
            deleteImageViewLayout.setVisibility(View.GONE);
        }
    }
}
