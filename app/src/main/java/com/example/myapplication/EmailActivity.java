package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private EditText edEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void next3 (View view){
        edEmail = findViewById(R.id.email);
        String testEmail = edEmail.getText().toString();

        if (!TextUtils.isEmpty(edEmail.getText().toString())){
            Intent result = new Intent(this, MainActivity.class);
            SharedPreferences preferences = getSharedPreferences("test", MODE_PRIVATE);
            preferences.edit().putString("email", edEmail.getText().toString()).commit();
            //startActivityForResult(result, 100);
            setResult(RESULT_OK, result);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Wrong")
                    .setMessage("must type")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
