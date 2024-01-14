package com.example.probavizsga2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StocksActivity extends AppCompatActivity {

    private TextView nameLabel;
    private TextView tickerLabel;
    private TextView priceLabel;
    private TextView growLabel;
    private Button saveBtn;
    public StockListAdapter adapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        // Kezeld le a kiválasztott menüelem eseményét
        if(item.getItemId() == R.id.Delete) {
            AdapterView.AdapterContextMenuInfo selectedListElement = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int index = selectedListElement.position;

            adapter.removeStock(index);
            adapter.notifyDataSetChanged();
            tickerLabel.setText("");
            nameLabel.setText("");
            priceLabel.setText("");
            growLabel.setText("");
        }
        return true;
    }



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks);
        saveBtn = findViewById(R.id.saveReturnBtn);
        growLabel = findViewById(R.id.infoGrowLabel);
        nameLabel = findViewById(R.id.infoNameLabel);
        priceLabel = findViewById(R.id.infoPriceLabel);
        tickerLabel = findViewById(R.id.infoTickerLabel);


        ArrayList<Stock> stocks = MainActivity.getStocks();


        ListView listView = findViewById(R.id.listView);
        adapter = new StockListAdapter(this.getApplicationContext(), R.id.listElement, stocks);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stock stock = adapter.getStocks().get(position);
                growLabel.setText("Grow:  "+stock.getGrow()+"%");
                nameLabel.setText("Name:  "+stock.getName());
                tickerLabel.setText("Ticker:  "+stock.getTicker());
                priceLabel.setText("Price:  "+stock.getPrice()+"$");
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePortFolioReturn();
            }
        });

    }

    public void savePortFolioReturn(){
        float sum = 0;
        for (Stock stock: adapter.getStocks())
        {
            sum+=(stock.getPrice() + (stock.getGrow() * stock.getPrice()));
        }
        SharedPreferences sp = getSharedPreferences("return", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putFloat("return", sum);
        spEditor.apply();
        
        Toast.makeText(this, "A következő összeg elmentve: "+sum, Toast.LENGTH_SHORT).show();
    }
}