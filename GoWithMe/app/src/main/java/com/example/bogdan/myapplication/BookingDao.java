package com.example.bogdan.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

@Dao
public interface BookingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Booking booking);
}
