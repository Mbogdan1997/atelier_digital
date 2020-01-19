package com.example.bogdan.myapplication;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface RideDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Ride ride);


    @Delete
    void delete(Ride ride);


    @Query("SELECT * FROM rides")
    List<Ride> getRides();

    @Query("SELECT * FROM rides")
    LiveData<List<Ride>> getAllRides();

    @Query("Select * from rides where rides.id=:id")
    Ride findById(int id);

    @Update
    void updateRide(Ride ride);
}
