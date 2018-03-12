package com.example.majid.forurcomfy;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.majid.forurcomfy.Sample.SampleDataProvider;
import com.example.majid.forurcomfy.Data.model.DataItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
>>>>>>> e9d77cd4715d01eb643f048945c34146b34c27a0

public class UserAreaActivity extends AppCompatActivity {

    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
<<<<<<< HEAD

        Collections.sort(dataItemList, new Comparator<DataItem>() {
            @Override
            public int compare(DataItem o1, DataItem o2) {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });

        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }
}
=======
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



>>>>>>> e9d77cd4715d01eb643f048945c34146b34c27a0
