package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Button btn = (Button)findViewById(R.id.button);
        EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.password);
        Intent i = new Intent(MainActivity.this, Hazi.class);
        startActivity(i);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().equals("") && !password.getText().toString().equals("")){
                    String email_address = email.getText().toString();
                    String psw = password.getText().toString();
                    if(psw.equals("12345") && email_address.equals("admin@sapi.ro")){
                        Toast.makeText(MainActivity.this,"Sikeres belépés!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Home.class);
                        i.putExtra("email", email_address);
                        i.putExtra("password", psw);
                        i.putExtra("is_loggedin", true);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Hibás email vagy jelszó", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this,"Üres mező!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}