/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.entity.queries;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author george
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findByUserId", query = "SELECT b FROM Booking b WHERE b.userId.id = :x"),
    @NamedQuery(name = "Booking.findByListingId", query = "SELECT b FROM Booking b WHERE b.listingId.id = :x"),
    @NamedQuery(name = "Booking.findByUserIdAndActive", query = "SELECT b FROM Booking b WHERE b.userId.id = :x and b.bookingStatus = 1"),
    @NamedQuery(name = "Booking.findByUserIdAndPending", query = "SELECT b FROM Booking b WHERE b.userId.id = :x and b.bookingStatus = 0"),
    @NamedQuery(name = "Booking.findByUserIdAndDeclined", query = "SELECT b FROM Booking b WHERE b.userId.id = :x and b.bookingStatus = 2"), //    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
//    @NamedQuery(name = "Message.findSentByUserId", query = "SELECT m FROM Message m WHERE m.userIdFrom.id = :x"),
//    @NamedQuery(name = "Message.findDetailsByID", query = "SELECT m FROM Message m WHERE m.id = :x"),
//        findAllMessagesByUserID
//    @NamedQuery(name = "Message.findAllMessagesByUserID", query = "SELECT m FROM Message m WHERE m.userIdFrom.id = :x or m.userIdTo.id = :x")
})
public class BookingQueryHolder implements Serializable {

    @Id
    private long id;

}
