package com.example.myflappylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText myTextUsername;
    EditText myTextPassword;
    EditText myTextCnfPassword;
    Button myButtonRegister;
    TextView myTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
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

        myButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = myTextUsername.getText().toString().trim();
                String pwd = myTextPassword.getText().toString().trim();
                String cnf_pwd = myTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this, "registered successed", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    
                }else{
                    Toast.makeText(RegisterActivity.this, "pasword isn't match", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
