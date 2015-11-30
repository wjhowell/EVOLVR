package com.example.evolvr.evolvr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

public class MapBoxActivity extends AppCompatActivity {

    private MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_box);

        mapView = (MapView) findViewById(R.id.mapview);
        //mapView.setStyleUrl(Style.MAPBOX_STREETS);
        mapView.setStyleUrl("mapbox://styles/wjhowell/cihl9cng7000lsikx220kkr8p");
        mapView.setCenterCoordinate(new LatLng(42.277112, -83.738152));
        mapView.setZoomLevel(14);
        mapView.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause()  {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}
