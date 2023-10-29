package com.example.hf05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = findViewById(R.id.list);
        String[] stringArray = getResources().getStringArray(R.array.listItems);
        listItems.addAll(Arrays.asList(stringArray));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, listItems);
        myList.setAdapter(adapter);

        registerForContextMenu(myList);


   }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); //melyik szint nyomta meg

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo(); //maga a cotnext menu informacioi
        int position = info.position;  // eltaroljuk hogy hanyadik listaelemnel nyitottuk meg a context menut

        if (id == R.id.piros) {
            changeTextColor(position, Color.RED);
        } else if (id == R.id.zold) {
            changeTextColor(position, Color.GREEN);
        } else if (id == R.id.sarga) {
            changeTextColor(position, Color.YELLOW);
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.rendez) {
            listItems.sort(new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo(t1);
                }
            });
            adapter.notifyDataSetChanged();

        }
        if (id == R.id.torol) {
            listItems.removeAll(listItems);
            adapter.notifyDataSetChanged();
        }

        return true;
    }

    private void changeTextColor(int position, int color) {
        View view = myList.getChildAt(position); // lekérjük a feldoglozandó sor elemet (mint view) a listából a pozicio segitsegevel
        if (view != null) {
            //közvetlen hozzáférés a lista elem text eleméhez majd annak XML tulajdonságát módostjuk
            TextView textView = view.findViewById(android.R.id.text1);
            textView.setTextColor(color);

        }
    }
}