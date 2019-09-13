package com.example.prudhvi.approtech.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prudhvi.approtech.R;
import com.example.prudhvi.approtech.model.Forest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    Forest forest;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (getIntent().getExtras() != null) {
            forest = (Forest) getIntent().getSerializableExtra("model");

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double lat = Double.parseDouble(forest.getLat());
        double lng = Double.parseDouble(forest.getLng());


        LatLng latLng = new LatLng(lat, lng);

        googleMap.addMarker(new MarkerOptions().position(latLng).title(forest.getAddress()));


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(lat,lng))             // Sets the center of the map to current location
                .zoom(15)                   // Sets the zoom
                .tilt(30)                   // Sets the tilt of the camera to 0 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }
}
