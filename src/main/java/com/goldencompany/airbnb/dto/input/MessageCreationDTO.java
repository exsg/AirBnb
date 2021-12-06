/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import com.goldencompany.airbnb.dto.output.*;
import java.util.Date;

/**
 *
 * @author george
 */
public class MessageCreationDTO {
    private String text;

    private Integer sender;
    private Integer receiver;
    private Integer bookingId;
    private Date date= new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    
    public MessageCreationDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Date getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(Date dateTime) {
//        this.dateTime = dateTime;
//    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }


    
    

    
}
