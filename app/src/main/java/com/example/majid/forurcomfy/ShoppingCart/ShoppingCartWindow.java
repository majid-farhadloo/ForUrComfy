package com.example.majid.forurcomfy.ShoppingCart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
=======
import android.view.View;
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.majid.forurcomfy.CheckoutActivity;
import com.example.majid.forurcomfy.Common.Current;
<<<<<<< HEAD
import com.example.majid.forurcomfy.Data.model.OrderProcess;
import com.example.majid.forurcomfy.Data.model.ShoppingItem;
import com.example.majid.forurcomfy.Data.model.SqliteHelper;
import com.example.majid.forurcomfy.R;
import com.example.majid.forurcomfy.Remote.APIService;
import com.example.majid.forurcomfy.Remote.ApiUtlis;
=======
import com.example.majid.forurcomfy.PaymentActivity;
import com.example.majid.forurcomfy.R;
import com.example.majid.forurcomfy.Utlis.ShoppingDatabaseHelper;
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50
import com.example.majid.forurcomfy.model.Request;
import com.google.firebase.database.DataSnapshot;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
<<<<<<< HEAD

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50

public class ShoppingCartWindow extends AppCompatActivity {

    private final String TAG = ShoppingCartWindow.class.getSimpleName();
<<<<<<< HEAD

    Boolean isCartEmpty = true;
    TextView priceView;
    SqliteHelper dbhelper;
    int totalAmount = 0;
    ArrayList<ShoppingItem> items;
    ListView cartList;
    String msg;

=======
    private TextView priceView;
    private ListView shoppingCartListView;
    private ShoppingDatabaseHelper shoppingDatabaseHelper;
    private static ArrayList<Shopping> shoppingCartList;
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50

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

<<<<<<< HEAD
        // Create the list
//        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
//        listViewCatalog.setAdapter(new ShoppingCartAdapter(items, getLayoutInflater(), false));
//
//        listViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
//                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
//                startActivity(productDetailsIntent);
//            }
//        });


        priceView.setText(Integer.toString(total));
=======
        priceView.setText("Rs. " + String.valueOf(totalAmount));
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50

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

<<<<<<< HEAD
    class MyItem {
        MyItem(int itemName) {
            itemName = itemName;
        }

        int itemName;
=======
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (shoppingCartList.size() > 0) {
            shoppingCartList.clear();
        }
    }

<<<<<<< HEAD
    private void showAlertDialog() {
=======
    private void showAlertDialog(){
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShoppingCartWindow.this);
        alertDialog.setTitle("For last Step");
        alertDialog.setMessage("Please Enter Your address if you would like your food to be " +
                "delivered");

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
<<<<<<< HEAD
                        priceView.getText().toString(), items);
=======
                        priceView.getText().toString(),shoppingCartList);
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50
                // sending them to server


                APIService mAPIService = ApiUtlis.getAPIService();


                mAPIService.request(items, Current.currentUser.getCell(),
                        edtAddress.getText().toString(), Current.currentUser).enqueue(new Callback<OrderProcess>() {
                    @Override
                    public void onResponse(Call<OrderProcess> call, Response<OrderProcess> response) {
                        if (response.isSuccessful()) {
                            Log.d("+++", "Success");
                            msg = response.body().getMessage();
                            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

//                    mRecyclerView.set(mItemAdapter);
                        } else {
                            Log.d("+++", "Fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<OrderProcess> call, Throwable t) {
                        Log.d("+++", "Fail");
                    }
                });
                Intent intent =  new Intent(getApplicationContext(), CheckoutActivity.class);
                intent.putExtra(CheckoutActivity.PRICE, priceView.getText());
                //Go to payment Activity
                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //startActivity(new Intent(getApplicationContext(), CheckoutActivity.class));
                Intent intent =  new Intent(getApplicationContext(), CheckoutActivity.class);
                intent.putExtra(CheckoutActivity.PRICE, priceView.getText());
                //Go to payment Activity
                startActivity(intent);
            }
        });

        alertDialog.show();

    }


}
