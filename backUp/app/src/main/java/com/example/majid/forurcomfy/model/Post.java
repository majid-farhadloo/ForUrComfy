package com.example.majid.forurcomfy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by farha on 3/30/2018.
 */

public class Post {
    @SerializedName("result")
    private String result;
    @SerializedName("message")
    private String message;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("email")
    @Expose
    private String email;

    public Post(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "result='" + result + '\'' +
                "email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cell='" + cell + '\'';
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Post(String fname, String lname, String email, String cell) {
        this.firstname = fname;
        this.lastname = lname;
        this.email = email;
        this.cell = cell;
       // this.reTypePassword = reTypepassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCell() {
        return cell;
    }
}
