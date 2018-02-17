package com.example.majid.forurcomfy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText fName = (EditText) findViewById(R.id.FirstName);
        final EditText lName = (EditText) findViewById(R.id.LastName);
        final EditText phoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        final EditText Email = (EditText) findViewById(R.id.Email);
        final EditText pass = (EditText) findViewById(R.id.Password);
        final EditText reTypePass = (EditText) findViewById(R.id.MatchPassword);
        final Button register = (Button) findViewById(R.id.RegisterBtn);

//        Pattern EmailAddress = Pattern.compile("@mail.fresnostate.edu");
//        Matcher EmailAddress2 = EmailAddress.matcher("@mail.fresnostate.edu");
//        boolean match = EmailAddress2.matches();
    }
}
