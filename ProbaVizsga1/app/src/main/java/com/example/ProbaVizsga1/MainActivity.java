package com.example.ProbaVizsga1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private static Button increaseLeftButton;
    private static Button increaseRightButton;
    private static Button SecondActivityBtn;
    private static Button thirdActivityBtn;
    private static EditText nr1;
    private static EditText nr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ezt hozzá kell adni

        increaseLeftButton = findViewById(R.id.num1incbtn);
        increaseRightButton = findViewById(R.id.num2incbtn);
        SecondActivityBtn = findViewById(R.id.secondActivityBtn);
        thirdActivityBtn = findViewById(R.id.ThirdActivityBtn);

        nr1 = findViewById(R.id.num1);
        nr2 = findViewById(R.id.num2);

        increaseLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentVal = Integer.parseInt(String.valueOf(nr1.getText()));
                nr1.setText(String.valueOf(currentVal + 1));
            }
        });

        SecondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });

        thirdActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThirdActivity();
            }
        });

        Reset();
    }

    private void startThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 1);
    }

    private void startSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        int clicks = Integer.parseInt(String.valueOf(nr1.getText())) +  Integer.parseInt(String.valueOf(nr2.getText()));
        intent.putExtra("clicks", clicks+"");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int clicks = Integer.parseInt(String.valueOf(nr1.getText())) +  Integer.parseInt(String.valueOf(nr2.getText()));
                Toast.makeText(this, "Kattintások: "+clicks, Toast.LENGTH_SHORT).show();
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "A cancel gombra nyomtál", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public  static void increaseNum2(View v){
        int currentVal = Integer.parseInt(String.valueOf(nr2.getText()));
        nr2.setText((currentVal+1+""));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.saveItem) {
            Save();
            return true;
        }
        else if (item.getItemId() == R.id.resetItem) {
            Reset();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void Save(){
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("numbers", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("num1", nr1.getText().toString());
            editor.putString("num2", nr2.getText().toString());
            editor.apply();
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

        }
        catch (Exception ex){
            Log.d("ERROR->", "Save: "+ex.getMessage());
            Toast.makeText(this, "Could not save data, see the log", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        Save();
        super.onPause();
    }

    public  void Reset(){
        SharedPreferences sharedPreferences = getSharedPreferences("numbers", Context.MODE_PRIVATE);
        try {
            nr1.setText(sharedPreferences.getString("num1", "0"));
            nr2.setText(sharedPreferences.getString("num2", "0"));
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception ex){
            Log.d("ERROR->", "Reset: "+ex.getMessage());
            Toast.makeText(this, "Could not load data, see the log", Toast.LENGTH_SHORT).show();
        }

    }

}