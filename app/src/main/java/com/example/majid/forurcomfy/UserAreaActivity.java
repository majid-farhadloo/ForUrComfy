package com.example.majid.forurcomfy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText Welcome = (EditText)findViewById(R.id.hello);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
    }
}
