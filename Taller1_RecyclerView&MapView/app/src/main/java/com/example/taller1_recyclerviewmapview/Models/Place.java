package com.example.taller1_recyclerviewmapview.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private int id;
    private String name;
    private String description;
    private String image_url;
    private float map_lat;
    private float map_long;

    protected Place(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        image_url = in.readString();
        map_lat = in.readFloat();
        map_long = in.readFloat();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getMap_lat() {
        return map_lat;
    }

    public void setMap_lat(float map_lat) {
        this.map_lat = map_lat;
    }

    public float getMap_long() {
        return map_long;
    }

    public void setMap_long(float map_long) {
        this.map_long = map_long;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(image_url);
        dest.writeFloat(map_lat);
        dest.writeFloat(map_long);
    }
}
