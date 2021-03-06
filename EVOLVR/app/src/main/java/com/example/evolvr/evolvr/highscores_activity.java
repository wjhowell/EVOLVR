package com.example.evolvr.evolvr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class highscores_activity extends AppCompatActivity
implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores);
        Button v1 = (Button) findViewById(R.id.backbutton);
        v1.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        v1.setTypeface(font);
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTypeface(font);
        TextView txt2 = (TextView) findViewById(R.id.textView4);
        txt2.setTypeface(font);

        TextView pacman = (TextView) findViewById(R.id.pac);
        pacman.setTypeface(font);
        TextView pacmanscore = (TextView) findViewById(R.id.pacscore);
        pacmanscore.setTypeface(font);

        TextView wesley = (TextView) findViewById(R.id.wesley);
        wesley.setTypeface(font);
        TextView wesleyscore = (TextView) findViewById(R.id.wesleyscore);
        wesleyscore.setTypeface(font);

        TextView chris = (TextView) findViewById(R.id.chris);
        chris.setTypeface(font);
        TextView chrisscore = (TextView) findViewById(R.id.chrisscore);
        chrisscore.setTypeface(font);

        TextView andrew = (TextView) findViewById(R.id.andrew);
        andrew.setTypeface(font);
        TextView andrewscore = (TextView) findViewById(R.id.andrewscore);
        andrewscore.setTypeface(font);

        TextView alex = (TextView) findViewById(R.id.alex);
        alex.setTypeface(font);
        TextView alexscore = (TextView) findViewById(R.id.alexscore);
        alexscore.setTypeface(font);
    }

    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.backbutton){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }

    }
}
