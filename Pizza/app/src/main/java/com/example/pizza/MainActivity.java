package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pizza> pizzaList = new ArrayList<>();
    Pizza selectedPizza;
    Topping tomatoTopping = new Topping("tomato", 2.5);
    Topping cheeseTopping = new Topping("cheese", 3.5);
    double totalPrice = 0;
    Spinner pizzaSpinner;
    CheckBox cheese; CheckBox tomato;
    TextView price;
    Button sendBtn;
    double currentPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        pizzaSpinner = (Spinner) findViewById(R.id.spinner);
        cheese = (CheckBox) findViewById(R.id.cheese);
        tomato = (CheckBox) findViewById(R.id.tomato);
        price = (TextView) findViewById(R.id.price);

        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<Pizza>(this, android.R.layout.simple_spinner_item, pizzaList);
        pizzaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        pizzaSpinner.setAdapter(pizzaAdapter);

        Pizza margareta = new Pizza("Margarita", 22, true);
        Pizza capricoasa = new Pizza("Capricoasa", 23, false);
        Pizza vegegarian = new Pizza("Vegetarian", 24, false);
        pizzaList.add(margareta); pizzaList.add(capricoasa); pizzaList.add(vegegarian);
        pizzaAdapter.notifyDataSetChanged();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalPrice = selectedPizza.getFullPrice();
                price.setText(totalPrice+" RON");
                Toast.makeText(getApplicationContext(), selectedPizza.orderSummary(), Toast.LENGTH_LONG).show();
            }
        });

        pizzaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPizza = (Pizza) adapterView.getSelectedItem();

                if (cheese.isChecked()) {
                    selectedPizza.addTopping(cheeseTopping);
                } else {
                    selectedPizza.removeTopping(cheeseTopping);
                }

                if (tomato.isChecked()) {
                    selectedPizza.addTopping(tomatoTopping);
                } else {
                    selectedPizza.removeTopping(tomatoTopping);
                }

                currentPrice = selectedPizza.getFullPrice();
                price.setText(currentPrice + " RON");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void onClick(View v) {
        if (selectedPizza != null && v instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) v;

            if (checkBox.isChecked()) {
                selectedPizza.addTopping(cheeseTopping);
            }
            else {
                selectedPizza.removeTopping(cheeseTopping);
            }
            if (checkBox.isChecked()) {
                selectedPizza.addTopping(tomatoTopping);
            }
            else {
                selectedPizza.removeTopping(tomatoTopping);
            }
            currentPrice = selectedPizza.getFullPrice();
            price.setText(currentPrice + " RON");
        }
    }


}