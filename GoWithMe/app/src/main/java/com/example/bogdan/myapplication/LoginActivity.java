package com.example.bogdan.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int ADD_USER_REQUEST = 1;
    /**
     * In this class we need to read username and passward from database
     * and if there are correct we launch another activity where we have many options
     */

    UserViewModel userViewModel;

    EditText username;
    EditText passward;
    Button loginButton;
    Button regButton;
    String numeUser;
    int id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Toast.makeText(this,"Suntem in Login Activity",Toast.LENGTH_SHORT).show();
        username = findViewById(R.id.username_text);
        passward = findViewById(R.id.password_text);
        loginButton = findViewById(R.id.login_button);
        regButton = findViewById(R.id.button_reg);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        loginButton.setOnClickListener(this);
        regButton.setOnClickListener(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_reg:

                    Intent intent = new Intent(LoginActivity.this,
                            SingOutActivity.class);
                    startActivity(intent);

                break;
            case R.id.login_button:
                /**
                 * Here we must to request the list of User
                 * And if the tex from textField match with an entry in our database
                 * means that exist this user and we can launch the StartActivity
                 */


                if (checkIfExistUser()==true) {
                    Intent intent2 = new Intent(LoginActivity.this,
                            StartActivity.class);

                    /*Bundle extras = new Bundle();
                    extras.putString("nume",numeUser);
                    extras.putInt("id_user", id_user);
                    intent.putExtras(extras);*/
                    intent2.putExtra("nume",numeUser);
                    intent2.putExtra("id_user",id_user);
                    //must to launch
                    startActivity(intent2);
                }else
                    Toast.makeText(view.getContext(), "Username or password are incorrect", Toast.LENGTH_SHORT).show();


               break;
        }
    }

    public boolean checkIfExistUser() {

        /**
         * Change getUsers() in getAllUsers()
         * Second method return a LiveData<List<Ride>>
         */
        /*List<User> list = userViewModel.getAllUsers().getValue();

        for (User user : list) {
            if (username.getText().toString().equals(user.getUsername()) && passward.getText().toString().equals(user.getPassword())) {
                numeUser=user.getName();
                id_user=user.getId();
                //Toast.makeText(getApplicationContext(), numeUser+ id_user, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
         */
        User user=userViewModel.login(username.getText().toString(),passward.getText().toString());
        if(user!=null){
            numeUser=user.getName();
            id_user=user.getId();
            return true;
        }

        return false;

    }
}