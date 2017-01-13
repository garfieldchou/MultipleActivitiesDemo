package com.garfieldchou.multipleactivitiesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView friendsName = (ListView)findViewById(R.id.friendsName);

        final ArrayList<String> listFriends = new ArrayList<String>(asList("CH", "Kevin", "Vic", "Dino"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listFriends);

        friendsName.setAdapter(arrayAdapter);

        friendsName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Info", listFriends.get(i));

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("friend", listFriends.get(i));

                startActivity(intent);
            }
        });
    }
}
