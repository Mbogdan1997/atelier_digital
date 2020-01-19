package com.example.bogdan.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(indices = {@Index("id_user")},tableName = "rides",foreignKeys =@ForeignKey(entity = User.class,
                                parentColumns = "id",
                                childColumns = "id_user",
                                onDelete = CASCADE))
public class Ride {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private  int id_user;

    private String from;
    private String to;
    private String date;
    private String hour;
    private String price;
    private String seatsNumber;

    public String getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(String seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Ride(int id_user, String from, String to, String date, String hour, String price,String seatsNumber) {
        this.id_user=id_user;
        this.from = from;
        this.to = to;
        this.date = date;
        this.hour = hour;
        this.price= price;
        this.seatsNumber=seatsNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {

        return id_user;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




}
