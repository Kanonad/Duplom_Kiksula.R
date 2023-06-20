package com.example.directory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Перехід на сторінку фільми
    public void startNewActivite(View v){
        Intent intent = new Intent(this,PhilmActivity.class);
        startActivity(intent);

    }
    //Перехід на регістрацію
    public void startNewActiviteReg(View v){
        Intent intent = new Intent(this,Log.class);
        startActivity(intent);

    }








    /*
    @Override//Старт
    protected void onStart() {
        super.onStart();
    }

    @Override//Відновити процес
    protected void onResume() {
        super.onResume();
    }

    @Override//Пауза
    protected void onPause() {
        super.onPause();
    }

    @Override//Вийшов не надовно
    protected void onStop() {
        super.onStop();
    }
    */
}