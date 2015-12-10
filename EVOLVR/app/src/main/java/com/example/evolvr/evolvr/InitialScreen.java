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
        Button v1 = (Button) findViewById(R.id.playbutton);
        v1.setOnClickListener(this);
        Button v2 = (Button) findViewById(R.id.highscoresbutton);
        v2.setOnClickListener(this);
        Button v3 = (Button) findViewById(R.id.settingsbutton);
        v3.setOnClickListener(this);
        Button v4 = (Button) findViewById(R.id.quitbutton);
        v4.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        TextView txt = (TextView) findViewById(R.id.textView3);
        TextView txt2 = (TextView) findViewById(R.id.textView4);
        txt.setTypeface(font);
        txt2.setTypeface(font);
        v1.setTypeface(font);
        v2.setTypeface(font);
        v3.setTypeface(font);
        v4.setTypeface(font);
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

