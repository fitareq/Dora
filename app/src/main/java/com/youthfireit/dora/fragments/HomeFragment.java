package com.youthfireit.dora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.youthfireit.dora.adapter.BannerAdapter;
import com.youthfireit.dora.adapter.CategoriesAdapter;
import com.youthfireit.dora.adapter.ProductAdapter;
import com.youthfireit.dora.databinding.FragmentHomeBinding;
import com.youthfireit.dora.models.BannerData;
import com.youthfireit.dora.models.CategoriesData;
import com.youthfireit.dora.models.allproducts.ProductData;
import com.youthfireit.dora.models.allproducts.Products;
import com.youthfireit.dora.network.APIInstance;
import com.youthfireit.dora.network.DoraAPI;
import com.youthfireit.dora.viewmodels.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements
        ProductAdapter.productClickListener, CategoriesAdapter.categoriesClickListener
{


    private FragmentHomeBinding binding;
    private ProductAdapter productAdapter;
    private CategoriesAdapter categoriesAdapter;
    private DoraAPI api;
    private RecyclerView.LayoutManager productsManager, categoryManager;
    private int current = 1, last;
    List<ProductData> productDataList = new ArrayList<>();
    private final homeFragmentClickListener clickListener;
    private HomeViewModel viewModel;

    private BannerAdapter bannerAdapter;


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



        binding.homeSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.homeSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        binding.homeSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.homeSlider.startAutoCycle();

        binding.allCategoriesRecyclerView.setHasFixedSize(true);
        binding.allCategoriesRecyclerView.setNestedScrollingEnabled(false);
        categoryManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        binding.allCategoriesRecyclerView.setLayoutManager(categoryManager);

        binding.allProductRecyclerView.setHasFixedSize(true);
        binding.allProductRecyclerView.setNestedScrollingEnabled(false);
        productsManager = new GridLayoutManager(getContext(), 2);
        binding.allProductRecyclerView.setLayoutManager(productsManager);
        //loadProductData();

        loadBannerData();
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getProducts().observe(getViewLifecycleOwner(), productData -> {
            productAdapter = new ProductAdapter(productData, HomeFragment.this);
            binding.allProductRecyclerView.setAdapter(productAdapter);
        });



        viewModel.getCategories().observe(getViewLifecycleOwner(), categoriesData -> {
            categoriesAdapter = new CategoriesAdapter(categoriesData, HomeFragment.this);
            binding.allCategoriesRecyclerView.setAdapter(categoriesAdapter);
        });
/*

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
                    if(current<=last)
                     loadProductData();
                }
            }
        });
*/


       // Toast.makeText(getContext(), String.valueOf(last), Toast.LENGTH_SHORT).show();

        return v;
    }



    private void loadBannerData() {
        APIInstance.getInstance().api().getBanners().enqueue(new Callback<BannerData>() {
            @Override
            public void onResponse(@NonNull Call<BannerData> call, @NonNull Response<BannerData> response) {
                if (response.isSuccessful())
                    if (response.body()!=null)
                        if (response.body().getIsSuccess().equalsIgnoreCase("true"))
                        {
                            bannerAdapter = new BannerAdapter(response.body().getBannersList());
                            binding.homeSlider.setSliderAdapter(bannerAdapter);
                        }
            }



            @Override
            public void onFailure(Call<BannerData> call, Throwable t) {

            }
        });

    }



    void loadProductData() {


        APIInstance.getInstance().api().getAllProductData(current).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {

                if (response.isSuccessful()) {
                    Products data = response.body();
                    if (data!=null) {
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
                    }
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
    public void onProductClickListener(String id) {
       /* getParentFragmentManager().beginTransaction().add(R.id.main_container, new ProductDetailsFragment(details)).commit();
        Toast.makeText(getContext(), details, Toast.LENGTH_SHORT).show();*/
        clickListener.productClickListener(id);
    }



    @Override
    public void onCategoriesClickListener(String id, String title) {
        clickListener.categoriesClickListener(id, title);
    }



    public interface homeFragmentClickListener
    {
        void productClickListener(String id);
        void categoriesClickListener(String id, String title);
    }


}