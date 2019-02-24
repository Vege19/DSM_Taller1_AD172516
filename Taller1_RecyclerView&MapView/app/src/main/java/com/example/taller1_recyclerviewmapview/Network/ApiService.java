package com.example.taller1_recyclerviewmapview.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("maps.json")
    Call<PlaceRequest> getPlaces();

}
