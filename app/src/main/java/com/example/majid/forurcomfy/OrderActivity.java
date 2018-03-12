package com.example.majid.forurcomfy;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
>>>>>>> 147df0793427cf7f51408240368b3e46ee72e134

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_order);
=======
        setContentView(R.layout.activity__order);
        final Button bRestaurant = (Button) findViewById(R.id.bRestaurant);

        bRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OrderIntent = new Intent(OrderActivity.
                        this,VeggiMenuActivty.class);
                OrderActivity.this.startActivity(OrderIntent);
             }
        });
>>>>>>> 147df0793427cf7f51408240368b3e46ee72e134
    }
}
