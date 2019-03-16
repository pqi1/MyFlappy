package com.example.myflappylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText myTextUsername;
    EditText myTextPassword;
    Button myLoginButton;
    TextView myTextViewRegister;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
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

        myLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = myTextUsername.getText().toString().trim();
                String pwd = myTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res == true){
                    Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
