package com.example.probavizsga2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static EditText nameBox;
    private static EditText tickerBox;
    private static EditText priceBox;
    private static EditText growBox;

    private Button addStockBtn;
    private static ArrayList<Stock> stocks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("return", Context.MODE_PRIVATE);
        float sum = sp.getFloat("return", 0);
        Toast.makeText(this, "Legutóbbi elmentett hozam: "+sum+"$", Toast.LENGTH_SHORT).show();

        nameBox = findViewById(R.id.nameBox);
        tickerBox = findViewById(R.id.tickerBox);
        priceBox = findViewById(R.id.priceBox);
        growBox = findViewById(R.id.growBox);
        addStockBtn = findViewById(R.id.addStockBtn);

        addStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStock();
            }
        });

        Stock pepsi = new Stock("Pepsico inc", "PEP", (float)10.342, (float)1.134);
        Stock cola = new Stock("CocaCola inc", "COC", (float)12.42, (float)-0.15);
        stocks.add(pepsi); stocks.add(cola);
    }

    public void myStocks(View view){
        Intent intent = new Intent(this, StocksActivity.class);
      //  intent.putExtra("stocks", stocks);

        startActivity(intent);
    }


    public void addStock(){
        if(!nameBox.getText().toString().equals("") && !tickerBox.getText().toString().equals("") && !priceBox.getText().toString().equals("") && !growBox.getText().toString().equals("") ){
            String name = nameBox.getText().toString();
            String ticker = tickerBox.getText().toString();
            Float price = Float.parseFloat(priceBox.getText().toString());
            Float grow = Float.parseFloat(growBox.getText().toString());

            Stock stock = new Stock(name, ticker, price, grow);
            stocks.add(stock);
            Toast.makeText(getApplicationContext(), "Stock sikeresen hozzáadva a listához!",  Toast.LENGTH_SHORT).show();

            nameBox.setText("");
            tickerBox.setText("");
            priceBox.setText("");
            growBox.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(), "Minden  mező kitöltése kötelező!",  Toast.LENGTH_SHORT).show();
        }
    }

    public static ArrayList<Stock> getStocks() {
        return stocks;
    }
}