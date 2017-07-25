package com.example.kirankumar.roomdemo;

import android.app.Application;

import com.example.kirankumar.roomdemo.injection.CountdownComponent;
import com.example.kirankumar.roomdemo.injection.CountdownModule;
import com.example.kirankumar.roomdemo.injection.DaggerCountdownComponent;
import com.jakewharton.threetenabp.AndroidThreeTen;

/**
 * Created by kiran.kumar on 7/18/17.
 */

public class CountdownApplication extends Application {

    private final CountdownComponent countDownComponent = createCountdownComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }

    protected CountdownComponent createCountdownComponent() {
        return DaggerCountdownComponent.builder()
                .countdownModule(new CountdownModule(this))
                .build();
    }

    public CountdownComponent getCountDownComponent() {
        return countDownComponent;
    }

}
