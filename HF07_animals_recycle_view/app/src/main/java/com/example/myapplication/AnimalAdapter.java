package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.VH> {
    private Context context;
    private List<Animal> animals;

    public AnimalAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.list_item, parent, false);
        return new VH(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.VH holder, int position) {
        Animal animal = animals.get(position);
        if (holder.itemView != null) {
            holder.rootView.setTag(animal);
            holder.name.setText(animal.getName());
            holder.image.setImageResource(animal.getImgRes());
            holder.details.setText(animal.getDetails());
        }
        else
        {
            Toast.makeText(context.getApplicationContext(), "Hiba",Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        public View rootView ;
        public ImageView image;
        public TextView name;
        public TextView details;

       public VH(@NonNull View itemView, Context context) {
            super(itemView);
            rootView = itemView;
            image = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            details = itemView.findViewById(R.id.details);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animal animal = (Animal) rootView.getTag();
                    Toast.makeText(context.getApplicationContext(), animal.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
}


}