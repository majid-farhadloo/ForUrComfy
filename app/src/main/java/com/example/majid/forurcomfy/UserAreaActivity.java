package com.example.majid.forurcomfy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        final EditText Welcome = (EditText)findViewById(R.id.hello);
        final Button bOrder = (Button) findViewById(R.id.bOrder);
        final Button bDeliveree = (Button) findViewById(R.id.bDeliveree);

        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OrderIntent = new Intent(UserAreaActivity.
                        this,OrderActivity.class);
                UserAreaActivity.this.startActivity(OrderIntent);


            }
        });


        }
        };



