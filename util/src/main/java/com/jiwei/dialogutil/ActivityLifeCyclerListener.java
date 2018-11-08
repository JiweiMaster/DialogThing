package com.jiwei.dialogutil;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * 需要在MyApplication中调用
 * registerActivityLifecycleCallbacks(activityLifeCyclerListener);
 * activityLifeCyclerListener.setOnActivity...回调监听的接口函数
 * Created by 18099 on 2018/10/30.
 */

public class ActivityLifeCyclerListener implements Application.ActivityLifecycleCallbacks{
    private static int processCount = 0;
    private ActivityListener activityListener;
    private ArrayList<Activity> activityManager = new ArrayList<>();

    public interface ActivityListener{
        void onBackGround();
    }

    public void setOnActivityListener(ActivityListener activityListener){
        this.activityListener = activityListener;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        processCount++;
        activityManager.add(activity);

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        processCount --;
        if(processCount == 0) {
            activityListener.onBackGround();
        }
        activityManager.remove(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public void deleteAllActivity(){
        if(activityManager != null){
            for(Activity activity : activityManager){
                activity.finish();
            }
        }
    }
}
