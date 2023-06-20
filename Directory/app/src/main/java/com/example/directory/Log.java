package com.example.directory;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Log extends AppCompatActivity {
    private EditText edLog,edPass;
    private FirebaseAuth mAuth;
    private Button butStart,butReg,butUp,butExe;
    private TextView twUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_layout);
        init();

    }
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if (cUser !=null)
        {
            showSigned();
            String userName = "Ви зайшли як : " + cUser.getEmail();
            twUser.setText(userName);

            Toast.makeText(this, "Зареганий", Toast.LENGTH_SHORT).show();
        }
        else
        {
            notSignet();
            Toast.makeText(this, "Не зареганий", Toast.LENGTH_SHORT).show();
        }
    }
    private void init()
    {
        butExe = findViewById(R.id.butExe);
        butReg = findViewById(R.id.butReg);
        butUp = findViewById(R.id.butUp);
        twUser = findViewById(R.id.twUser);
        butStart = findViewById(R.id.butStart);
        edLog = findViewById(R.id.edLog);
        edPass = findViewById(R.id.edPass);
        mAuth = FirebaseAuth.getInstance();
    }
    public void onClickLog(View view)
    {
        if (!TextUtils.isEmpty(edLog.getText().toString())&& !TextUtils.isEmpty(edPass.getText().toString()))
        {
            mAuth.createUserWithEmailAndPassword(edLog.getText().toString(),edPass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        showSigned();

                        Toast.makeText(getApplicationContext(), "Успішно", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        notSignet();
                        Toast.makeText(getApplicationContext(), "Провал", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else
        {
            Toast.makeText(getApplicationContext(), "введи пароль і почту", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickPass(View view)
    {
        if (!TextUtils.isEmpty(edLog.getText().toString())&& !TextUtils.isEmpty(edPass.getText().toString())) {
            mAuth.signInWithEmailAndPassword(edLog.getText().toString(),edPass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        showSigned();

                        Toast.makeText(getApplicationContext(), "Успішно", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        notSignet();
                        Toast.makeText(getApplicationContext(), "Провал", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else
        {
            Toast.makeText(getApplicationContext(), "введи пароль і почту", Toast.LENGTH_SHORT).show();
        }

    }
    public void onClickExe(View view){
        FirebaseAuth.getInstance().signOut();
        notSignet();
    }
    private void showSigned()
        {
            FirebaseUser user = mAuth.getCurrentUser();
            assert user !=null;
            if (user.isEmailVerified()){
                String userName = "Ви зайшли як : " + user.getEmail();
                twUser.setText(userName);
            }

            butStart.setVisibility(View.VISIBLE);
            butExe.setVisibility(View.VISIBLE);
            twUser.setVisibility(View.VISIBLE);
            edLog.setVisibility(View.GONE);
            edPass.setVisibility(View.GONE);
            butUp.setVisibility(View.GONE);
            butReg.setVisibility(View.GONE);
        }
        private void notSignet()
        {
            butStart.setVisibility(View.GONE);
            butExe.setVisibility(View.GONE);
            twUser.setVisibility(View.GONE);
            edLog.setVisibility(View.VISIBLE);
            edPass.setVisibility(View.VISIBLE);
            butUp.setVisibility(View.VISIBLE);
            butReg.setVisibility(View.VISIBLE);
        }
        public void onClickBstart(View view){
            Intent i = new Intent(Log.this,MainActivity.class);
            startActivity(i);
        }
}
