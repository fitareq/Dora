package com.youthfireit.dora.adapter;

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
import com.youthfireit.dora.models.CategoriesData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {


    private List<CategoriesData> categoriesData;
    private View view;
    private categoriesClickListener clickListener;



    public CategoriesAdapter(List<CategoriesData> categoriesData, categoriesClickListener clickListener) {

        this.categoriesData = categoriesData;
        this.clickListener = clickListener;
    }



    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card, parent, false);
        return new CategoriesViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        CategoriesData current = categoriesData.get(position);
        String image = current.getCategoriesBanner();
        String title = current.getCategoriesName();
        String id = current.getCategoriesId();

        if (image != null) {
            image = ConstantResources.IMAGE_BASE_URL + image;
            Picasso.get().load(image).into(holder.imageView);
        }
        holder.textView.setText(title);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCategoriesClickListener(id);
            }
        });
    }



    @Override
    public int getItemCount() {

        return categoriesData.size();
    }



    class CategoriesViewHolder extends RecyclerView.ViewHolder {


        CircleImageView imageView;
        TextView textView;



        public CategoriesViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.categories_card_image);
            textView = itemView.findViewById(R.id.categories_card_title);
            view = itemView;
        }


    }


    public interface categoriesClickListener {


        void onCategoriesClickListener(String id);


    }

}
