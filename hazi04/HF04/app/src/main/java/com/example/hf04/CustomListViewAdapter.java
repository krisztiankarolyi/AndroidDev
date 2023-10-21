package com.example.hf04;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter {
    private final Activity context;
    private final Integer[] images;
    private final String[] isos;
    private final String[] names;
    private final String[] buyPArray;
    private final String[] sellPArray;

    public CustomListViewAdapter(Activity context, Integer[] images, String[] isos, String[] names, String[] buyP, String[] sellP) {
        super(context, R.layout.list_item, isos);
        this.context = context;
        this.images = images;
        this.isos = isos;
        this.names = names;
        this.buyPArray = buyP;
        this.sellPArray = sellP;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        ImageView flag = rowView.findViewById(R.id.flag);
        TextView name = rowView.findViewById(R.id.name);
        TextView iso = rowView.findViewById(R.id.iso);
        TextView buyP = rowView.findViewById(R.id.cumpara3);
        TextView sellP = rowView.findViewById(R.id.vinde);
        flag.setImageResource(images[position]);
        name.setText(names[position]);
        iso.setText(isos[position]);
        buyP.setText(buyPArray[position]);
        sellP.setText(sellPArray[position]);
        return rowView;
    }
}
