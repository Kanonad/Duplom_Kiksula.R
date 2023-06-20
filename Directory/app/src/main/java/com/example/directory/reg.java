package com.example.directory;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity {
    private EditText edName, edPname, edEmail;
    private DatabaseReference mDataBase;
    private String USER_REY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        init();
    }

    private void init()
    {
        edName = findViewById(R.id.edName);
        edPname = findViewById(R.id.edPname);
        edEmail = findViewById(R.id.edEmail);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_REY);
    }
    public void onClickSave (View view)
    {
        String id = mDataBase.getKey();
        String name = edName.getText().toString();
        String pname = edPname.getText().toString();
        String email = edEmail.getText().toString();
        User newUser = new User(id,name,pname,email);
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pname) && !TextUtils.isEmpty(email))
        {
            mDataBase.push().setValue(newUser);
        }
        else
        {
            Toast.makeText(this, "Порожнє поле", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickread (View view)
    {

    }
}