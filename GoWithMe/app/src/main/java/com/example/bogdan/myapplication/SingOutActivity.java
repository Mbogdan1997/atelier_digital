package com.example.bogdan.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingOutActivity extends AppCompatActivity {


    public static final String EXTRA_NAME =
            "com.example.simion.myapplication.EXTRA_NAME";
    public static final String EXTRA_USERNAME =
            "com.example.simion.myapplication.EXTRA_USERNAME";
    public static final String EXTRA_PASSWORD =
            "com.example.simion.myapplication.EXTRA_PASSWORD";

    private UserViewModel userViewModel;
    //private UserRepository repository;

    EditText name;
    EditText username;
    EditText password;
    Button reg_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_out);

       // myDatabase = MyDatabase.getInstance(this);
        name = findViewById(R.id.text_name);
        username = findViewById(R.id.nUsername);
        password = findViewById(R.id.nPassword);
        reg_button = findViewById(R.id.nRegister);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * When the button is clicked that we need to extract all fields value and insert them in database
                 */

                //
                User user2 = new User(name.getText().toString(),username.getText().toString(),password.getText().toString(),"12313");
                userViewModel.insert(user2);
                clearFields();
                Toast.makeText(view.getContext(),"User Inregistrat", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void clearFields() {

        name.setText("");
        username.setText("");
        password.setText("");

    }

}
