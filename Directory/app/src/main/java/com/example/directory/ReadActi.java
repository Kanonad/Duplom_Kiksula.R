package com.example.directory;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadActi extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;

    private DatabaseReference mDataBaseCom;
    private String USER_REY2 = "Coment";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readlayout);
        init();
        getDataFromBD();

    }
    private void init()
    {
        listView = findViewById(R.id.listView);
        listData = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        mDataBaseCom = FirebaseDatabase.getInstance().getReference(USER_REY2);
    }
    private void getDataFromBD()
    {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dateSnapshot)
            {
                if (listData.size() > 0 ) listData.clear();
                for (DataSnapshot ds : dateSnapshot.getChildren())
                {
                    Coment coment = ds.getValue(Coment.class);
                    assert coment != null;
                    listData.add(coment.coment);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDataBaseCom.addValueEventListener(vListener);
    }
}
