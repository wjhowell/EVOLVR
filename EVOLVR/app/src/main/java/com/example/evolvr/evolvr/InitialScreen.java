package com.example.evolvr.evolvr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InitialScreen extends AppCompatActivity
implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        View v1 = findViewById(R.id.playbutton);
        v1.setOnClickListener(this);
        View v2 = findViewById(R.id.highscoresbutton);
        v2.setOnClickListener(this);
        View v3 = findViewById(R.id.settingsbutton);
        v3.setOnClickListener(this);
        View v4 = findViewById(R.id.quitbutton);
        v4.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTypeface(font);
    }

    //override the OnClickListener interface method
    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.playbutton){
            Intent intent = new Intent(this,MapBoxActivity.class);
            this.startActivity(intent);
        }
        if(arg0.getId() == R.id.highscoresbutton){
            Intent intent = new Intent(this,highscores_activity.class);
            this.startActivity(intent);
        }
        if(arg0.getId() == R.id.settingsbutton){
            Intent intent = new Intent(this,settings_activity.class);
            this.startActivity(intent);
        }
        if(arg0.getId() == R.id.quitbutton){
            finish();
            moveTaskToBack(true);
            //System.exit(0);
        }
    }
}

