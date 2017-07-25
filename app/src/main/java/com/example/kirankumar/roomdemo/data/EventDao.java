package com.example.kirankumar.roomdemo.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import static java.nio.charset.CodingErrorAction.REPLACE;

/**
 * Created by kiran.kumar on 7/18/17.
 */

@Dao
public interface EventDao {

    @Query("SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.DATE_FIELD + " > :minDate")
    LiveData<List<Event>> getEvents(LocalDateTime minDate);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addEvent(Event event);

    @Delete
    void deleteEvent(Event event);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEvent(Event event);
}
