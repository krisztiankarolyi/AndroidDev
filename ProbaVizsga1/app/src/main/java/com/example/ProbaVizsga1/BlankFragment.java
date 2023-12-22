package com.example.ProbaVizsga1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    final static String[] DAYS  = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

    // TODO: Rename and change types of parameters

    private static ListView listView;
    private  TextView title;

    public BlankFragment() {
        // Required empty public constructor
    }

    public BlankFragment(TextView title) {
        this.title = title;
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, DAYS);
        listView = view.findViewById(R.id.lista);
        listView.setAdapter(adapter);

        View activityView = getActivity().findViewById(R.id.thirdActivity);
        this.title = activityView.findViewById(R.id.titleText);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(DAYS[position]);
            }
        });

        return view;
    }
}