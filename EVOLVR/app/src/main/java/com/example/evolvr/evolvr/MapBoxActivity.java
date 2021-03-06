package com.example.evolvr.evolvr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;


import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import android.support.v4.content.ContextCompat;
import android.widget.Button;

import com.mapbox.mapboxsdk.annotations.Sprite;
import com.mapbox.mapboxsdk.annotations.SpriteFactory;
import com.mapbox.mapboxsdk.constants.MyLocationTracking;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

import java.util.List;
import java.util.Vector;

public class MapBoxActivity extends AppCompatActivity
        implements OnClickListener, MapView.OnMyLocationChangeListener{

    private MapView mapView = null;
    private String scorestring;
    private Button scorebutton;
    private int score;
    private int dotScore = 10; //How much a dot is worth
    private int lives;
    private int epsilon = 5; //How close in meters the player needs to be to eat a dot
    private List<com.mapbox.mapboxsdk.annotations.Marker> dots = new Vector<com.mapbox.mapboxsdk.annotations.Marker>();
    private Marker pacman;
    private Sprite pacIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_box);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        Button v1 = (Button) findViewById(R.id.pausebutton);
        v1.setOnClickListener(this);
        v1.setTypeface(font);

        score = 0;
        Intent in = getIntent();
        Bundle b = in.getExtras();

        if(b != null) {
            score = b.getInt("Score", 0);
        }
        lives = 3;
        scorestring = "Score: " + String.valueOf(score) + "       Lives: " + String.valueOf(lives);
        scorebutton = (Button)findViewById(R.id.score);
        scorebutton.setText(scorestring);
        scorebutton.setTypeface(font);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setStyleUrl("mapbox://styles/wjhowell/cihl9cng7000lsikx220kkr8p");
        mapView.setZoomLevel(14);
        mapView.setRotateEnabled(false);

        mapView.setMyLocationEnabled(true);
        mapView.setCenterCoordinate(new LatLng(mapView.getMyLocation()));

        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        if(pref.getInt("Mode", 1) == 1) {
            mapView.setMyLocationTrackingMode(MyLocationTracking.TRACKING_FOLLOW);
        }
        if(pref.getInt("Mode", 1) == 2) {
            mapView.setMyLocationTrackingMode(MyLocationTracking.TRACKING_NONE);
        }

        SpriteFactory spriteFactory = new SpriteFactory(mapView);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.dot);
        Sprite icon = spriteFactory.fromDrawable(drawable);
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.pacani);
        pacIcon = spriteFactory.fromDrawable(drawable2);


        pacman = mapView.addMarker(new MarkerOptions()
                .icon(pacIcon)
                .position(new LatLng(mapView.getMyLocation())));//pacman


//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.292573, -83.716330))));//BBB
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.277835, -83.740781))));//state & william
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.278579, -83.740785))));//state & north u
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.278597, -83.739687))));//north u E of state
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.278601, -83.737096))));//north u & fletcher
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.277481, -83.734566))));//geddes & church
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.276349, -83.734645))));//church @ dennison
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.275006, -83.734607))));//church & south u
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.275365, -83.737015))));//ugli
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.274939, -83.738249))));//south u & tappan
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.274903, -83.740690))));//south u & state
//        dots.add(mapView.addMarker(new MarkerOptions()
//                .icon(icon)
//                .position(new LatLng(42.276315, -83.740733))));//state & LSA bldg

        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.291609, -83.714962))));//north diag 1 (lowright)
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.291609, -83.715418))));//north diag 2
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.291621, -83.715879))));//north diag 3
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.291601, -83.716335))));//north diag 4
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.291609, -83.716716))));//north diag 5(lowleft)
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292093, -83.716705))));//north diag 6
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292371, -83.716700))));//north diag 7
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292566, -83.716695))));//north diag 8(topleft)
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292573, -83.716249))));//north diag 9
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292585, -83.715793))));//north diag 10
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292443, -83.714935))));//north diag 11(topright)
        dots.add(mapView.addMarker(new MarkerOptions()
                .icon(icon)
                .position(new LatLng(42.292077, -83.714935))));//north diag 12

        if(pref.getInt("Difficulty", 1) == 2 || pref.getInt("Difficulty", 1) == 3) {//if medium or hard
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292649, -83.717113))));//north path 1
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292708, -83.717671))));//north path 2
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292752, -83.718122))));//north path 3
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292966, -83.718771))));//north path 4 (murfin)
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292681, -83.718712))));//murfin 5
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292395, -83.718669))));//murfin 6
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292165, -83.718610))));//murfin 7
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.291927, -83.718562))));//murfin 8
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.291625, -83.718513))));//murfin 9
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.291181, -83.718444))));//murfin 10
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290768, -83.718444))));//murfin 11
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290490, -83.718417))));//pierpont bus stop
        }

        if(pref.getInt("Difficulty", 1) == 3) {//if hard
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290427, -83.717558))));//bonisteel 1
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290415, -83.716255))));//bonisteel 2
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290415, -83.715032))));//bonisteel 3
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.290411, -83.713068))));//bonisteel 4
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.292181, -83.712736))));//beal 5
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.293581, -83.712634))));//beal 6
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.293931, -83.714624))));//hayward 7
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.293931, -83.718916))));//hayward 8
            dots.add(mapView.addMarker(new MarkerOptions()
                    .icon(icon)
                    .position(new LatLng(42.293415, -83.718824))));//murfin 9
        }

            mapView.setOnMyLocationChangeListener(this);
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
            Bundle scores = new Bundle(1);
            scores.putInt("Score", score);
            intent.putExtras(scores);
            this.startActivity(intent);
        }
    }

    @Override
    public void onMyLocationChange(Location location) {
        LatLng pacmanLoc = new LatLng(mapView.getMyLocation());
        //Delete the old pacman icon and make a new one
        mapView.removeAnnotation(pacman);
        pacman = mapView.addMarker(new MarkerOptions()
                .icon(pacIcon)
                .position(pacmanLoc));

        //Start at the end of the list and iterate to the beginning
        //Prevents skipping dots if one is removed
        for(int i = dots.size() - 1; i >= 0; i--) {
            if (pacmanLoc.distanceTo(dots.get(i).getPosition()) < epsilon) {
                //Eat the dot
                //Increment score by dotScore
                score += dotScore;
                //Update score string
                scorestring = "Score: " + String.valueOf(score) + "       Lives: " + String.valueOf(lives);
                scorebutton = (Button)findViewById(R.id.score);
                scorebutton.setText(scorestring);
                //remove dot from the list AND the map
                mapView.removeAnnotation(dots.remove(i));
            }
        }
        if(dots.size() == 0){
            //Last dot eaten
            Intent gameover = new Intent(this, gameover_activity.class);
            Bundle scores = new Bundle(1);
            scores.putInt("Score", score);
            gameover.putExtras(scores);
            this.startActivity(gameover);
        }
    }
}
