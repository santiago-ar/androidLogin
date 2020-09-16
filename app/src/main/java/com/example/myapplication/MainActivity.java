package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.document_text)
    TextView textViewLogin;

    @BindView(R.id.continue_btn)
    Button buttonLogin;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.sp_document_type)
    Spinner spinner;
    // private TextView textViewLogin;
    //textViewLogin = findViewById(R.id.document_text);


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this); //importante
        context = this;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.document_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        name = findViewById(R.id.name);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("click", textViewLogin.getText().toString());
                if (!textViewLogin.getText().toString().equals("123456")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Error!");
                    builder.setMessage("Documento no existe");
                    builder.setPositiveButton("OK", null);
                    builder.create();
                    builder.show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
                    intent.putExtra("name", name.getText());
                 //   startActivity(intent);
                    startActivityForResult(intent,0);
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "iniciar onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "iniciar onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pausa", "iniciar pausa");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("stop", "iniciar stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("destroy", "iniciar destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {Log.d("cierra", "finish");
            finish();}

    }
}