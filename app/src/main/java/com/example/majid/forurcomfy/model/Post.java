<<<<<<< HEAD
package com.example.majid.forurcomfy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by farha on 3/30/2018.
 */

public class Post {
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("mobilePhone")
    @Expose
    private String mobilePhone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("reTypePassword")
    @Expose
    private String reTypePassword;

    public Post() {

    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", reTypePassword='" + reTypePassword + '\'' +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }

    public Post(String fnmae, String lnmae, String email, String password, String reTypepassword) {
        this.fname = fnmae;
        this.lname = lnmae;
        this.email = email;
        this.password = password;
        this.reTypePassword = reTypepassword;
    }
}
=======
package com.example.majid.forurcomfy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by farha on 3/30/2018.
 */

public class Post {
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
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("reTypePassword")
    @Expose
    private String reTypePassword;

    public Post(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", reTypePassword='" + reTypePassword + '\'' +
                '}';
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypePassword() {
        return reTypePassword;
    }

    public void setReTypePassword(String reTypePassword) {
        this.reTypePassword = reTypePassword;
    }

    public Post(String fname, String lname, String email, String password) {
        this.firstname = fname;
        this.lastname = lname;
        this.email = email;
        this.password = password;
       // this.reTypePassword = reTypepassword;
    }
}
>>>>>>> Shopping Cart internal Catalog no firebase
