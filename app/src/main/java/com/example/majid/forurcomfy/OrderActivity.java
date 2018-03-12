package com.example.majid.forurcomfy;

<<<<<<< HEAD
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
=======
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
>>>>>>> e9d77cd4715d01eb643f048945c34146b34c27a0

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_order);
<<<<<<< HEAD
=======
=======
        setContentView(R.layout.activity__order);
>>>>>>> e9d77cd4715d01eb643f048945c34146b34c27a0
        final Button bRestaurant = (Button) findViewById(R.id.bRestaurant);

        bRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OrderIntent = new Intent(OrderActivity.
<<<<<<< HEAD
                        this,VeggiMenuActivity.class);
                OrderActivity.this.startActivity(OrderIntent);
            }
        });
=======
                        this,VeggiMenuActivty.class);
                OrderActivity.this.startActivity(OrderIntent);
             }
        });
>>>>>>> 147df0793427cf7f51408240368b3e46ee72e134
>>>>>>> e9d77cd4715d01eb643f048945c34146b34c27a0
    }
}