package com.youthfireit.dora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youthfireit.dora.R;
import com.youthfireit.dora.databinding.FragmentCartBinding;
import com.youthfireit.dora.databinding.FragmentHomeBinding;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;


    public CartFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }




}