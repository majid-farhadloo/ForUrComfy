package com.example.majid.forurcomfy.ShoppingCart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.majid.forurcomfy.Common.Current;
import com.example.majid.forurcomfy.PaymentActivity;
import com.example.majid.forurcomfy.R;
import com.example.majid.forurcomfy.Utlis.ShoppingDatabaseHelper;
import com.example.majid.forurcomfy.model.Request;
import com.google.firebase.database.DataSnapshot;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartWindow extends AppCompatActivity {

    private final String TAG = ShoppingCartWindow.class.getSimpleName();
    private TextView priceView;
    private ListView shoppingCartListView;
    private ShoppingDatabaseHelper shoppingDatabaseHelper;
    private static ArrayList<Shopping> shoppingCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_window);

        priceView = (TextView) findViewById(R.id.totalPriceCheckout);
        shoppingCartListView = (ListView) findViewById(R.id.shoppingCartList);

        shoppingDatabaseHelper = new ShoppingDatabaseHelper(this);
        shoppingCartList = shoppingDatabaseHelper.getAllDatas();

        if (shoppingCartList.size() > 0) {
            shoppingCartListView.setAdapter(new ShoppingListAdapter(shoppingCartList, getApplicationContext()));
        }

        float totalAmount = 0;

        for (Shopping shopping : shoppingCartList) {
            totalAmount = totalAmount + Float.parseFloat(shopping.getTotalprice().substring(4));
        }

        priceView.setText("Rs. " + String.valueOf(totalAmount));

        (findViewById(R.id.returnToPrevPage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        (findViewById(R.id.checkOut)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create new Request
                showAlertDialog();

            }
        });

        (findViewById(R.id.clearCart)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoppingDatabaseHelper.deleteAll(Current.currentUser.getEmail().split("@")[0] + "ShoppingCartTable");
                Snackbar.make(findViewById(R.id.shoppingCartWindowLayout),
                        "Cleared!",
                        Snackbar.LENGTH_SHORT).show();
                //clearCart();
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (shoppingCartList.size() > 0) {
            shoppingCartList.clear();
        }
    }

    private void showAlertDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShoppingCartWindow.this);
        alertDialog.setTitle("For last Step");
        alertDialog.setMessage("Please Enter Your address");

        final EditText edtAddress = new EditText(ShoppingCartWindow.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
        );
        edtAddress.setLayoutParams(lp);
        alertDialog.setView(edtAddress);
        alertDialog.setIcon(R.drawable.ic_shopping_cart_black_24dp);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //Creat new Request
                Request req = new Request(Current.currentUser.getCell(),
                        Current.currentUser.getfirstname(),
                        Current.currentUser.getlastname(), edtAddress.getText().toString(),
                        priceView.getText().toString(),shoppingCartList);
                // sending them to server

                //Go to payment Activity
                startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
            }
        });

        alertDialog.show();

    }

}
