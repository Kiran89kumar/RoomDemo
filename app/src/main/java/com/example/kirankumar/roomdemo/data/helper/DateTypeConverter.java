package com.example.kirankumar.roomdemo.data.helper;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/**
 * Created by kiran.kumar on 7/18/17.
 */

public class DateTypeConverter {

    @TypeConverter
    public static LocalDateTime toDate(Long timestamp) {
        return timestamp == null ? null : LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0));
    }

    @TypeConverter
    public static Long toTimestamp(LocalDateTime date) {
        return date == null ? null : date.toInstant(ZoneOffset.ofTotalSeconds(0)).getEpochSecond();
    }
}
