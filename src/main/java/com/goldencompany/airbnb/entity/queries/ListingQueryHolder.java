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
    @NamedQuery(name = "Listing.findByUserId", query = "SELECT l FROM Listing l WHERE l.userId.id = :x and l.active= 0"),
    @NamedQuery(name = "Listing.findActiveByUserId", query = "SELECT l FROM Listing l WHERE l.userId.id = :x and l.active= 1"),
    @NamedQuery(name = "Listing.findWithAcceptedBookingsByCustomerID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 1 and b.userId.id = :x and b.checkout > current_date) and l.active=1"),
    @NamedQuery(name = "Listing.findWithPendingBookingsByCustomerID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 0 and b.userId.id = :x and b.checkin > current_date) and l.active=1"),
    @NamedQuery(name = "Listing.findWithRejectedBookingsByCustomerID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 2 and b.userId.id =  :x) and l.active=1"),
    @NamedQuery(name = "Listing.findWithPreviousBookingsByCustomerID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where  b.userId.id = :x and b.checkout < current_date) and l.active=1"),//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
    @NamedQuery(name = "Listing.findWithAcceptedBookingsByHostID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 1 and b.listingId.userId.id =  :x) and l.active=1"),//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
    @NamedQuery(name = "Listing.findWithPendingBookingsByHostID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 0 and b.listingId.userId.id =  :x) and l.active=1"),//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
    @NamedQuery(name = "Listing.findWithRejectedBookingsByHostID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.bookingStatus = 1 and b.listingId.userId.id =  :x) and l.active=1"),//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
    @NamedQuery(name = "Listing.findWithPreviousBookingsByHostID", query = "select l from Listing l where l.id  in (select b.listingId.id from Booking b where b.listingId.userId.id = :x and b.checkout < current_date) and l.active=1"),//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),

})
public class ListingQueryHolder implements Serializable {

    @Id
    private long id;

}


// select l from Listing l where l.active = 1 and l.maxPeople  =3
// select l from Listing l where l.active = 1 and l.city = 'Athens'
//select l from Listing l where l.active = 1 and not exists (select b from Booking b where b.listingId.id = l.id  and ((b.checkin between '2010-10-10' and '2010-10-10' ) or (b.checkout between '2010-10-10' and '2010-10-10' )))