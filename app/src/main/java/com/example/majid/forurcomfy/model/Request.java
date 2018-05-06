package com.example.majid.forurcomfy.model;

<<<<<<< HEAD
import com.example.majid.forurcomfy.Data.model.ShoppingItem;
=======
import com.example.majid.forurcomfy.ShoppingCart.Shopping;
import com.example.majid.forurcomfy.ShoppingCart.ShoppingItem;
>>>>>>> 8cdfa5ed5338a7c46bb506b0bcc72a4d995afd50

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farha on 5/4/2018.
 */

public class Request {
    private String phone;
    private String address;
    private String name;
    private String total;
    private List<Shopping> foods;

    public Request(String cell, String getfirstname, String getlastname, String s, String toString, ArrayList<Shopping> items) {
    }

    public Request(String phone, String address, String name, String total, List<Shopping> foods) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        this.total = total;
        this.foods = foods;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Shopping> getFoods() {
        return foods;
    }

    public void setFoods(List<Shopping> foods) {
        this.foods = foods;
    }

}
