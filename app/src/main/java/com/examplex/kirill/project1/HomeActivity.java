package com.examplex.kirill.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    private ListView list;
    private String[] temp = {"Zero Cool",
            "Cereal Killer",
            "Lord Nikon",
            "Phantom Phreak",
            "Razor",
            "Blade",
            "UltraLazor",
            "Dr. Doom",
            "Crash Override"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

    }

    private void init() {
        list = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, temp);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this, ItemActivity.class);
                intent.putExtra("nickname", temp[i]);
                startActivity(intent);
            }
        });

    }
}
