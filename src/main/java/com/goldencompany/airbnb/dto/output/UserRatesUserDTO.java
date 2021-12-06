/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.output;

import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author george
 */
public class UserRatesUserDTO {
    private Integer id;
    private String text;
    private int rating;
    private Date date;
    private UserDTO userId1;
//    private List <User> userId;
    private UserDTO userId2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getUserId1() {
        return userId1;
    }

    public void setUserId1(UserDTO userId1) {
        this.userId1 = userId1;
    }

    public UserDTO getUserId2() {
        return userId2;
    }

    public void setUserId2(UserDTO userId2) {
        this.userId2 = userId2;
    }

   
    
}
