/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import java.util.Date;

/**
 *
 * @author george
 */
public class UpdateDTO {
    private String firstname;
    private String lastname;
    private String password;
    private String password_confirmation;
    private String email;

  
    private String phone;
//    private Date birthdate;
    private String photoUrl;
//    private boolean is_host;
//    private boolean is_customer;

    public UpdateDTO() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//den ta xreiazomaste gia to update giati einai unique kai den 8eloume na ta mperdepsoyme me thn db
    public String getPassword() { 
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

//    public Date getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(Date birthdate) {
//        this.birthdate = birthdate;
//    }

//    public boolean isIs_host() {
//        return is_host;
//    }
//
//    public void setIs_host(boolean is_host) {
//        this.is_host = is_host;
//    }
//
//    public boolean isIs_customer() {
//        return is_customer;
//    }
//
//    public void setIs_customer(boolean is_customer) {
//        this.is_customer = is_customer;
//    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
      public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    

}
