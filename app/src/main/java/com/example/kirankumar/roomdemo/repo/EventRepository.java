package com.example.kirankumar.roomdemo.repo;

import android.arch.lifecycle.LiveData;

import com.example.kirankumar.roomdemo.data.Event;

import java.util.List;
import io.reactivex.Completable;

/**
 * Created by kiran.kumar on 7/18/17.
 */

public interface EventRepository {
    Completable addEvent(Event event);

    LiveData<List<Event>> getEvents();

    Completable deleteEvent(Event event);
}
