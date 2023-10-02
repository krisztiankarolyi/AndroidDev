package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("status", "Activtiy2 Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Button btn2 = (Button) findViewById(R.id.button);
        Button btn3 = (Button) findViewById(R.id.startAct3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityThree.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status", "Activtiy2 Started");
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activtiy2 Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activtiy2 Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activtiy2 DESTROYED");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //  Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activtiy2 RESTARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status", "Activtiy2 RESUMED");
    }
}