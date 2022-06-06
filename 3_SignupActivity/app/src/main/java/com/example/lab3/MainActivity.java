package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.uid);
        password = findViewById(R.id.pwd);

    }
    public void signup(View v){
        if(password.getText().toString().length() >= 8 && validatepassword(password.getText().toString())){
            Toast.makeText(this, "SIGN UP SUCCESSFUL", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, signin.class);
            Bundle B = new Bundle();
            B.putString("uid",username.getText().toString());
            B.putString("password",password.getText().toString());
            i.putExtras(B);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "PASSWORD IS NOT MEETING THE REQUIREMENTS", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validatepassword(String password)
    {
        Pattern ptrn;
        Matcher mat;
        String passwordptrn = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[<>/@%$#+=])(?=\\S+$).{8,}$";
        ptrn = Pattern.compile(passwordptrn);
        mat = ptrn.matcher(password);
        return mat.matches();
    }
}