package com.example.bogdan.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MakeRideActivity extends AppCompatActivity{


    private RideViewModel rideViewModel;

    EditText From;
    EditText To;
    EditText Date;
    EditText Hour;
    EditText Price;
    EditText seatsNumber;
    int id_user;

    Button reg_ride_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_ride);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        From=findViewById(R.id.make_form);
        To=findViewById(R.id.make_to);
        Date=findViewById(R.id.make_date);
        Hour=findViewById(R.id.make_hour);
        Price=findViewById(R.id.make_price);
        reg_ride_button=findViewById(R.id.make_reg_ride);
        seatsNumber=findViewById(R.id.seats_number);

        id_user=getIntent().getIntExtra("user_id_make",1);

        rideViewModel = ViewModelProviders.of(this).get(RideViewModel.class);

        reg_ride_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * When the button is clicked that we need to extract all fields value and insert them in database
                 */

                //
                Ride ride = new Ride(id_user,From.getText().toString(),To.getText().toString(),Date.getText().toString(),Hour.getText().toString(),Price.getText().toString(),seatsNumber.getText().toString());
                rideViewModel.insertR(ride);
                clearFields();
                Toast.makeText(view.getContext(),"User Inregistrat", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void clearFields() {

        From.setText("");
        To.setText("");
        Date.setText("");
        Hour.setText("");
        Price.setText("");
        seatsNumber.setText("");

    }


}
