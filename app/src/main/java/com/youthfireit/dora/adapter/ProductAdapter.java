package com.youthfireit.dora.adapter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.youthfireit.dora.R;
import com.youthfireit.dora.constants.ConstantResources;
import com.youthfireit.dora.models.allproducts.ProductData;

import java.text.DecimalFormat;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {


    private List<ProductData> products;

    private View view;
    private productClickListener clickListener;



    public ProductAdapter(List<ProductData> products, productClickListener clickListener) {

        this.products = products;
        this.clickListener = clickListener;
    }



    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_card, null);
        return new ProductHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        ProductData current = products.get(position);

        String id = current.getProductId();

        String image = current.getProductsThumbnailImage();
        String title = current.getProductsName();
        String price = current.getProductsBaseDiscountedPrice();
        String old_price = current.getProductsBasePrice();
        String sale_count = current.getProductsSold();

        String percent = ConstantResources.calculateDiscountPercentage(old_price, price);

        if (image != null) {
            String s = ConstantResources.IMAGE_BASE_URL + image;
            Picasso.get().load(s).into(holder.imageView);
        }

        holder.productTitle.setText(title);
        if (old_price.equalsIgnoreCase(price)) {
            holder.oldPrice.setVisibility(View.GONE);
            holder.productPercent.setVisibility(View.GONE);
            holder.productDivider.setVisibility(View.GONE);
        } else {
            holder.oldPrice.setText("৳" + " " + new DecimalFormat("#0.00").format(Double.parseDouble(old_price)));
            holder.productPercent.setText("-" + percent + "%");
            holder.oldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.productPrice.setText("৳" + " " + new DecimalFormat("#0.00").format(Double.parseDouble(price)));
        if (sale_count.equalsIgnoreCase("0"))
            holder.saleCount.setVisibility(View.GONE);
        else
            holder.saleCount.setText(sale_count + " sold");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onProductClickListener(id);
            }
        });

    }



    @Override
    public int getItemCount() {

        return products.size();
    }



    public class ProductHolder extends RecyclerView.ViewHolder {


        public ImageView imageView;
        public TextView productTitle, productPrice, oldPrice, saleCount, productPercent, productDivider;



        public ProductHolder(@NonNull View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.product_card_image);
            productTitle = itemView.findViewById(R.id.product_card_title);
            productPrice = itemView.findViewById(R.id.product_card_price);
            oldPrice = itemView.findViewById(R.id.product_card_old_price);
            saleCount = itemView.findViewById(R.id.product_card_sold_count);
            productPercent = itemView.findViewById(R.id.product_card_discount_percent);
            productDivider = itemView.findViewById(R.id.product_card_divider);


            view = itemView;
        }




    }


    public interface productClickListener {


        void onProductClickListener(String id);


    }




}
