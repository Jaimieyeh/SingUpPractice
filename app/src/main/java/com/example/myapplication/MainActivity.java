package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN = 100;

    private EditText username;
    private EditText password;
    private EditText email;
    private String resultUsername;
    private String resultPassword;
    private String resultEmail;

    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        email = findViewById(R.id.em);

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.switch1);
                text.setText(isNext ? "sign up" : "log in");
                TextView text2 = findViewById(R.id.title);
                text2.setText(isNext ? "sign up" : "log in");
            }
        });

    }
    public void login (View view){
        if(!isNext){
           if ("111".equals(username) && "111".equals(password) && "111".equals(email)){
               setResult(RESULT_OK);
               finish();
           }

        }else{
            Intent username = new Intent(this, UsernameActivity.class);
            startActivityForResult(username, REQUEST_CODE_LOGIN);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        resultUsername = username.getText().toString();
        resultPassword = password.getText().toString();
        resultEmail = email.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN){
            if (resultCode != RESULT_OK){
                finish();
            } else {
                username.setText(getSharedPreferences("test", MODE_PRIVATE).getString("user", ""));
                password.setText(getSharedPreferences("test", MODE_PRIVATE).getString("password", ""));
                email.setText(getSharedPreferences("test", MODE_PRIVATE).getString("email", ""));

            }
        }
    }
}
