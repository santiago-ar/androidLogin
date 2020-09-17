package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.tv_nameDashboard)
    TextView dashboardName;

    @BindView(R.id.list_dashboard)
    ListView listDashboard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        dashboardName.setText(intent.getStringExtra("name"));
        final String[] arrayDepartments;
        arrayDepartments = getResources().getStringArray(R.array.departments);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayDepartments);
        listDashboard.setAdapter(arrayAdapter);
        listDashboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
                 public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Intent intent = new Intent(getApplicationContext(), CitiesActivity.class);
                 switch (i) {
                          case 0:
                             intent.putExtra("Cities",arrayDepartments);
                             startActivity(intent);
                              case 2:

                     }
                 }

             }
        );


    }

    @Override
    public void onBackPressed() {
        Log.d("no", "no haga nada");
    }
}
