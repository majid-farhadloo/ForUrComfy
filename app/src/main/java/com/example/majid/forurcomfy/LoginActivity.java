package com.example.majid.forurcomfy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email = (EditText) findViewById(R.id.EmailLogIn);
        final EditText password = (EditText) findViewById(R.id.PasswordLogIn);
        final Button Login = (Button) findViewById(R.id.LogIn);
        final Button forgotPassword = (Button) findViewById(R.id.ForgotPass);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPassIntent = new Intent(LoginActivity.
                        this,ForgotPassActivity.class);
                LoginActivity.this.startActivity(forgotPassIntent);
            }
        });
    }
}
