package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     RecyclerView recyclerView;
     ArrayList<String> arrayList = new ArrayList<>();
     MusicListView musicListView;
     ItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        for (int i=0; i<15; i++) {
            arrayList.add("Songs " + i);
        }

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(int position, String value, View v) {
                Intent intent = new Intent(v.getContext(), MusicPlayer.class);
                intent.putExtra("title", value);
                v.getContext().startActivity(intent);
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        musicListView = new MusicListView(arrayList,itemClickListener);
        recyclerView.setAdapter(musicListView);

    }
}