package com.example.activitystatesave2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public CheckBox cb;
    public EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            Log.d("Indítás: ", "onCreate: előző állapot visszaállÍtása nélkül)");
        else
            Log.d("Indítás: ", "onCreate: előző állapot visszaállÍtásával)");
        setContentView(R.layout.activity_main);

        // Elemek inicializálása a setContentView után
        cb = findViewById(R.id.checkBox);
        text = findViewById(R.id.editText);

        cb.setSaveEnabled(false);
        text.setSaveEnabled(false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("checkBox", cb.isChecked());
        outState.putString("text", text.getText().toString());
        Log.d("allapot", "onSaveInstanceState() meghívva");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getString("text") != null)
            text.setText(savedInstanceState.getString("text"));
        cb.setChecked(savedInstanceState.getBoolean("checkBox"));
        Log.d("allapot", "onRestoreInstanceState() meghivva ");
    }
}
