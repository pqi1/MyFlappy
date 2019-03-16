package com.example.myflappylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText myTextUsername;
    EditText myTextPassword;
    Button myLoginButton;
    TextView myTextViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextUsername = (EditText)findViewById(R.id.username);
        myTextPassword = (EditText)findViewById(R.id.passowrd);
        myLoginButton = (Button) findViewById(R.id.loginButton);
        myTextViewRegister = (TextView) findViewById(R.id.textview_register);

        myTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });



    }
}