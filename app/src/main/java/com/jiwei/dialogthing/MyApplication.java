package com.jiwei.dialogthing;

import android.app.Application;
import android.util.Log;

import com.jiwei.actiivtylifecyclerlife.ActivityLifeCyclerListener;

/**
 * Created by 18099 on 2018/10/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActivityLifeCyclerListener activityLifeCyclerListener
                = new ActivityLifeCyclerListener();
        registerActivityLifecycleCallbacks(activityLifeCyclerListener);
        activityLifeCyclerListener.setOnActivityListener(new ActivityLifeCyclerListener.ActivityListener() {
            @Override
            public void onBackGround() {
                Log.d("MyApplication","当前应用已被切入后台了");
            }
        });
    }
}
