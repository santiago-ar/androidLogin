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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView textViewLogin;
    private Button buttonLogin;
    private TextView messageError;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        context = this;
        Spinner spinner = (Spinner) findViewById(R.id.document_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.document_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        textViewLogin = findViewById(R.id.document_text);
        buttonLogin = findViewById(R.id.continue_btn);
        messageError = findViewById(R.id.message_error);
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
                    startActivity(new Intent(getApplicationContext(), PasswordActivity.class));
                }

            }
        });


    }

}