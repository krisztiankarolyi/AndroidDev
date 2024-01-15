package com.example.gyakorlas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleActivtiy extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_activtiy);

        Person p = new Person("Wojak", R.drawable.wojak);
        persons.add(p);

        adapter = new PersonsAdapter(getApplicationContext(), persons);
        recyclerView = findViewById(R.id.recycleView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }
}

class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder>{
    private ArrayList<Person> persons = new ArrayList<Person>();
    private Context context;

    public PersonsAdapter(Context context, ArrayList<Person> persons) {
        this.persons = persons;
        this.context = context;
    }

    @NonNull
    @Override
    // to inflate the layout for each item of recycler view.
    public PersonsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    // to set data to textview and imageview of each card layout
    public void onBindViewHolder(@NonNull PersonsAdapter.ViewHolder holder, int position) {
        holder.nameHolder.setText(persons.get(position).getName());
        holder.imgHolder.setImageResource(persons.get(position).getAvatar());
    }

    @Override
    public int getItemCount() {
        return this.persons.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
    // View holder class for initializing of your views such as TextView and Imageview
        private final ImageView imgHolder;
        private final TextView nameHolder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHolder = itemView.findViewById(R.id.imagePlace);
            nameHolder = itemView.findViewById(R.id.nameTextView);
        }
    }
}
