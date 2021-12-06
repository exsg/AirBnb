/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.Booking;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author george
 *
 */
@Stateless
public class BookingRepository {

    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;

    public List findByBookingID(Integer id) {
        Query q = em.createNamedQuery("Booking.findById");
        q.setParameter("id", id);
//        q.setParameter("y", id);

        List users = q.getResultList();

        return users;
    }

    //edw
    public List retrieveAllBookings() {
        Query q = em.createNamedQuery("Booking.findAll");

        List bookings = q.getResultList();

        return bookings;
    }

    public List retrieveAllBookingsByUserId(int id) {
        Query q = em.createNamedQuery("Booking.findByUserId");
        q.setParameter("x", id);

        List bookings = q.getResultList();

        return bookings;

    }

    public List<Booking> retrieveAllBookingsByListingId(Integer id) {
        Query q = em.createNamedQuery("Booking.findByListingId");
        q.setParameter("x", id);

        List bookings = q.getResultList();

        return bookings;
    }

    public List<Booking> findByUserIDAndActive(Integer id) {
        Query q = em.createNamedQuery("Booking.findByUserIdAndActive");
        q.setParameter("x", id);

        List bookings = q.getResultList();
        return bookings;
    }

    public List<Booking> findByUserIDAndPending(Integer id) {
        Query q = em.createNamedQuery("Booking.findByUserIdAndPending");
        q.setParameter("x", id);

        List bookings = q.getResultList();
        return bookings;
    }

    public void create(Booking thisBooking) {
        em.persist(thisBooking);
    }

    public void update(Booking thisBooking) {
        em.merge(thisBooking);

    }

}
