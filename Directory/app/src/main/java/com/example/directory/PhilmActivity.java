package com.example.directory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PhilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philm);
    }
    //Перехід на сторінку головну
    public void goBacK(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void PeregActivity(View v){
        Intent intent = new Intent(this,PeregActivity.class);
        startActivity(intent);

    }
    public void Pereg2Activity(View v){
        Intent intent = new Intent(this,Pereg2Activity.class);
        startActivity(intent);

    }
    public void Pereg3Activity(View v){
        Intent intent = new Intent(this,Pereg3Activity.class);
        startActivity(intent);

    }
    public void Pereg4Activity(View v){
        Intent intent = new Intent(this,Pereg4Activity.class);
        startActivity(intent);

    }
    public void Pereg5Activity(View v){
        Intent intent = new Intent(this,Pereg5Activity.class);
        startActivity(intent);

    }

}