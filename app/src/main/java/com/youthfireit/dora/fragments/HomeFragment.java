package com.youthfireit.dora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.youthfireit.dora.adapter.ProductAdapter;
import com.youthfireit.dora.databinding.FragmentHomeBinding;
import com.youthfireit.dora.models.ProductData;
import com.youthfireit.dora.models.Products;
import com.youthfireit.dora.network.APIinstance;
import com.youthfireit.dora.network.DoraAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private ProductAdapter productAdapter;
    private DoraAPI api;
    private RecyclerView.LayoutManager productsManager;



    public HomeFragment() {
        // Required empty public constructor
        api = APIinstance.retroInstance().create(DoraAPI.class);
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        binding.allProductRecyclerView.setHasFixedSize(true);
        binding.allProductRecyclerView.setNestedScrollingEnabled(false);
        productsManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        binding.allProductRecyclerView.setLayoutManager(productsManager);
        loadProductData();

        return v;
    }



    void loadProductData() {


        Call<ProductData> call = api.getAllProductData();
        call.enqueue(new Callback<ProductData>() {
            @Override
            public void onResponse(Call<ProductData> call, Response<ProductData> response) {

                if (response.isSuccessful()) {
                    ProductData data = response.body();
                    if (data.getIsSuccess().equalsIgnoreCase("true")) {
                        List<Products> products = data.getProductData();
                        productAdapter = new ProductAdapter(products);
                        binding.allProductRecyclerView.setAdapter(productAdapter);
                    } else
                        Toast.makeText(getContext(), "not successful", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "response not successful", Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onFailure(Call<ProductData> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }




}