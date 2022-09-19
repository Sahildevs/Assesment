package com.example.assesment.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assesment.R;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String u_email = email.getText().toString();
                String u_pass = password.getText().toString();

                loginUser(u_email, u_pass);


            }
        });
    }

    private void loginUser(String u_email, String u_pass) {

        String loginEmain = "test@gmail.com";
        String loginPassword = "123";

        //to check if user has entered his email in the emali field
        if (TextUtils.isEmpty(u_email)) {
            Toast.makeText(MainActivity.this, "Please enter an email", Toast.LENGTH_SHORT).show();
        }

        //to check if user has entered his password in the password field
        if (TextUtils.isEmpty(u_pass)) {
            Toast.makeText(MainActivity.this, "Please enter a password", Toast.LENGTH_SHORT).show();
        }

        else if(u_email.equals(loginEmain) && u_pass.equals(loginPassword)){

            //Toast.makeText(MainActivity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        else {
            Toast.makeText(MainActivity.this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
        }


    }


}