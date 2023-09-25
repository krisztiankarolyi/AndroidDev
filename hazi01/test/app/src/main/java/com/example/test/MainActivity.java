package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.min);
        Button mult = (Button) findViewById(R.id.mult);
        Button div = (Button) findViewById(R.id.div);
        TextView out = (TextView)  findViewById(R.id.textView3);
        EditText n1EditText = findViewById(R.id.n1);
        String n1String = n1EditText.getText().toString();
        EditText n2EditText = findViewById(R.id.n2);
        String n2String = n2EditText.getText().toString();

        View.OnClickListener commonClickListener = view -> {
            try {
                float n1 = Float.parseFloat(n1EditText.getText().toString());
                float n2 = Float.parseFloat(n2EditText.getText().toString());

                String res = "";
                // A gomb azonosítása a view ID alapján
                if (view.getId() == R.id.plus) {
                    res = n1 + n2+"";
                } else if (view.getId() == R.id.min) {
                    res = n1 - n2+"";
                } else if (view.getId() == R.id.mult) {
                    res = n1 * n2+"";
                } else if (view.getId() == R.id.div) {
                    if (n2 != 0) {
                        res = n1 / n2+"";
                    } else {
                        res = "0-val nem lehet osztani!";
                    }
                }
                out.setText("Eredmény: " + res);
                out.setVisibility(View.VISIBLE);
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(getApplicationContext(), "Hiba történt: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        plus.setOnClickListener(commonClickListener);
        minus.setOnClickListener(commonClickListener);
        div.setOnClickListener(commonClickListener);
        mult.setOnClickListener(commonClickListener);


}
}
