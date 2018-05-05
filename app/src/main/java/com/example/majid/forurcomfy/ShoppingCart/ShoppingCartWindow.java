package com.example.majid.forurcomfy.ShoppingCart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.majid.forurcomfy.Common.Current;
import com.example.majid.forurcomfy.Data.model.FoodMenu;
import com.example.majid.forurcomfy.Data.model.SqliteHelper;
import com.example.majid.forurcomfy.PaymentActivity;
import com.example.majid.forurcomfy.R;
import com.example.majid.forurcomfy.model.Request;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartWindow extends AppCompatActivity {

    private final String TAG = ShoppingCartWindow.class.getSimpleName();
    //    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef;
    Boolean isCartEmpty = true;
    TextView priceView;
    SqliteHelper dbhelper;
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    private FirebaseUser user;
    int totalAmount = 0;
    ArrayList<ShoppingItem> items;// =
    ListView cartList;
//    List<FoodMenu> mItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_window);
        dbhelper = new SqliteHelper(getApplicationContext(), "ShoppingCart.db", null, 1);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM SHOPPING_CART", null);
        startManagingCursor(cursor);

        MyListAdapter listAdapter = null;
        listAdapter = new MyListAdapter(this, cursor, 0);

        priceView = (TextView) findViewById(R.id.totalPriceCheckout);
        cartList = (ListView) findViewById(R.id.shoppingCartList);
        cartList.setAdapter(listAdapter);

        int total = dbhelper.getTotalPrice();

        priceView.setText(Integer.toString(total));

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
                dbhelper.clear();
                MyListAdapter listAdapter = null;
                cartList.setAdapter(listAdapter);
                priceView.setText("0");
                Snackbar.make(findViewById(R.id.shoppingCartWindowLayout),
                        "Cleared!",
                        Snackbar.LENGTH_SHORT).show();
                //clearCart();
            }
        });
    }

    class MyItem {
        MyItem(int itemName) {
            itemName = itemName;
        }
        int itemName;
    }

    class MyListAdapter extends CursorAdapter {
        private LayoutInflater cursorInflater;

        public MyListAdapter(Context context, Cursor c, int flags) {
            super(context, c, flags);
            cursorInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return cursorInflater.inflate(R.layout.cart_list_view, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView textView = (TextView) view.findViewById(R.id.text1);
            TextView et2 = (TextView) view.findViewById(R.id.text2);

            String name = cursor.getString(cursor.getColumnIndex("itemName"));
            int quantity = cursor.getInt(cursor.getColumnIndex("quantity"));

            textView.setText(name);
            et2.setText(Integer.toString(quantity));
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
                        priceView.getText().toString(),items);
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
