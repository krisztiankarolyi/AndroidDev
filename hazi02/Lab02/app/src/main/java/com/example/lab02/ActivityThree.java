package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lab02.R;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("status", "Activity 3 has been Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status", "Activity 3  Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activity 3  Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activity 3  Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activity 3  DESTROYED");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //  Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
        Log.d("status", "Activity 3  RESTARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status", " Activity 3 RESUMED");
    }
}