package com.example.myflappylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText myTextUsername;
    EditText myTextPassword;
    EditText myTextCnfPassword;
    Button myButtonRegister;
    TextView myTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myTextUsername = (EditText)findViewById(R.id.username);
        myTextPassword = (EditText)findViewById(R.id.passowrd);
        myTextCnfPassword = (EditText)findViewById(R.id.cnf_passowrd);
        myButtonRegister = (Button) findViewById(R.id.registerButton);
        myTextViewLogin = (TextView) findViewById(R.id.textview_login);

        myTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });

    }
}
