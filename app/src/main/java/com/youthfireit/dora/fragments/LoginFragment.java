package com.youthfireit.dora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youthfireit.dora.databinding.FragmentLoginBinding;
import com.youthfireit.dora.models.login.Login;
import com.youthfireit.dora.network.APIInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends Fragment {

private FragmentLoginBinding  binding;
String email, password;
boolean rememberMe = false;



    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        View v = binding.getRoot();


        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.signInEmail.getText().toString();
                password = binding.signInPass.getText().toString();
                if (binding.rememberMe.isSelected())
                    rememberMe = true;
                if (TextUtils.isEmpty(email))
                {
                    binding.signInEmail.setError("Required field");
                }else if (TextUtils.isEmpty(password))
                {
                    binding.signInPass.setError("Required field");
                }else
                {
                    Login login = new Login(email,password,rememberMe);
                    userLogin(login);
                }
            }
        });
        return v;
    }



    private void userLogin(Login login) {

        APIInstance.getInstance().api().userLogin(login).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(getContext(), "successfull", Toast.LENGTH_SHORT).show();
                }
            }



            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }




}