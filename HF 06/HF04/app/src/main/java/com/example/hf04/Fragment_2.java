package com.example.hf04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String SELECTED_ISO = "selected_iso";
    private static final String SELECTED_FLAG = "selected_flag";
    private static final String SELECTED_BUY_PRICE = "selected_buy_price";
    private static final String SELECTED_SELL_PRICE = "selected_sell_price";
    private static final String SELECTED_NAME = "selected_name";


    private  String selectedISO;
    private  int selectedFlag;
    private  String selectedBuyPrice;
    private  String selectedSellPrice;
    private  String selectedName;

    public Fragment_2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Fragment_2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_2 newInstance(String selectedISO, int selectedFlag, String selectedBuyPrice, String selectedSellPrice, String selectedName) {
        Fragment_2 fragment = new Fragment_2();
        Bundle args = new Bundle();

        args.putString(SELECTED_ISO, selectedISO);
        args.putInt(SELECTED_FLAG, selectedFlag);
        args.putString(SELECTED_BUY_PRICE, selectedBuyPrice);
        args.putString(SELECTED_SELL_PRICE, selectedSellPrice);
        args.putString(SELECTED_NAME, selectedName);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedName = getArguments().getString(SELECTED_NAME);
            selectedFlag = getArguments().getInt(SELECTED_FLAG);
            selectedBuyPrice = getArguments().getString(SELECTED_BUY_PRICE);
            selectedSellPrice = getArguments().getString(SELECTED_SELL_PRICE);
            selectedISO = getArguments().getString(SELECTED_ISO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        TextView isoTextView = rootView.findViewById(R.id.iso);
        ImageView flagImageView = rootView.findViewById(R.id.img);
        TextView buyPriceTextView = rootView.findViewById(R.id.buyPrice);
        TextView sellPriceTextView = rootView.findViewById(R.id.sellPrice);
        TextView nameTextView = rootView.findViewById(R.id.name);

        isoTextView.setText(selectedISO);
        flagImageView.setImageResource(selectedFlag);
        buyPriceTextView.setText("Cumpara: " + selectedBuyPrice);
        sellPriceTextView.setText("Vinde: " + selectedSellPrice);
        nameTextView.setText(selectedName);

        return rootView;

  }
}