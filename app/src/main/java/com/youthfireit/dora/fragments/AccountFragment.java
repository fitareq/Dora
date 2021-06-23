package com.youthfireit.dora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.youthfireit.dora.databinding.FragmentAccountBinding;


public class AccountFragment extends Fragment {
    private FragmentAccountBinding binding;
    private final accountEventListener eventListener;



    public AccountFragment(accountEventListener eventListener) {
        // Required empty public constructor
        this.eventListener = eventListener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        eventListener.onUserNotLoggedInListener();
        return v;
    }


    public interface accountEventListener
    {
        void onUserNotLoggedInListener();
    }


}