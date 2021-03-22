package com.youthfireit.dora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youthfireit.dora.adapter.ProductAdapter;
import com.youthfireit.dora.databinding.FragmentHomeBinding;
import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.models.allproducts.Products;
import com.youthfireit.dora.network.APIInstance;
import com.youthfireit.dora.network.DoraAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements ProductAdapter.productClickListener {


    private FragmentHomeBinding binding;
    private ProductAdapter productAdapter;
    private DoraAPI api;
    private RecyclerView.LayoutManager productsManager;
    private int current = 1, last;
    List<ProductData> productDataList = new ArrayList<>();
    private homeFragmentClickListener clickListener;



    public HomeFragment(homeFragmentClickListener clickListener) {
        // Required empty public constructor
        //api = APIInstance.retroInstance().create(DoraAPI.class);
        this.clickListener = clickListener;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        binding.allProductRecyclerView.setHasFixedSize(true);
        binding.allProductRecyclerView.setNestedScrollingEnabled(false);
        productsManager = new GridLayoutManager(getContext(), 2);
        binding.allProductRecyclerView.setLayoutManager(productsManager);
        loadProductData();

        binding.allProductRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }



            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (layoutManager != null &&
                            layoutManager.findLastCompletelyVisibleItemPosition() == productAdapter.getItemCount() - 1) {
                    ++current;
                    loadProductData();
                }
            }
        });


       // Toast.makeText(getContext(), String.valueOf(last), Toast.LENGTH_SHORT).show();

        return v;
    }



    void loadProductData() {


        APIInstance.getInstance().api().getAllProductData(current).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {

                if (response.isSuccessful()) {
                    Products data = response.body();
                    if (data.getIsSuccess().equalsIgnoreCase("true")) {
                        //List<ProductData> products = data.getProductData();
                        productDataList.addAll(data.getProductData());
                        last = Integer.parseInt(data.getProductsMetaData().getLastPage());
                        //Toast.makeText(getContext(), String.valueOf(last), Toast.LENGTH_SHORT).show();
                        productAdapter = new ProductAdapter(productDataList, HomeFragment.this);
                        binding.allProductRecyclerView.setAdapter(productAdapter);
                        if (current > 1)
                            productAdapter.notifyDataSetChanged();
                    } else
                        Toast.makeText(getContext(), "not successful", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "response not successful", Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onFailure(Call<Products> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onProductClickListener(String details) {
       /* getParentFragmentManager().beginTransaction().add(R.id.main_container, new ProductDetailsFragment(details)).commit();
        Toast.makeText(getContext(), details, Toast.LENGTH_SHORT).show();*/
        clickListener.productClickListener(details);
    }


    public interface homeFragmentClickListener
    {
        void productClickListener(String details);
    }


}