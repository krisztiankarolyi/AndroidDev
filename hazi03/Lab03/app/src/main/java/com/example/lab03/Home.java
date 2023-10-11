package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Home extends AppCompatActivity {
    public static boolean is_loggedin = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle extras = getIntent().getExtras();
        is_loggedin = extras.getBoolean("is_loggedin");
        Button logout = (Button) findViewById(R.id.logoutbtn);
        String email = extras.getString("email");
        TextView t = (TextView)findViewById(R.id.textView2);
        t.setText(t.getText()+"\n"+email);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_loggedin = false;
                finish();
            }
        });


    }

}