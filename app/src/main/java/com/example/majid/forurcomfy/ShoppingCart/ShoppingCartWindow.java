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
import com.example.majid.forurcomfy.model.Request;
import com.google.firebase.database.DataSnapshot;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class ShoppingCartWindow extends AppCompatActivity {

    private final String TAG = ShoppingCartWindow.class.getSimpleName();
    //    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef;
    Boolean isCartEmpty = true;
    TextView priceView;
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    private FirebaseUser user;

    int totalAmount = 0;
    ArrayList<ShoppingItem> items;// =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_window);

        priceView = (TextView) findViewById(R.id.totalPriceCheckout);

        //mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    // User is signed in
//                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                    myRef = database.getReference("users/" + user.getUid());
//
//                    // adding value event listener for myRef
//                    myRef.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            if (dataSnapshot.getKey().equals(user.getUid())) {
//                                Log.e("CART", dataSnapshot.child("isCartEmpty").getValue().toString());
//                                isCartEmpty = (Boolean) dataSnapshot.child("isCartEmpty").getValue();
//                                if (isCartEmpty) {
//                                    priceView.setText(NumberFormat.getCurrencyInstance().format(0));
//                                } else {
//                                    setUpShoppingCart(dataSnapshot.child("cartItems"));
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError error) {
//                            Log.w(TAG, "Failed to read value.", error.toException());
//                        }
//                    });
//
//                } else {
//                    Log.d(TAG, "onAuthStateChanged:signed_out");
//                }
//            }
//        };

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
                Snackbar.make(findViewById(R.id.shoppingCartWindowLayout),
                        "Cleared!",
                        Snackbar.LENGTH_SHORT).show();
                //clearCart();
                finish();
            }
        });

    }
    private void setUpShoppingCart(DataSnapshot dataSnapshot) {

        totalAmount = 0;

        if (items != null){
            items.clear();
        } else {
            items = new ArrayList<>();
        }

        for (DataSnapshot snap : dataSnapshot.getChildren()){

            int itemPrice = -1, quantity = 0;

            try{
                itemPrice = Integer.valueOf(NumberFormat.getCurrencyInstance()
                        .parse(String.valueOf(snap.child("price").getValue()))
                        .toString());
            } catch (ParseException e){
                e.printStackTrace();
            }

            quantity = Integer.valueOf(snap.child("quantity").getValue().toString());

//            items.add(new ShoppingItem(
//                    snap.child("productID").getValue().toString(),
//                    snap.child("title").getValue().toString(),
//                    snap.child("type").getValue().toString(),
//                    snap.child("description").getValue().toString(),
//                    itemPrice,
//                    quantity
//            ));

            totalAmount += quantity*itemPrice;
        }

        ListView view = (ListView) findViewById(R.id.shoppingCartList);
        // Now the Cart gets updated whenever the data changes in the server
        view.setAdapter(new ShoppingCartAdapter(getApplicationContext(), items));

        priceView.setText(NumberFormat.getCurrencyInstance().format(totalAmount));
    }

//    private void clearCart() {
//
//        if (!isCartEmpty) {
////            DatabaseReference myRefClear = FirebaseDatabase.getInstance().getReference("users").child(user.getUid());
////            myRefClear.child(user.getUid()).push();
//
//            // As firebase does not accept keys with empty values, I'm putting a dummy item with empty Strings and -1 as ints
//            // Quantity of items in cart is not realtime database quantity but the quantity the user wants
//            ArrayList<ShoppingItem> cart = new ArrayList<>();
//            cart.add(new ShoppingItem("", "", "", "", -1, -1));
//            Map<String, Object> cartItems = new HashMap<>();
//            cartItems.put("cartItems", cart);
//
//            // Adding a isCartEmpty State Variable for cart window display
//
//            Map<String, Object> cartState = new HashMap<>();
//            cartState.put("isCartEmpty", Boolean.TRUE);
//
//            // Updating the database for the user
//            myRefClear.updateChildren(cartItems);
//            myRefClear.updateChildren(cartState);
//
//            isCartEmpty = true;
//        }
//    }
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
