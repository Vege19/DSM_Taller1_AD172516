package com.example.taller1_recyclerviewmapview.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.taller1_recyclerviewmapview.Models.Place;
import com.example.taller1_recyclerviewmapview.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<Place> places;
    private Context context;

    public PlaceAdapter(List<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_place, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Place place = places.get(i);

        viewHolder.mPlaceName.setText(place.getName());

        //set image with glide
        Glide.with(context)
                .load(place.getImage_url())
                .into(viewHolder.mPlaceImage);

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mPlaceName;
        private ImageView mPlaceImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mPlaceImage = itemView.findViewById(R.id.placeImage);
            mPlaceName = itemView.findViewById(R.id.placeName);

        }

    }

}
