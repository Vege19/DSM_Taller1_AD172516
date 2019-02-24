package com.example.taller1_recyclerviewmapview.Network;

import com.example.taller1_recyclerviewmapview.Models.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceRequest {

    List<Place> places = new ArrayList<>();

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
