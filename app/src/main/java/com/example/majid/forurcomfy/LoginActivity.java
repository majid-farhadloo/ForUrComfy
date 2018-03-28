package com.example.majid.forurcomfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.majid.forurcomfy.Remote.ApiUtlis;
import com.example.majid.forurcomfy.Remote.UserService;
import com.example.majid.forurcomfy.model.ResObj;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        userService = ApiUtlis.getUserService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email = (EditText) findViewById(R.id.EmailLogIn);
        final EditText password = (EditText) findViewById(R.id.PasswordLogIn);
        final Button Login = (Button) findViewById(R.id.LogIn);
        final Button forgotPassword = (Button) findViewById(R.id.ForgotPass);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                // validate form
                if (validateLogin(mail, pass)) {
                    //do login()
                    doLogin(mail, pass);

                }

            }

        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotPassIntent = new Intent(LoginActivity.
                        this, ForgotPassActivity.class);
                LoginActivity.this.startActivity(forgotPassIntent);
            }
        });


    }

    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Your Email address is required"
                    , Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required"
                    , Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String username, final String password) {
        Call<ResObj> call = userService.login(username, password);
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                if (response.isSuccessful()) {
                    ResObj resObj = response.body();
                    if (resObj.getMessage().equals("true")) {
                        Intent LoginIntent = new Intent(LoginActivity.
                                this, UserAreaActivity.class);
                        LoginIntent.putExtra("email", username);
                        LoginActivity.this.startActivity(LoginIntent);

                    } else {
                        Toast.makeText(LoginActivity.this,
                                "The username or password is incorrect",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Error! Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}



