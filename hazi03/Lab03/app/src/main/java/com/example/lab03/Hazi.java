package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hazi extends AppCompatActivity {
    static ArrayList<Product> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_product_form);

        Button addProdBtn = (Button) findViewById(R.id.addProductButton);
        Button showProdBtn = (Button) findViewById(R.id.showProductsBtn);


        addProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameT = (EditText)findViewById(R.id.name);
                EditText priceT = (EditText)findViewById(R.id.price);
                EditText codeT = (EditText)findViewById(R.id.code);
                Product product = new Product(priceT.getText().toString(), nameT.getText().toString(), codeT.getText().toString());
                products.add(product);
                nameT.setText("");
                priceT.setText("");
                codeT.setText("");
            }
        });

        showProdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView) findViewById(R.id.listProducts);
                t.setText("");
                for(Product p : products)
                {
                    t.append(p + "\n------------------------\n");
                }
            }
        });
    }
}