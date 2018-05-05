package com.example.majid.forurcomfy.ShoppingCart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.majid.forurcomfy.R;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



public class ShoppingCartAdapter extends ArrayAdapter {
    Context context;
    List<ShoppingItem> items = new ArrayList<>();

    public ShoppingCartAdapter(Context context, List<ShoppingItem> items){
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cart_item, parent, false
            );
        }

        ShoppingItem currentItem = (ShoppingItem) getItem(position);
        ((TextView) listItemView.findViewById(R.id.cartItemName))
                .setText(currentItem.getFoodName());

        String x = "x " + String.valueOf(currentItem.getQuantity());
        ((TextView) listItemView.findViewById(R.id.cartItemQuantity))
                .setText(x);

        int itemPrice=0;
        try{
            itemPrice = Integer.valueOf(NumberFormat.getCurrencyInstance()
                    .parse(String.valueOf(currentItem.getPrice()))
                    .toString());
        } catch (ParseException e){
            e.printStackTrace();
        }
        ((TextView) listItemView.findViewById(R.id.cartItemPrice))
                .setText(NumberFormat.getCurrencyInstance().format(itemPrice));

        ((TextView) listItemView.findViewById(R.id.cartItemTotal))
                .setText(NumberFormat.getCurrencyInstance().format(itemPrice * currentItem.getQuantity()));

        return listItemView;
    }
}
