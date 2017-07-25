package com.example.kirankumar.roomdemo.injection;

import com.example.kirankumar.roomdemo.ui.event.add.AddEventViewModel;
import com.example.kirankumar.roomdemo.ui.event.list.EventListViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kiran.kumar on 7/18/17.
 */

@Singleton
@Component(modules = {CountdownModule.class})
public interface CountdownComponent {

    void inject(EventListViewModel eventListViewModel);

    void inject(AddEventViewModel addEventViewModel);

    interface Injectable {
        void inject(CountdownComponent countdownComponent);
    }

}
