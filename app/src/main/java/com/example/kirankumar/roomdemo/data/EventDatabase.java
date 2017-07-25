package com.example.kirankumar.roomdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.kirankumar.roomdemo.data.helper.DateTypeConverter;

/**
 * Created by kiran.kumar on 7/18/17.
 */
@Database(entities = {Event.class}, version = 1)
@TypeConverters(DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase{

    public abstract EventDao eventDao();
}
