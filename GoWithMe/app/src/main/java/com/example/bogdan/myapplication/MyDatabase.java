package com.example.bogdan.myapplication;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {User.class, Ride.class,Booking.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {


    private static MyDatabase instance;

    public abstract UserDAO userDAO();

    public abstract RideDAO rideDAO();
    public abstract BookingDao bookingDAO();




    /**
     *
     * I madde a change at the database
     * I put a method that allow to inset data in main thrad
     * It is not recomadate
     *
     */
    public static synchronized MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class, "gowithme").allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO userDAO;
        private RideDAO rideDAO;
        private BookingDao bookingDao;

        private PopulateDbAsyncTask(MyDatabase db) {
            userDAO = db.userDAO();
            rideDAO = db.rideDAO();
            bookingDao=db.bookingDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            userDAO.insert(new User("Vasile", "aaa2", "parola2","00342"));
            userDAO.insert(new User("Simion", "aaa1", "parola1","2342"));
            rideDAO.insert(new Ride(1,"Cluj","Brasov","4 martie","21:00","15","5"));

            //userDAO.insert(new User("Vasile", "aaa2", "parola2","00342"));
            //userDAO.insert(new User("Darius", "aaa3", "parola3","0043"));
            return null;
        }
    }


}
