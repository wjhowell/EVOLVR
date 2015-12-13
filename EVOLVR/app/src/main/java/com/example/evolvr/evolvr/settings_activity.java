package com.example.evolvr.evolvr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class settings_activity extends AppCompatActivity
implements OnClickListener, TextView.OnEditorActionListener{
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
        RadioButton easy = (RadioButton) findViewById(R.id.radioButton);
        easy.setTypeface(font);
        RadioButton medium = (RadioButton) findViewById(R.id.radioButton2);
        medium.setTypeface(font);
        RadioButton hard = (RadioButton) findViewById(R.id.radioButton3);
        hard.setTypeface(font);

        TextView mode = (TextView) findViewById(R.id.textView2);
        mode.setTypeface(font);
        RadioButton staticMode = (RadioButton) findViewById(R.id.radioButton4);
        staticMode.setTypeface(font);
        RadioButton dynamicMode = (RadioButton) findViewById(R.id.radioButton5);
        dynamicMode.setTypeface(font);

        TextView username = (TextView) findViewById(R.id.textView5);
        username.setTypeface(font);
        TextView input = (TextView) findViewById(R.id.editText);
        input.setTypeface(font);
        input.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);

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

        String name = pref.getString("Name", "Name...");
        input.setText(name);
        //input.setSelectAllOnFocus(true);
        input.setOnEditorActionListener(this);
    }
    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.backbutton){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }
    }

    public void setDifficulty(View button){
        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if(button.getId() == R.id.radioButton){
            //Easy difficulty
            edit.putInt("Difficulty", 1);
        }
        else if(button.getId() == R.id.radioButton2){
            //Medium difficulty
            edit.putInt("Difficulty", 2);
        }
        else if(button.getId() == R.id.radioButton3){
            //Hard difficulty
            edit.putInt("Difficulty", 3);
        }
        edit.apply();
    }

    public void setMode(View button){
        SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if(button.getId() == R.id.radioButton4){
            //Static mode
            edit.putInt("Mode", 1);
        }
        else if(button.getId() == R.id.radioButton5){
            //Dynamic mode
            edit.putInt("Mode", 2);
        }
        edit.apply();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_DONE) {
            SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            edit.putString("Name", v.getText().toString());
            edit.apply();
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            return true;
        }
        return false;
    }
}
