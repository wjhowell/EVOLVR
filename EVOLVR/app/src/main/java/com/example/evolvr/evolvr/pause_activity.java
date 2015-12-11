package com.example.evolvr.evolvr;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pause_activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_menu);
        Button v1 = (Button) findViewById(R.id.resumebutton);
        v1.setOnClickListener(this);
        Button v2 = (Button) findViewById(R.id.mainmenu);
        v2.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTypeface(font);
        v1.setTypeface(font);
        v2.setTypeface(font);

        TextView diff = (TextView) findViewById(R.id.textView6);
        diff.setTypeface(font);
        TextView easy = (TextView) findViewById(R.id.radioButton6);
        easy.setTypeface(font);
        TextView medium = (TextView) findViewById(R.id.radioButton7);
        medium.setTypeface(font);
        TextView hard = (TextView) findViewById(R.id.radioButton8);
        hard.setTypeface(font);

        TextView mode = (TextView) findViewById(R.id.textView7);
        mode.setTypeface(font);
        TextView staticMode = (TextView) findViewById(R.id.radioButton9);
        staticMode.setTypeface(font);
        TextView dynamicMode = (TextView) findViewById(R.id.radioButton10);
        dynamicMode.setTypeface(font);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.resumebutton){
            Intent intent = new Intent(this,MapBoxActivity.class);
            this.startActivity(intent);
        }
        if(v.getId() == R.id.mainmenu){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }
    }
}
