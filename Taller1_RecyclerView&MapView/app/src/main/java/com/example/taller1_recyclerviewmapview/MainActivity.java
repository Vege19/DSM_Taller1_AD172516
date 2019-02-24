package com.example.taller1_recyclerviewmapview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.taller1_recyclerviewmapview.Adapters.PlaceAdapter;
import com.example.taller1_recyclerviewmapview.Models.Place;
import com.example.taller1_recyclerviewmapview.Network.ApiService;
import com.example.taller1_recyclerviewmapview.Network.PlaceRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPlacesFromJson();

    }

    private void getPlacesFromJson() {

        //retrofit setup
        Retrofit retrofit;
        ApiService apiService;

        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Vege19/DSM_Taller1_AD172516/master/Taller1_RecyclerView%26MapView/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //CallRequest
        apiService = retrofit.create(ApiService.class);

        Call<PlaceRequest> placeRequestCall = apiService.getPlaces();

        placeRequestCall.enqueue(new Callback<PlaceRequest>() {
            @Override
            public void onResponse(Call<PlaceRequest> call, Response<PlaceRequest> response) {

                if (response.isSuccessful()) {
                    //get place list from request
                    PlaceRequest placeRequest = response.body();
                    List<Place> places = placeRequest.getPlaces();

                    //recyclerview setup
                    RecyclerView mRecyclerView = findViewById(R.id.recylerView);
                    mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                    mRecyclerView.setAdapter(new PlaceAdapter(places, MainActivity.this));

                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<PlaceRequest> call, Throwable t) {

            }

        });

    }

}
