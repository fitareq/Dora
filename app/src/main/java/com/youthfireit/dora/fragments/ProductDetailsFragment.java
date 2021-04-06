package com.youthfireit.dora.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.youthfireit.dora.R;
import com.youthfireit.dora.constants.ConstantResources;
import com.youthfireit.dora.databinding.FragmentProductDetailsBinding;
import com.youthfireit.dora.models.ProductDetails;
import com.youthfireit.dora.models.ProductDetailsData;
import com.youthfireit.dora.network.APIInstance;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductDetailsFragment extends Fragment {


    private FragmentProductDetailsBinding binding;
    private String details;
    private String product_description, product_image, product_title, product_max_price, product_min_price, number_of_sales, average_rating,
            total_rating_count, discount, discount_type;
    private String product_id;

    private boolean isDescriptionVisible = false;
    private productDetailsClickListener clickListener;



    public ProductDetailsFragment(String product_id, productDetailsClickListener clickListener) {
        // Required empty public constructor
        this.product_id = product_id;
        this.clickListener = clickListener;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        binding.productDetailsAppbar.setVisibility(View.GONE);
        binding.nestedScroll.setVisibility(View.GONE);
        //product_id = details.replace("https://youthfireit.com/dora/api/v1/products/", "");
        binding.productDetailsSpecificationsWebView.getSettings().setJavaScriptEnabled(true);
        //Toast.makeText(getContext(), details, Toast.LENGTH_SHORT).show();
        loadProductDetails();


       /* binding.productDetailsSpecifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isDescriptionVisible) {
                    binding.productDetailsSpecifications.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    isDescriptionVisible = false;
                    binding.productDetailsSpecificationsWebView.setVisibility(View.GONE);
                } else {
                    binding.productDetailsSpecifications.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    isDescriptionVisible = true;
                    binding.productDetailsSpecificationsWebView.setVisibility(View.VISIBLE);
                }
                //showBottomSheet();
            }
        });*/


        binding.productDetailsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onBackButtonClickListener();
            }
        });


        binding.productDetailsAddToLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.productDetailsAddToLike.setVisibility(View.GONE);
                binding.productDetailsAddedToLike.setVisibility(View.VISIBLE);
            }
        });


        binding.productDetailsAddedToLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.productDetailsAddedToLike.setVisibility(View.GONE);
                binding.productDetailsAddToLike.setVisibility(View.VISIBLE);
            }
        });

        binding.productDetailsAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productAddToCart();
            }
        });

        binding.productDetailsBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productBuyNow();
            }
        });

        return v;
    }



    private void productBuyNow()
    {

        Toast.makeText(getContext(), "Checkout", Toast.LENGTH_SHORT).show();
    }



    private void productAddToCart()
    {

        Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
    }



    void loadProductDetails() {

        APIInstance.getInstance().api()
                .getSingleProducts(product_id)
                .enqueue(new Callback<ProductDetails>() {
                    @Override
                    public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {

                        if (response.isSuccessful()) {
                            ProductDetails data = response.body();
                            if (data != null) {

                                if (data.getIsSuccess().equalsIgnoreCase("true")) {
                                    ProductDetailsData productDetailsData = data.getProductData().get(0);
                                    //Toast.makeText(getContext(), data.getProductData().get(0).getProductName(), Toast.LENGTH_SHORT).show();
                                    product_description = productDetailsData.getProductDescription();
                                    product_image = productDetailsData.getProductThumbnailImage();
                                    product_title = productDetailsData.getProductName();
                                    product_max_price = productDetailsData.getProductPriceHigher();
                                    product_min_price = productDetailsData.getProductPriceLower();
                                    number_of_sales = productDetailsData.getNumberOfSoldProduct();
                                    average_rating = productDetailsData.getProductRating();
                                    total_rating_count = productDetailsData.getTotalRating();
                                    discount = productDetailsData.getProductDiscount();
                                    discount_type = productDetailsData.getProductDiscountType();


                                    String price = ConstantResources.CURRENCY_CODE
                                                           + " " +
                                                           new DecimalFormat("#0.00").format(Double.parseDouble(product_max_price))
                                                           + "-" +
                                                           new DecimalFormat("#0.00").format(Double.parseDouble(product_min_price));


                                    if (product_image != null) {
                                        product_image = ConstantResources.IMAGE_BASE_URL + product_image;
                                        Picasso.get().load(product_image).into(binding.productDetailsImage);
                                    }

                                    binding.productDetailsCollapsingToolbarLayout.setTitle(product_title);
                                    //binding.productDetailsTitle.setText(product_title);
                                    binding.productDetailsPrice.setText(price);
                                    binding.productDetailsTotalOrder.setText(number_of_sales + " sold");
                                    binding.productDetailsRatingStar.setRating(Float.parseFloat(average_rating));
                                    binding.productDetailsTotalRating.setText(total_rating_count);

                                    if (product_description != null) {
                                        /*product_description = product_description.replaceAll("<.*?>", "");
                                        binding.productDetailsDescription.setText(product_description);*/
                                        binding.productDetailsSpecificationsWebView.loadData(product_description, "text/html; charset=utf-8", "UTF-8");
                                    }

                                    binding.progressBar.setVisibility(View.GONE);
                                   // binding.productDetailsBack.setVisibility(View.VISIBLE);
                                    binding.productDetailsAppbar.setVisibility(View.VISIBLE);
                                    binding.nestedScroll.setVisibility(View.VISIBLE);
                                }
                            }
                        }

                    }



                    @Override
                    public void onFailure(Call<ProductDetails> call, Throwable t) {

                        binding.progressBar.setVisibility(View.GONE);
                        binding.productDetailsErrorMessage.setText(t.getMessage());
                        binding.productDetailsError.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }



    private void showBottomSheet() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());


        bottomSheetDialog.setContentView(R.layout.product_specification_bottom_sheet);

        WebView webView = bottomSheetDialog.findViewById(R.id.product_details_specifications_webview);
        webView.getSettings().setJavaScriptEnabled(true);

        if (product_description != null) {
            webView.loadData(product_description, "text/html; charset=utf-8", "UTF-8");
            bottomSheetDialog.show();
        } else Toast.makeText(getContext(), "Empty description", Toast.LENGTH_SHORT).show();
    }



    public interface productDetailsClickListener
    {
        void onBackButtonClickListener();
    }


}