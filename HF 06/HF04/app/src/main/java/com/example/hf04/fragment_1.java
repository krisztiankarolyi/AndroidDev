package com.example.hf04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_1 extends Fragment {
    ListView myList;
    Integer[] flags = {
            R.drawable.eu, R.drawable.usa, R.drawable.uk, R.drawable.austr, R.drawable.can, R.drawable.swi, R.drawable.den, R.drawable.hu
    };
    String[] iso_codes = {
            "EUR", "USD", "GBP", "AUD",  "CAD", "CHF",  "DFF", "HUF"
    };

    String[] names = {
            "Euro",  "Dollar American",  "Liria sterlina", "Dollar Australian",
            "Dollar canadian",  "Franc Elvetian",  "Corona Daneza",  "Forint Maghiar",
    };

    String[] buyPrices = {
            "4,4100 RON", "3,9750 RON", "6,1250 RON",
            "2,9600 RON", "3,0950 RON", "4,2300 RON",
            "0,5850 RON", "0,0136 RON",
    };

    String[] sellPrices = {
            "4,5500 RON", "4,1450 RON", "6,3550 RON",
            "3,0600 RON", "3,2650 RON",
            "4,3300 RON", "0,6150 RON", "0,0146 RON"
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    protected static final String FRAG2 = "2";

    public fragment_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_1 newInstance(String param1, String param2) {
        fragment_1 fragment = new fragment_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        myList = view.findViewById(R.id.currencies_list); // Az itt hozzáférhetünk a ListView-hoz
        Context context = getActivity().getApplicationContext();
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(), flags, iso_codes, names, buyPrices, sellPrices);
        myList.setAdapter(adapter);
        FragmentManager fm = getParentFragmentManager();

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view instanceof TextView) {
                    String isoCode = iso_codes[position]; // Az ISO kód kiolvasása
                    String buyPrice = buyPrices[position]; // A vételi ár kiolvasása

                    if (fm.findFragmentByTag(FRAG2) != null) {
                        TextView selectedOpt = getActivity().findViewById(R.id.selectedCurrency);
                        selectedOpt.setText("You have selected " + isoCode + " - " + buyPrice);
                    } else {
                        Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                        intent.putExtra("iso_code", isoCode);
                        intent.putExtra("buy_price", buyPrice);
                        startActivity(intent);
                    }
                }
            }
        });

        return view;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_1, container, false);
    }
}