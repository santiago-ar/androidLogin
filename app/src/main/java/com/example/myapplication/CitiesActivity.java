package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CitiesActivity extends AppCompatActivity {
    @BindView(R.id.list_cities)
    ListView listViewCities;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities);
        Intent intent= getIntent();
        ButterKnife.bind(this);

        final String[] arrayDepartments;
        arrayDepartments = intent.getStringArrayExtra("Cities");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayDepartments);
        listViewCities.setAdapter(arrayAdapter);

    }
}
