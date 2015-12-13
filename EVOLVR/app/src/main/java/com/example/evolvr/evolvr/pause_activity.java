package com.example.evolvr.evolvr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class pause_activity extends AppCompatActivity
implements View.OnClickListener {
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
        RadioButton easy = (RadioButton) findViewById(R.id.radioButton6);
        easy.setTypeface(font);
        RadioButton medium = (RadioButton) findViewById(R.id.radioButton7);
        medium.setTypeface(font);
        RadioButton hard = (RadioButton) findViewById(R.id.radioButton8);
        hard.setTypeface(font);

        TextView mode = (TextView) findViewById(R.id.textView7);
        mode.setTypeface(font);
        RadioButton staticMode = (RadioButton) findViewById(R.id.radioButton9);
        staticMode.setTypeface(font);
        RadioButton dynamicMode = (RadioButton) findViewById(R.id.radioButton10);
        dynamicMode.setTypeface(font);

        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        int difficulty = pref.getInt("Difficulty", 1);
        if (difficulty == 1){
            easy.toggle();
        }
        else if (difficulty == 2){
            medium.toggle();
        }
        else if(difficulty == 3){
            hard.toggle();
        }

        int mapMode = pref.getInt("Mode", 1);
        if (mapMode == 1){
            staticMode.toggle();
        }
        else if (mapMode == 2){
            dynamicMode.toggle();
        }
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

    public void setDifficulty(View button){
        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if(button.getId() == R.id.radioButton6){
            //Easy difficulty
            edit.putInt("Difficulty", 1);
        }
        else if(button.getId() == R.id.radioButton7){
            //Medium difficulty
            edit.putInt("Difficulty", 2);
        }
        else if(button.getId() == R.id.radioButton8){
            //Hard difficulty
            edit.putInt("Difficulty", 3);
        }
        edit.apply();
    }

    public void setMode(View button){
        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if(button.getId() == R.id.radioButton9){
            //Static mode
            edit.putInt("Mode", 1);
        }
        else if(button.getId() == R.id.radioButton10){
            //Dynamic mode
            edit.putInt("Mode", 2);
        }
        edit.apply();
    }
}
