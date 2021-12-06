/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author george
 * 
 */
@Stateless
public class UserRepository {
    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;
    
    
    public List<User> findAll() {
        Query q = em.createNamedQuery("User.findAll");
        List users = q.getResultList();                 
        return users;
//         TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
//         List<User> results = query.getResultList();
//         return results;

    }

    public List find(Integer id) {
        Query q = em.createNamedQuery("User.findById");
        q.setParameter("id", id);
        
        List users = q.getResultList();     
            
        return users;
    }

    public List<User> findActive() {
         Query q = em.createNamedQuery("User.findByActive");
        q.setParameter("active", 1);
        
        List users = q.getResultList();     
            
        return users;
    }

    public List<User> findInactive() {
        Query q = em.createNamedQuery("User.findByActive");
        q.setParameter("active", 0);
        
        List users = q.getResultList();     
            
        return users;
    }

    public void create(User entity, List<Role> roles) {
        em.persist(entity);//insert
        
        entity.setRoleList(new ArrayList<>());
        
        for (Role unmanaged : roles) {
            Role managed = em.find(Role.class, unmanaged.getId());
            entity.getRoleList().add(managed);     
            managed.getUserList().add(entity);
        }
    }

    public List<User> findByUserName(String username) {
        Query q = em.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        
        List users = q.getResultList();     
            
        return users;
    }

    public List<User> findByPhone(String phone) {
        Query q = em.createNamedQuery("User.findByPhone");
        q.setParameter("phone", phone);
                
        List users = q.getResultList();     
            
        return users;
    }   
    
     public List<User> findByEmail(String email) {
        Query q = em.createNamedQuery("User.findByEmail");
        q.setParameter("email", email);
                
        List users = q.getResultList();     
            
        return users;
    }  

//    public List<User> findApproved(String registrationStatus) {
//
//    }

    public List<User> findApproved(int registrationStatus) {
        Query q = em.createNamedQuery("User.findByRegistrationStatus");
        q.setParameter("registrationStatus", registrationStatus);
                
        List users = q.getResultList();     
            
        return users;    
    }

    public List<User> update(User thisUser) {
        em.merge(thisUser);
        
        List users = new ArrayList();
        
        users.add(thisUser);
        
        return users;        
    }
    
}
