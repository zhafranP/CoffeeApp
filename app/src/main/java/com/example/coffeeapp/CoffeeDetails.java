package com.example.coffeeapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coffeeapp.data.CoffeeData;
import com.example.coffeeapp.databinding.FragmentCoffeeDetailsBinding;
import com.example.coffeeapp.model.Coffee;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoffeeDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoffeeDetails extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentCoffeeDetailsBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer coffeeListIndex;

    public CoffeeDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoffeeDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static CoffeeDetails newInstance(String param1, String param2) {
        CoffeeDetails fragment = new CoffeeDetails();
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
            coffeeListIndex = getArguments().getInt("index");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoffeeDetailsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Coffee dataResourceId = new CoffeeData(requireContext()).loadOneCoffee(coffeeListIndex);
        String[] coffeeStringsResource = (requireContext().getResources().getStringArray(dataResourceId.getResourceId()));
        binding.coffeeName.setText(coffeeStringsResource[0]);
        binding.coffeeLongdescription.setText(coffeeStringsResource[2]);
        binding.coffeeImage.setImageResource(dataResourceId.getImageResourceId());

    }
}