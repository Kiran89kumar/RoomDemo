package com.example.kirankumar.roomdemo.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.kirankumar.roomdemo.CountdownApplication;
import com.example.kirankumar.roomdemo.data.EventDatabase;
import com.example.kirankumar.roomdemo.repo.EventRepository;
import com.example.kirankumar.roomdemo.repo.EventRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kiran.kumar on 7/18/17.
 */

@Module
public class CountdownModule {
    private CountdownApplication countdownApplication;

    public CountdownModule(CountdownApplication countdownApplication) {
        this.countdownApplication = countdownApplication;
    }

    @Provides
    Context applicationContext() {
        return countdownApplication;
    }

    @Provides
    @Singleton
    EventRepository providesEventRepository(EventDatabase eventDatabase) {
        return new EventRepositoryImpl(eventDatabase);
    }

    @Provides
    @Singleton
    EventDatabase providesEventDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class, "event_db").build();
    }
}
