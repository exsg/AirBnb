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
public class CriticDTO {
    private Integer id;
    private String text;
    private int rating;
    private Date date;
    private ListingDTO listingId;
//    private List <User> userId;
    private UserDTO userId;

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

              
   

    public ListingDTO getListingId() {
        return listingId;
    }

    public void setListingId(ListingDTO listingId) {
        this.listingId = listingId;
    }

    public UserDTO getUserId() {
        return userId;
    }

    public void setUserId(UserDTO userId) {
        this.userId = userId;
    }

    
    
    
}
