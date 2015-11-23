package com.example.evolvr.evolvr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;


public class settings_activity extends AppCompatActivity
implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        View v1 = findViewById(R.id.backbutton);
        v1.setOnClickListener(this);
    }
    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.backbutton){
            Intent intent = new Intent(this,InitialScreen.class);
            this.startActivity(intent);
        }

    }
}
