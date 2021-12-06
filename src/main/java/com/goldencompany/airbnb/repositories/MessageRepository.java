/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
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
public class MessageRepository {

    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;

    public List findByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findByUserId");
        q.setParameter("x", id);
        q.setParameter("y", id);

        List users = q.getResultList();

        return users;
    }

    public List findReceivedByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findReceivedByUserId");
        q.setParameter("x", id);

        List users = q.getResultList();

        return users;
    }

    public List findSentByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findSentByUserId");
        q.setParameter("x", id);

        List users = q.getResultList();

        return users;
    }

    //edw
    public List findDetailsByID(Integer id) {
        Query q = em.createNamedQuery("Message.findDetailsByID");
        q.setParameter("x", id);

        List users = q.getResultList();

        return users;
    }
    
      public List retrieveAllMessagesByUserID(Integer id) {
        Query q = em.createNamedQuery("Message.findAllMessagesByUserID");
        q.setParameter("x", id);

        List users = q.getResultList();

        return users;
    }
      
      
      public void create(Message entity) {
        em.persist(entity);//insert
        
    }

    public Message update(Message thisMessage) {
        em.merge(thisMessage);
        
         List users = new ArrayList();
        
        users.add(thisMessage);
        
        return thisMessage;   
    }

}
