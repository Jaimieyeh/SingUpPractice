package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class UsernameActivity extends AppCompatActivity {

    private EditText edUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
    }

    public void next1 (View view){
        edUsername = findViewById(R.id.username);
        String testUsername = edUsername.getText().toString();

        if (!TextUtils.isEmpty(edUsername.getText().toString())){
            Intent password = new Intent(this, PasswordActivity.class);
            SharedPreferences preferences = getSharedPreferences("test", MODE_PRIVATE);
            preferences.edit().putString("user", edUsername.getText().toString()).commit();
            startActivityForResult(password, 100);
            setResult(RESULT_OK, password);
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
