package com.example.taller1_recyclerviewmapview;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.taller1_recyclerviewmapview.Models.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //set support to our actionbar
        Toolbar mToolBar = findViewById(R.id.mapToolBar);
        setActionBar(mToolBar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        //back button
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapsActivity.this.finish();

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //get parcelable data
        Place place = getIntent().getParcelableExtra("details");

        // Add a marker in this place and move the camera
        LatLng latLng = new LatLng(place.getMap_lat(), place.getMap_long());
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marcador en " + place.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 8.0f));

        //set place name in the toolbar
        getActionBar().setTitle(place.getName());

        //set place image
        ImageView mPlaceImage = findViewById(R.id.placeDetailImage);

        Glide.with(this)
                .load(place.getImage_url())
                .into(mPlaceImage);

        //set place description
        TextView mPlaceDescription = findViewById(R.id.placeDescription);
        mPlaceDescription.setText(place.getDescription());

    }
}
