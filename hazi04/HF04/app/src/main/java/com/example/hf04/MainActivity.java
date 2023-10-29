package com.example.hf04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
public class MainActivity extends AppCompatActivity {
    ListView myList;
    Integer[] flags = {
        R.drawable.eu, R.drawable.usa, R.drawable.uk, R.drawable.austr, R.drawable.can, R.drawable.swi, R.drawable.den, R.drawable.hu
    };
    String[] iso_codes = {
            "EUR", "USD", "GBP", "AUD",  "CAD", "CHF",  "DFF", "HUF"
    };

    String[] names = {
            "Euro",  "Dollar American",  "Liria sterlina", "Dollar Australian",
            "Dollar canadian",  "Franc Elvetian",  "Corona Daneza",  "Forint Maghiar",
    };

    String[] buyPrices = {
            "4,4100 RON", "3,9750 RON", "6,1250 RON",
            "2,9600 RON", "3,0950 RON", "4,2300 RON",
            "0,5850 RON", "0,0136 RON",
    };

    String[] sellPrices = {
        "4,5500 RON", "4,1450 RON", "6,3550 RON",
        "3,0600 RON", "3,2650 RON",
        "4,3300 RON", "0,6150 RON", "0,0146 RON"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.lista);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, flags, iso_codes, names, buyPrices, sellPrices);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, adapter.getName(position)+": "+adapter.getBuyPArray(position), Toast.LENGTH_LONG).show();
            }
        });

    }



}