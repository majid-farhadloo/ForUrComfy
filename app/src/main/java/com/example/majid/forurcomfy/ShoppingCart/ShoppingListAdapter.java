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

import java.util.ArrayList;
import java.util.List;


public class ShoppingListAdapter extends ArrayAdapter<Shopping> implements View.OnClickListener {

    private ArrayList<Shopping> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        public TextView txtFoodName;
        public TextView txtPrice;
        public TextView txtQuantity;
        public TextView txtTotalprice;

    }

    public ShoppingListAdapter(ArrayList<Shopping> data, Context context) {
        super(context, R.layout.shopping_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Shopping shopping =(Shopping) object;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Shopping shopping = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.shopping_item, parent, false);
        viewHolder.txtFoodName = (TextView) convertView.findViewById(R.id.shoppingItemName);
        viewHolder.txtPrice = (TextView) convertView.findViewById(R.id.shoppingItemPrice);
        viewHolder.txtQuantity = (TextView) convertView.findViewById(R.id.shoppingItemQuantity);
        viewHolder.txtTotalprice = (TextView) convertView.findViewById(R.id.shoppingItemTotal);

        viewHolder.txtFoodName.setText(shopping.getFoodName());
        viewHolder.txtPrice.setText(shopping.getPrice());
        viewHolder.txtQuantity.setText(shopping.getQuantity());
        viewHolder.txtTotalprice.setText(shopping.getTotalprice());

        convertView.setTag(viewHolder);

        // Return the completed view to render on screen
        return convertView;
    }
}
