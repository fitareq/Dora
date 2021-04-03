package com.youthfireit.dora.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.youthfireit.dora.R;
import com.youthfireit.dora.constants.ConstantResources;
import com.youthfireit.dora.models.Banners;

import java.util.List;


public class BannerAdapter extends SliderViewAdapter<BannerAdapter.BannerViewHolder> {

    private List<Banners> bannersList;



    public BannerAdapter(List<Banners> bannersList) {

        this.bannersList = bannersList;
    }



    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_card,parent,false);
        return new BannerViewHolder(v);
    }



    @Override
    public void onBindViewHolder(BannerViewHolder viewHolder, int position) {

        Banners current = bannersList.get(position);
        String image = current.getBannerPhoto();
        if (image!=null)
        {
            image = ConstantResources.IMAGE_BASE_URL+image;
            Picasso.get().load(image).into(viewHolder.imageView);
        }

    }



    @Override
    public int getCount() {

        return bannersList.size();
    }



    class BannerViewHolder extends SliderViewAdapter.ViewHolder
{


    ImageView imageView;
    public BannerViewHolder(View itemView) {

        super(itemView);
        imageView = itemView.findViewById(R.id.banner_image);
    }




}
}
