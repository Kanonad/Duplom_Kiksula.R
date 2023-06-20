package com.example.directory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pereg2Activity extends AppCompatActivity {
    private EditText edCom;
    private DatabaseReference mDataBaseCom;
    private String USER_REY2 = "Coment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pereg2);
        init();
    }
    private void init()
    {
        edCom = findViewById(R.id.edCom);
        mDataBaseCom = FirebaseDatabase.getInstance().getReference(USER_REY2);
    }
    public void onClickSaveCom (View view)
    {
        String id = mDataBaseCom.getKey();
        String coment = edCom.getText().toString();
        Coment newComent = new Coment(id,coment);
        if (!TextUtils.isEmpty(coment))
        {
            mDataBaseCom.push().setValue(newComent);
        }
        else
        {
            Toast.makeText(this, "Порожнє поле", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickVcom(View view){
        Intent i = new Intent(Pereg2Activity.this,ReadActi.class);
        startActivity(i);

    }
    public void startNewActivite(View v){
        Intent intent = new Intent(this,PhilmActivity.class);
        startActivity(intent);

    }
    public void goBacK(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}