package com.example.ProbaVizsga1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView counter;
    private Button okBtn;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String clicks = intent.getStringExtra("clicks");

        counter = findViewById(R.id.counter);
        counter.setText(clicks);
        okBtn = findViewById(R.id.okBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        okBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent resultIntent = new Intent();
        int viewId = v.getId();

        if (viewId == R.id.okBtn) {
            setResult(RESULT_OK, resultIntent);
        }
        else if (viewId == R.id.cancelBtn) {
            setResult(RESULT_CANCELED, resultIntent);
        }

        finish();
    }
}