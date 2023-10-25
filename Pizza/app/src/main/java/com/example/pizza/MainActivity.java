package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pizza> pizzaList = new ArrayList<>();
    Pizza selectedPizza;
    Topping tomatoTopping = new Topping("tomato", 3);
    Topping cheeseTopping = new Topping("cheese", 3.5);
    double totalPrice = 0;
    Spinner pizzaSpinner;
    CheckBox cheese; CheckBox tomato;
    TextView price;
    Button sendBtn;
    double cheesePrice = 3;
    double tomatoPrice = 2.5;

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

        Pizza margareta = new Pizza("Margareta", 20, true);
        Pizza capricoasa = new Pizza("Capricoasa", 21, false);
        pizzaList.add(margareta); pizzaList.add(capricoasa);
        pizzaAdapter.notifyDataSetChanged();

       sendBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               totalPrice = 0; // Nullázza ki a totalPrice változót
               selectedPizza = (Pizza) pizzaSpinner.getSelectedItem();
               totalPrice += selectedPizza.getBasePrice();
               selectedPizza.setToppings(new ArrayList<>());
               if(cheese.isChecked()) selectedPizza.addTopping(cheeseTopping);
               if(tomato.isChecked()) selectedPizza.addTopping(tomatoTopping);
               totalPrice = selectedPizza.getFullPrice();
               price.setText("Total Price: "+totalPrice);
               Toast.makeText(getApplicationContext(), selectedPizza.orderSummary(), Toast.LENGTH_LONG).show();
           }
       });
    }
}