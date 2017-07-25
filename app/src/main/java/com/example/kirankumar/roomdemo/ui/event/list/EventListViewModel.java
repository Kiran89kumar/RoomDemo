package com.example.kirankumar.roomdemo.ui.event.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.kirankumar.roomdemo.data.Event;
import com.example.kirankumar.roomdemo.injection.CountdownComponent;
import com.example.kirankumar.roomdemo.repo.EventRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kiran.kumar on 7/18/17.
 */

public class EventListViewModel extends ViewModel implements CountdownComponent.Injectable{

    @Inject
    EventRepository eventRepository;
    private LiveData<List<Event>> events = new MutableLiveData<>();

    @Override
    public void inject(CountdownComponent countdownComponent) {
        countdownComponent.inject(this);
        events = eventRepository.getEvents();
    }

    public LiveData<List<Event>> getEvents() {
        return events;
    }

    public void deleteEvent(Event event) {
        eventRepository.deleteEvent(event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        //Timber.d("onComplete - deleted event");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Timber.e("OnError - deleted event: ", e);
                    }
                });
    }

}
