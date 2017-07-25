package com.example.kirankumar.roomdemo.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.kirankumar.roomdemo.CountdownApplication;

/**
 * Created by kiran.kumar on 7/18/17.
 */

public class CountdownFactory extends ViewModelProvider.NewInstanceFactory {

    private CountdownApplication application;

    public CountdownFactory(CountdownApplication application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        T t = super.create(modelClass);
        if (t instanceof CountdownComponent.Injectable) {
            ((CountdownComponent.Injectable) t).inject(application.getCountDownComponent());
        }
        return t;
    }
}
