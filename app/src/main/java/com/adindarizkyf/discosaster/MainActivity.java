package com.adindarizkyf.discosaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private String[] dataName = {"Gempa Bumi","Banjir","Tsunami", "Tanah Longsor","Letusan Gunung Berapi" };
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private DisAdapter adapter;
    private ArrayList<Disaster> disasters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new DisAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataName);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //Toast.makeText(MainActivity.this, disasters.get(i).getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addItem() {
        disasters = new ArrayList<>();
        for (int i = 0; i< dataName.length;i++) {
            Disaster disaster = new Disaster();
            disaster.setPhoto(dataPhoto.getResourceId(i,-1));
            disaster.setName(dataName[i]);
            disaster.setDescription(dataDescription[i]);
            disasters.add(disaster);
        }
        adapter.setDisaster(disasters);
    }

    private void prepare () {
        dataName = getResources().getStringArray(R.array.dis_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

}
