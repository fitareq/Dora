package com.youthfireit.dora.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youthfireit.dora.adapter.ProductAdapter;
import com.youthfireit.dora.databinding.FragmentCategoryWiseProductsBinding;
import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.viewmodels.CategoryWiseProductsViewModel;

import java.util.List;


public class CategoryWiseProductsFragment extends Fragment implements ProductAdapter.productClickListener {


    private String categoryId, categoryName;
    private FragmentCategoryWiseProductsBinding binding;
    private CategoryWiseProductsViewModel viewModel;
    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager manager;
    private CategoryWiseProductsFragmentClickListener clickListener;



    public CategoryWiseProductsFragment(String categoryId, String categoryName, CategoryWiseProductsFragmentClickListener clickListener) {
        // Required empty public constructor
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.clickListener = clickListener;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoryWiseProductsBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        binding.categoryWiseToolbar.setTitle(categoryName);

        manager = new GridLayoutManager(getContext(), 2);

        binding.categoryWiseAllProductsRview.setHasFixedSize(true);
        binding.categoryWiseAllProductsRview.setLayoutManager(manager);
        viewModel = new ViewModelProvider(this).get(CategoryWiseProductsViewModel.class);
        viewModel.initializeRepo(categoryId);
        viewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<ProductData>>() {
            @Override
            public void onChanged(List<ProductData> productData) {

                productAdapter = new ProductAdapter(productData, CategoryWiseProductsFragment.this);
                binding.categoryWiseAllProductsRview.setAdapter(productAdapter);
            }
        });

        binding.categoryWiseToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCWBackBtnClick();
            }
        });
        return v;
    }



    @Override
    public void onProductClickListener(String id) {

        clickListener.categoryWiseProductClickListener(id);
    }



    public interface CategoryWiseProductsFragmentClickListener {


        void categoryWiseProductClickListener(String id);
        void onCWBackBtnClick();




    }




}