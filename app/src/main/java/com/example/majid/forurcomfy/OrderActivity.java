package com.example.majid.forurcomfy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final Button bRestaurant = (Button) findViewById(R.id.bRestaurant);

        bRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OrderIntent = new Intent(OrderActivity.
                        this,VeggiMenuActivity.class);
                OrderActivity.this.startActivity(OrderIntent);
            }
        });
    }
}