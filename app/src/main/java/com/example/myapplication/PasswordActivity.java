package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordActivity extends AppCompatActivity {
    @BindView(R.id.continue_btn)
    Button continueButton;

    @BindView(R.id.password)
    EditText password;
    String name="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        ButterKnife.bind(this);
        Intent intent =getIntent();
        if(intent.getStringExtra("name")!=null)
            name=intent.getStringExtra("name");
        Log.d("Nombre ", name);

        continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(password.getText().toString().equals("1234")){
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                finish();
            }


            }
        });

    }
}
