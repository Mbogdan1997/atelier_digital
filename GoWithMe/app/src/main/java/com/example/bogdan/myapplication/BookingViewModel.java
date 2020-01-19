package com.example.bogdan.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class BookingViewModel extends AndroidViewModel {

    private UserRepository userRepository;


    public BookingViewModel(@NonNull Application application) {
        super(application);
        userRepository= new UserRepository(application);

    }

    public void makeBooking(Booking booking){
        Ride ride=userRepository.findRideById(booking.getId_ride());
        if(Integer.valueOf(booking.getSeatNumber())<=Integer.valueOf(ride.getSeatsNumber())) {
            ride.setSeatsNumber(String.valueOf(Integer.valueOf(ride.getSeatsNumber()) -
                    Integer.valueOf(booking.getSeatNumber())
                    ));
            userRepository.update(ride);
            userRepository.makeBooking(booking);
        }
    }

}
