package com.youthfireit.dora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youthfireit.dora.R;
import com.youthfireit.dora.databinding.FragmentRegistrationBinding;
import com.youthfireit.dora.models.SignUp;
import com.youthfireit.dora.network.APIInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends Fragment {


    private FragmentRegistrationBinding binding;

    String name, phone, email, password, confirmPassword;

    private registrationEventListener eventListener;

    public RegistrationFragment(registrationEventListener eventListener) {
        // Required empty public constructor
        this.eventListener = eventListener;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        View v = binding.getRoot();


        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.createAccountName.getText().toString();
                phone = binding.createAccountPhone.getText().toString();
                email = binding.createAccountEmail.getText().toString();
                password = binding.createAccountPass.getText().toString();
                confirmPassword = binding.createAccountConfirmPass.getText().toString();

                if (TextUtils.isEmpty(name))
                {
                    binding.createAccountName.setError("Required field");
                }else if (TextUtils.isEmpty(phone))
                {
                    binding.createAccountPhone.setError("Required field");
                }else if (TextUtils.isEmpty(email))
                {
                    binding.createAccountEmail.setError("Required field");
                }else if (TextUtils.isEmpty(password))
                {
                    binding.createAccountPass.setError("Required field");
                }else if (TextUtils.isEmpty(confirmPassword))
                {
                    binding.createAccountConfirmPass.setError("Required field");
                }else if (!TextUtils.equals(password,confirmPassword))
                {
                    binding.createAccountPass.setError("Password didn't match");
                }
                else if (password.length()<6)
                {
                    binding.createAccountPass.setError("At least 6 character");
                }else
                {
                    SignUp signUp = new SignUp(name,email,phone,password);
                    registerUser(signUp);
                }
            }
        });


        return v;
    }



    private void registerUser(SignUp signUp) {

        APIInstance.getInstance().api().userSignUp(signUp).enqueue(new Callback<SignUp>() {
            @Override
            public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                if (response.isSuccessful())
                    if (response.code()==201)
                    {
                        eventListener.onRegistrationSuccess();
                    }
            }



            @Override
            public void onFailure(Call<SignUp> call, Throwable t) {

            }
        });
    }


    public interface registrationEventListener
    {
        void onRegistrationSuccess();
    }


}