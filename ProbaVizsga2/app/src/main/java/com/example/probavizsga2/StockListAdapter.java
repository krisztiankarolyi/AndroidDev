package com.example.probavizsga2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StockListAdapter extends ArrayAdapter {
    private Context context;
    private  ArrayList<Stock> stocks;
    private int listElementResource;



    public StockListAdapter(@NonNull Context context, int listElementResource, ArrayList<Stock> stocks) {
        super(context, listElementResource, stocks);
        this.context = context;
        this.listElementResource = listElementResource;
        this.stocks = stocks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        Stock currentStock = stocks.get(position);

        TextView tickerLabel = convertView.findViewById(R.id.tickerLabel);
        TextView nameLabel = convertView.findViewById(R.id.nameLabel);
        TextView priceLabel = convertView.findViewById(R.id.priceLabel);
        TextView growthLabel = convertView.findViewById(R.id.growthLabel);

        tickerLabel.setText(currentStock.getTicker());
        nameLabel.setText(currentStock.getName());
        priceLabel.setText(currentStock.getPrice().toString() + "$");
        growthLabel.setText(currentStock.getGrow().toString() + "%");

        if(currentStock.getGrow() < 0){
            growthLabel.setBackgroundColor(Color.RED);
        }
        else{
            growthLabel.setBackgroundColor(Color.GREEN);
        }

        return convertView;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public int getListElementResource() {
        return listElementResource;
    }

    public void removeStock(int index){
        this.stocks.remove(index);

    }
}
