package com.example.evolvr.evolvr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;


import com.google.android.gms.maps.model.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import android.support.v4.content.ContextCompat;
import com.mapbox.mapboxsdk.annotations.Sprite;
import com.mapbox.mapboxsdk.annotations.SpriteFactory;
import com.mapbox.mapboxsdk.constants.MyLocationTracking;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

public class MapBoxActivity extends AppCompatActivity
implements OnClickListener{

    private MapView mapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_box);
        View v1 = findViewById(R.id.pausebutton);
        v1.setOnClickListener(this);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setStyleUrl("mapbox://styles/wjhowell/cihl9cng7000lsikx220kkr8p");
        mapView.setCenterCoordinate(new LatLng(42.277112, -83.738152));//center of diag
        mapView.setZoomLevel(14);
        mapView.setRotateEnabled(false);

        mapView.setMyLocationEnabled(true);
        //mapView.removeAnnotation();
        //mapView.setMyLocationTrackingMode(MyLocationTracking.TRACKING_FOLLOW); do this for "static" map mode


        SpriteFactory spriteFactory = new SpriteFactory(mapView);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.dot);
        Sprite icon = spriteFactory.fromDrawable(drawable);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.pacani);
        Sprite pac = spriteFactory.fromDrawable(drawable2);


        mapView.addMarker(new MarkerOptions()
                .icon(pac)
                .position(new LatLng(mapView.getMyLocation())));//pacman
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.277835, -83.740781)));//state & william
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.278579, -83.740785)));//state & north u
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.278597, -83.739687)));//north u E of state
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.278601, -83.737096)));//north u & fletcher
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.277481, -83.734566)));//geddes & church
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.276349, -83.734645)));//church @ dennison
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.275006, -83.734607)));//church & south u
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.275365, -83.737015)));//ugli
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.274939, -83.738249)));//south u & tappan
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.274903, -83.740690)));//south u & state
        mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.276315, -83.740733)));//state & LSA bldg
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

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pausebutton){
            Intent intent = new Intent(this,pause_activity.class);
            this.startActivity(intent);
        }
    }
}
