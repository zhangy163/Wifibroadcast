package com.zhangy.wifitest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/10/14 0014.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF); //关闭屏幕
        filter.addAction(Intent.ACTION_SCREEN_ON); //开启屏幕
        filter.addAction(Intent.ACTION_USER_PRESENT); //解锁
        filter.addAction(Intent.ACTION_BOOT_COMPLETED);
        registerReceiver(testReceiver, filter);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(testReceiver);
    }

    public BroadcastReceiver testReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("ss", "拦截到一个广播：" + intent.getAction());
        }
    };
}
