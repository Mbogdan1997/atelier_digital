package com.example.bogdan.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;
    private List<User> users;
    private String nameUser;

    private LiveData<List<Ride>> allRides;
    private List<Ride> rides;




    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository= new UserRepository(application);

        allUsers =userRepository.getAllUsers();
        users = userRepository.getUsers();

        allRides = userRepository.getAllRides();
        rides = userRepository.getRides();


    }

    public String getNameUser(int id){return nameUser;}

    public List<User> getUsers(){
        return users;
    }

    public void insert(User user)
    {
        userRepository.insert(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
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

    public User login(String username,String password){
        return userRepository.login(username,password);
    }


}
