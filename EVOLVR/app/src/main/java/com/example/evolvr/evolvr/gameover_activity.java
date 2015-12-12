package com.example.evolvr.evolvr;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class gameover_activity extends AppCompatActivity
        implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        Button v1 = (Button) findViewById(R.id.backbutton);
        v1.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        v1.setTypeface(font);
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTypeface(font);
        TextView gameOverTxt = (TextView) findViewById(R.id.textView4);
        gameOverTxt.setTypeface(font);
        TextView youWin = (TextView) findViewById(R.id.textView5);
        youWin.setTypeface(font);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        TextView scoreTxt = (TextView) findViewById(R.id.textView6);
        int score = b.getInt("Score");
        scoreTxt.setText(Integer.toString(score));
        scoreTxt.setTypeface(font);
    }

    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.backbutton){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }

    }
}
