package com.example.bogdan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * In this activity we try to dispaly all user
 * In best case we disllay the data in recycler view
 */
public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    TextView name_user;
    Button make_a_ride;
    Button find_a_ride;
    String nume;
    int id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();


        Toast.makeText(this, "Login process ended with success", Toast.LENGTH_SHORT).show();

        name_user = findViewById(R.id.username_text);
        make_a_ride = findViewById(R.id.make_ride);
        find_a_ride = findViewById(R.id.find_ride);


         nume=getIntent().getStringExtra("nume");
         id_user=getIntent().getIntExtra("id_user",1);

          name_user.setText(nume);

        make_a_ride.setOnClickListener(this);
        find_a_ride.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.make_ride:

                Intent intent3 = new Intent(StartActivity.this,
                        MakeRideActivity.class);
                intent3.putExtra("user_id_make",id_user);
                startActivity(intent3);

                break;
            case R.id.find_ride:

                Intent intent4 = new Intent(StartActivity.this,
                        FindRideActivity.class);
                intent4.putExtra("user_id_make",id_user);
                startActivity(intent4);


                break;
        }
    }
}
