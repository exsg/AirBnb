/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.UserRatesUser;
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
public class CriticRepository {

    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;

    public List findByCriticID(Integer id) {
        Query q = em.createNamedQuery("Critic.findById");
        q.setParameter("id", id);
//        q.setParameter("y", id);

        List users = q.getResultList();

        return users;
    }

    public List retrieveAllCritics() {
        Query q = em.createNamedQuery("Critic.findAll");

        List critics = q.getResultList();

        return critics;
    }

    public List retrieveCriticsByCriticId(Integer id) {
        Query q = em.createNamedQuery("Critic.findById");
        q.setParameter("id", id);
        List critics = q.getResultList();

        return critics;
    }

    public List<Critic> retrieveCriticsByUserId(Integer id) {
        Query q = em.createNamedQuery("Critic.findByUserId");
        q.setParameter("id", id);
        List critics = q.getResultList();

        return critics;
    }

    public List<Critic> retrieveCriticsByListingId(Integer id) {
        Query q = em.createNamedQuery("Critic.findByListingId");
        q.setParameter("id", id);
        List critics = q.getResultList();

        return critics;
    }

//    public List retrieveAllBookingsByUserId(int id) {
//        Query q = em.createNamedQuery("Booking.findByUserId");
//        q.setParameter("x", id);
//
//        List bookings = q.getResultList();
//
//        return bookings;
//
//    }
//    public List<Booking> retrieveAllBookingsByListingId(Integer id) {
//        Query q = em.createNamedQuery("Booking.findByListingId");
//        q.setParameter("x", id);
//
//        List bookings = q.getResultList();
//
//        return bookings;
//    }
    public void create(Critic thisCritic) {
        em.persist(thisCritic);
    }

    public void create(UserRatesUser thisCritic) {
        em.persist(thisCritic);
    }

    public void update(Critic thisCritic) {
        em.merge(thisCritic);

    }

}
