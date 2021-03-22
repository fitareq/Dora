package com.youthfireit.dora.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youthfireit.dora.R;
import com.youthfireit.dora.databinding.FragmentProductDetailsBinding;
import com.youthfireit.dora.models.ProductDetails;
import com.youthfireit.dora.network.APIInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductDetailsFragment extends Fragment {


    private FragmentProductDetailsBinding binding;
    private String details;
    private int id;


    public ProductDetailsFragment(String details) {
        // Required empty public constructor
        this.details = details;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater,container,false);
        View v = binding.getRoot();

        details =details.replace("https://youthfireit.com/dora/api/v1/products/", "");
        Toast.makeText(getContext(), details, Toast.LENGTH_SHORT).show();
        loadProductDetails();

        return v;
    }


    void loadProductDetails()
    {

        APIInstance.getInstance().api()
                .getSingleProducts(details)
                .enqueue(new Callback<ProductDetails>() {
                    @Override
                    public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                        if (response.isSuccessful())
                        {
                            ProductDetails data = response.body();
                            if (data.getIsSuccess().equalsIgnoreCase("true"))
                            {
                                Toast.makeText(getContext(), data.getProductData().get(0).getProductName(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    }



                    @Override
                    public void onFailure(Call<ProductDetails> call, Throwable t) {

                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}