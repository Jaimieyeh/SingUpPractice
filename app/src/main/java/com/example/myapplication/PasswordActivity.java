package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }

    public void next2 (View view){
        edPassword = findViewById(R.id.password);
        String testPassword = edPassword.getText().toString();

        if (!TextUtils.isEmpty(edPassword.getText().toString())){
            Intent email = new Intent(this, EmailActivity.class);
            SharedPreferences preferences = getSharedPreferences("test", MODE_PRIVATE);
            preferences.edit().putString("password", edPassword.getText().toString()).commit();
            startActivityForResult(email, 100);
            setResult(RESULT_OK, email);
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
