package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
        Log.d("status", "Main Activity has been Created");
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityTwo.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status", "Main Activity  Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
        Log.d("status", "Main Activity  Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
      //  Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
        Log.d("status", "Main Activity  Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
        Log.d("status", "Main Activity  DESTROYED");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
      //  Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
        Log.d("status", "Main Activity  RESTARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status", "Main Activity RESUMED");
    }
}
