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

import java.util.ArrayList;

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

        final ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0 ;i<10;i++){
            arrayList.add(""+i+1);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listDashboard.setAdapter(arrayAdapter);
        listDashboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Toast.makeText(DashboardActivity.this,"Pulsaste:"+arrayList.get(i),Toast.LENGTH_SHORT).show();
             }

        }
        );


    }

    @Override
    public void onBackPressed() {
        Log.d("no", "no haga nada");
    }
}
