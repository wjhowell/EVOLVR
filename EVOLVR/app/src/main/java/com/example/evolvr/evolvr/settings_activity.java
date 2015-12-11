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


public class settings_activity extends AppCompatActivity
implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Button v1 = (Button) findViewById(R.id.backbutton);
        v1.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/retro.ttf");
        v1.setTypeface(font);
        TextView txt = (TextView) findViewById(R.id.textView3);
        txt.setTypeface(font);
        TextView txt2 = (TextView) findViewById(R.id.textView4);
        txt2.setTypeface(font);

        TextView diff = (TextView) findViewById(R.id.textView);
        diff.setTypeface(font);
        TextView easy = (TextView) findViewById(R.id.radioButton);
        easy.setTypeface(font);
        TextView medium = (TextView) findViewById(R.id.radioButton2);
        medium.setTypeface(font);
        TextView hard = (TextView) findViewById(R.id.radioButton3);
        hard.setTypeface(font);

        TextView mode = (TextView) findViewById(R.id.textView2);
        mode.setTypeface(font);
        TextView staticMode = (TextView) findViewById(R.id.radioButton4);
        staticMode.setTypeface(font);
        TextView dynamicMode = (TextView) findViewById(R.id.radioButton5);
        dynamicMode.setTypeface(font);

        TextView username = (TextView) findViewById(R.id.textView5);
        username.setTypeface(font);
        TextView input = (TextView) findViewById(R.id.editText);
        input.setTypeface(font);
    }
    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.backbutton){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }

    }
}
