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
public class CriticCreationUserForUserDTO {
//    private Integer id;

    private String text;
    private int rating;
//    private int bookingStatus;
   

    private int userRater;
    private int userRated;

   

    public CriticCreationUserForUserDTO() {
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

    public int getUserRater() {
        return userRater;
    }

    public void setUserRater(int userRater) {
        this.userRater = userRater;
    }

    public int getUserRated() {
        return userRated;
    }

    public void setUserRated(int userRated) {
        this.userRated = userRated;
    }
    
       
}
