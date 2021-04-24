package com.youthfireit.dora.fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.youthfireit.dora.R;
import com.youthfireit.dora.adapter.ProductAdapter;
import com.youthfireit.dora.constants.ConstantResources;
import com.youthfireit.dora.databinding.FragmentProductDetailsBinding;
import com.youthfireit.dora.models.productdetails.ProductDetails;
import com.youthfireit.dora.models.productdetails.ProductDetailsData;
import com.youthfireit.dora.models.productdetails.RelatedProducts;
import com.youthfireit.dora.network.APIInstance;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProductDetailsFragment extends Fragment implements ProductAdapter.productClickListener{


    private FragmentProductDetailsBinding binding;
    private String details;
    private String product_description, product_image, product_title, product_max_price, product_min_price, number_of_sales, average_rating,
            total_rating_count, discount, discount_type;
    private String product_id;

    private boolean isDescriptionVisible = false;
    private productDetailsClickListener clickListener;




    private ProductAdapter productAdapter;
    private RecyclerView.LayoutManager productsManager;

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
        binding.productDetailsSpecificationsWebView.getSettings().setJavaScriptEnabled(true);

        loadProductDetails();


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



    private void productBuyNow() {

        Toast.makeText(getContext(), "Checkout", Toast.LENGTH_SHORT).show();
    }



    private void productAddToCart() {

        Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
        showBottomSheet();
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


                                    String price;

                                    if (!product_max_price.equalsIgnoreCase(product_min_price)) {
                                        price = ConstantResources.CURRENCY_CODE
                                                        + " " +
                                                        new DecimalFormat("#0.00").format(Double.parseDouble(product_max_price))
                                                        + "-" +
                                                        new DecimalFormat("#0.00").format(Double.parseDouble(product_min_price));
                                    }else price = ConstantResources.CURRENCY_CODE+new DecimalFormat("#0.00").format(Double.parseDouble(product_max_price));


                                    if (product_image != null) {
                                        product_image = ConstantResources.IMAGE_BASE_URL + product_image;
                                        Picasso.get().load(product_image).into(binding.productDetailsImage);
                                    }

                                    //binding.productDetailsCollapsingToolbarLayout.setTitle(product_title);
                                    binding.productDetailsTitle.setText(product_title);


                                    binding.productDetailsTotalOrder.setText(number_of_sales + " sold");
                                    binding.productDetailsRatingStar.setRating(Float.parseFloat(average_rating));
                                    binding.productDetailsTotalRating.setText(total_rating_count);

                                    if (!discount.equalsIgnoreCase("0"))
                                    {
                                        binding.productDetailsOldPrice.setText(price);
                                        binding.productDetailsOldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                                    }else {
                                        binding.productDetailsOldPrice.setVisibility(View.GONE);
                                        binding.productDetailsDiscountPercent.setVisibility(View.GONE);
                                    }

                                    if(discount_type.equalsIgnoreCase("percent"))
                                    {
                                        String newMaxPrice = ConstantResources.calculateDiscountAmountFromPercent(product_max_price, discount);
                                        String newMinPrice = ConstantResources.calculateDiscountAmountFromPercent(product_min_price, discount);
                                        String newPrice = ConstantResources.CURRENCY_CODE
                                                                  + " " +
                                                                  new DecimalFormat("#0.00").format(Double.parseDouble(newMaxPrice))
                                                                  + "-" +
                                                                  new DecimalFormat("#0.00").format(Double.parseDouble(newMinPrice));
                                        binding.productDetailsDiscountPercent.setText("-"+discount+"%");
                                        binding.productDetailsPrice.setText(newPrice);
                                    }else {
                                        String newMaxPrice = String.valueOf(Double.parseDouble(product_max_price)-Integer.parseInt(discount));
                                        String newMinPrice = String.valueOf(Double.parseDouble(product_min_price)-Integer.parseInt(discount));
                                        String dis = ConstantResources.calculateDiscountPercentage(product_max_price,newMaxPrice);
                                        String newPrice = ConstantResources.CURRENCY_CODE
                                                                  + " " +
                                                                  new DecimalFormat("#0.00").format(Double.parseDouble(newMaxPrice))
                                                                  + "-" +
                                                                  new DecimalFormat("#0.00").format(Double.parseDouble(newMinPrice));
                                        binding.productDetailsDiscountPercent.setText("-"+dis+"%");
                                        binding.productDetailsPrice.setText(newPrice);
                                    }

                                    if (product_description != null) {
                                        /*product_description = product_description.replaceAll("<.*?>", "");
                                        binding.productDetailsDescription.setText(product_description);*/
                                        binding.productDetailsSpecificationsWebView.loadData(product_description, "text/html; charset=utf-8", "UTF-8");
                                    }

                                    binding.progressBar.setVisibility(View.GONE);
                                    // binding.productDetailsBack.setVisibility(View.VISIBLE);
                                    binding.productDetailsAppbar.setVisibility(View.VISIBLE);
                                    binding.nestedScroll.setVisibility(View.VISIBLE);

                                    getRelatedProducts(product_id);
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



    private void getRelatedProducts(String product_id)

    {
        APIInstance
                .getInstance()
                .api()
                .getRelatedProducts(product_id)
                .enqueue(new Callback<RelatedProducts>()
                {
            @Override
            public void onResponse(Call<RelatedProducts> call, Response<RelatedProducts> response) {
                if (response.isSuccessful())
                {
                    RelatedProducts data = response.body();
                    if (data!=null)
                    {
                        if (data.getIsSuccess().equalsIgnoreCase("true"))
                        {
                            binding.productDetailsRelatedProductsRview.setHasFixedSize(true);
                            binding.productDetailsRelatedProductsRview.setNestedScrollingEnabled(false);
                            productsManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL,false);
                            binding.productDetailsRelatedProductsRview.setLayoutManager(productsManager);
                            productAdapter = new ProductAdapter(data.getProductData(),ProductDetailsFragment.this);
                            binding.productDetailsRelatedProductsRview.setAdapter(productAdapter);
                        }
                    }
                }
            }



            @Override
            public void onFailure(Call<RelatedProducts> call, Throwable t) {

            }
        });
    }



    private void showBottomSheet() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());


        bottomSheetDialog.setContentView(R.layout.product_specification_bottom_sheet);

        TextView title = bottomSheetDialog.findViewById(R.id.bottom_sheet_product_title);
        TextView price = bottomSheetDialog.findViewById(R.id.bottom_sheet_product_price);
        ImageButton quantityAdd = bottomSheetDialog.findViewById(R.id.bottom_sheet_quantity_add);
        ImageButton quantitySub = bottomSheetDialog.findViewById(R.id.bottom_sheet_quantity_sub);
        ImageView image = bottomSheetDialog.findViewById(R.id.bottom_sheet_product_image);
        Button addToCartButton = bottomSheetDialog.findViewById(R.id.bottom_sheet_add_to_cart);
        TextView quantity = bottomSheetDialog.findViewById(R.id.bottom_sheet_quantity);


        //String q = quantity.getText().toString();

        title.setText(product_title);
        price.setText(product_max_price);
        if (product_image != null)
            Picasso.get().load(product_image).into(image);

        quantitySub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int q = Integer.parseInt(quantity.getText().toString());
                if (q > 1) {
                    --q;
                    quantity.setText(String.valueOf(q));
                }

            }
        });
        quantityAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int q = Integer.parseInt(quantity.getText().toString());
                ++q;
                quantity.setText(String.valueOf(q));
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "added to cart", Toast.LENGTH_SHORT).show();
            }
        });


        bottomSheetDialog.show();
    }



    @Override
    public void onProductClickListener(String id) {
        clickListener.onRelatedProductClickListener(id);
    }



    public interface productDetailsClickListener {


        void onBackButtonClickListener();
        void onRelatedProductClickListener(String id);




    }




}