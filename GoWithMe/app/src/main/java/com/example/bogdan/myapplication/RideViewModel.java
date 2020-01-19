package com.example.bogdan.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class RideViewModel extends AndroidViewModel {

    private UserRepository userRepository;


    private LiveData<List<Ride>> allRides;
    private List<Ride> rides;




    public RideViewModel(@NonNull Application application) {
        super(application);
        userRepository= new UserRepository(application);



        allRides = userRepository.getAllRides();
        rides = userRepository.getRides();

    }


    public List<Ride> getRides(){
        return rides;
    }

    public void insertR(Ride ride)
    {
        userRepository.insertR(ride);
    }

    public LiveData<List<Ride>> getAllRides() {
        return allRides;
    }

    public void delete(Ride ride) {
        userRepository.delete(ride);
    }
}
