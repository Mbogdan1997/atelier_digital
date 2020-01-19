package com.example.bogdan.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

public class FindRideActivity extends AppCompatActivity {

    private RideViewModel rideViewModel;
    private BookingViewModel bookingViewModel;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ride);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        final RecyclerView recyclerView2 = findViewById(R.id.recycler_view_rides);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setHasFixedSize(true);
        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel.class);

        userId=getIntent().getIntExtra("user_id_make",1);

        final RideAdapter riderAdapter2 = new RideAdapter(bookingViewModel,userId);
        recyclerView2.setAdapter(riderAdapter2);

        rideViewModel = ViewModelProviders.of(this).get(RideViewModel.class);

        rideViewModel.getAllRides().observe(this, new Observer<List<Ride>>() {


            @Override
            public void onChanged(@Nullable List<Ride> rides) {
                riderAdapter2.rides.clear();
               riderAdapter2.setRides(rides);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                Intent intent = new Intent(FindRideActivity.this,RequestRideActivity.class);
                //rideViewModel.delete(riderAdapter2.getTideAt(viewHolder.getAdapterPosition()));
                Toast.makeText(FindRideActivity.this,"Ride Selected",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        }).attachToRecyclerView(recyclerView2);
    }
}
