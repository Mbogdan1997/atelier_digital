package com.example.bogdan.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {

    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;
    private List<User> users;
    private String nameUser;

    private RideDAO rideDAO;
    private BookingDao bookingDao;
    private LiveData<List<Ride>> allRides;
    private List<Ride> rides;


    public UserRepository(Application application) {
        MyDatabase database = MyDatabase.getInstance(application);
        userDAO = database.userDAO();
        allUsers = userDAO.getAllUsers();
        users = userDAO.getUsers();

        rideDAO = database.rideDAO();
        allRides = rideDAO.getAllRides();
        rides = rideDAO.getRides();

        bookingDao=database.bookingDAO();


    }

    public User login(String username, String password){
        return userDAO.login(username,password);
    }


    public String getNameUser(int id){return nameUser;}

    public List<User> getUsers(){return users; }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void makeBooking(Booking booking){new InsertBookingAsyncTask(bookingDao).execute(booking);}

    public void insert(User user) {
        new InsertNoteAsyncTask(userDAO).execute(user);
    }

    public List<Ride> getRides(){return rides; }

    public LiveData<List<Ride>> getAllRides() {
        return allRides;
    }

    public void insertR(Ride ride) {
        new InsertRideAsyncTask(rideDAO).execute(ride);
    }

    public void delete(Ride ride) {
        new DeleteRideAsyncTask(rideDAO).execute(ride);
    }

    public void update(Ride ride){new UpdateRideAsyncTask(rideDAO).execute(ride);}

    private static class InsertBookingAsyncTask extends AsyncTask<Booking, Void, Void> {
        private BookingDao bookingDao;

        private InsertBookingAsyncTask(BookingDao bookingDAO) {
            this.bookingDao = bookingDAO;
        }

        @Override
        protected Void doInBackground(Booking... notes) {
            bookingDao.insert(notes[0]);
            return null;
        }
    }


    private static class InsertNoteAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private InsertNoteAsyncTask(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... notes) {
            userDAO.insert(notes[0]);
            return null;
        }
    }

    private static class InsertRideAsyncTask extends AsyncTask<Ride, Void, Void> {
        private RideDAO rideDAO;

        private InsertRideAsyncTask(RideDAO rideDAO) {
            this.rideDAO = rideDAO;
        }

        @Override
        protected Void doInBackground(Ride... notes) {
            rideDAO.insert(notes[0]);
            return null;
        }
    }

    private static class DeleteRideAsyncTask extends AsyncTask<Ride, Void, Void> {
        private RideDAO rideDAO;

        private DeleteRideAsyncTask(RideDAO rideDAO) {
            this.rideDAO = rideDAO;
        }

        @Override
        protected Void doInBackground(Ride... notes) {
            rideDAO.delete(notes[0]);
            return null;
        }
    }

    private static class UpdateRideAsyncTask extends AsyncTask<Ride, Void, Void> {
        private RideDAO rideDAO;

        private UpdateRideAsyncTask(RideDAO rideDAO) {
            this.rideDAO = rideDAO;
        }

        @Override
        protected Void doInBackground(Ride... notes) {
            rideDAO.updateRide(notes[0]);
            return null;
        }
    }


    public Ride findRideById(int id){
        return rideDAO.findById(id);
    }

}
