package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public void onCreate(){
        super.onCreate();
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Thread.sleep(5000);
                    Intent intent = new Intent(MyService.this, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        stopSelf();
    }
    @Override
    public int onStartCommand (Intent intent, int flags, int startId){
        stopSelf();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){super.onDestroy();}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}