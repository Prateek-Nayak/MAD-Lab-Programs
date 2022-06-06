package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    EditText username,password;
    int attempts;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
        signin=findViewById(R.id.signin);

    }
    public void signin(View v)
    {
        Bundle B=getIntent().getExtras();
        String uname=B.getString("uid");
        String passwd=B.getString("password");
        if(username.getText().toString().equals(uname) && password.getText().toString().equals(passwd))
        {
            Toast.makeText(this, "SIGN IN SUCCESSFUL", Toast.LENGTH_LONG).show();
            attempts=0;
            Intent i = new Intent(this, Success.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this, "SIGN IN UNSUCCESSFUL , No of attempts= " +attempts, Toast.LENGTH_LONG).show();
            attempts++;
            if(attempts==3){
                signin.setEnabled(false);

            }
        }
    }
}

