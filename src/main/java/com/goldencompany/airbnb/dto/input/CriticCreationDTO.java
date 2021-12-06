/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import com.goldencompany.airbnb.dto.output.*;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbDateFormat;

/**
 *
 * @author george
 */
public class CriticCreationDTO {
//    private Integer id;

    private String text;
    private int rating;
//    private int bookingStatus;
   

    private int userId;
    private int listingId;

    public CriticCreationDTO(String text, int rating, int userId, int listingId) {
        this.text = text;
        this.rating = rating;
        this.userId = userId;
        this.listingId = listingId;
    }

    public CriticCreationDTO() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

                         
}
