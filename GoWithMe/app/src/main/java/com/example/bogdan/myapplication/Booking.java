package com.example.bogdan.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(indices = {@Index("id_user"),@Index("id_ride")},tableName = "bookings",foreignKeys ={@ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "id_user",
        onDelete = CASCADE),
        @ForeignKey(entity = Ride.class,
                parentColumns = "id",
                childColumns = "id_ride",
                onDelete = CASCADE)
})
public class Booking {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private  int id_user;
    private  int id_ride;
    private int seatNumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_ride() {
        return id_ride;
    }

    public void setId_ride(int id_ride) {
        this.id_ride = id_ride;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
