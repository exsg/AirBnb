/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.repositories;

import com.goldencompany.airbnb.dto.input.SearchDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Photo;
import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.Type;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author george
 *
 */
@Stateless
public class ListingRepository {

    @PersistenceContext(unitName = "airbnb_db_pool_pu")
    private EntityManager em;

    public List<Listing> findAll() {
        Query q = em.createNamedQuery("Listing.findAll");
        List listing = q.getResultList();
        return listing;
//         TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
//         List<User> results = query.getResultList();
//         return results;

    }

    public List find(Integer id) {
        Query q = em.createNamedQuery("Listing.findById");
        q.setParameter("id", id);

        List users = q.getResultList();

        return users;
    }
//

    public List<Listing> findActive() {
        Query q = em.createNamedQuery("Listing.findByActive");
        q.setParameter("active", 1);

        List listing = q.getResultList();

        return listing;
    }
//

    public List<Listing> findInactive() {
        Query q = em.createNamedQuery("Listing.findByActive");
        q.setParameter("active", 0);

        List listings = q.getResultList();

        return listings;
    }
//
//    public void create(User entity, List<Role> roles) {
//        em.persist(entity);//insert
//        
//        entity.setRoleList(new ArrayList<>());
//        
//        for (Role unmanaged : roles) {
//            Role managed = em.find(Role.class, unmanaged.getId());
//            entity.getRoleList().add(managed);     
//            managed.getUserList().add(entity);
//        }
//    }
//
//    public List<User> findByUserName(String username) {
//        Query q = em.createNamedQuery("User.findByUsername");
//        q.setParameter("username", username);
//        
//        List users = q.getResultList();     
//            
//        return users;
//    }
//
//    public List<User> findByPhone(String phone) {
//        Query q = em.createNamedQuery("User.findByPhone");
//        q.setParameter("phone", phone);
//                
//        List users = q.getResultList();     
//            
//        return users;
//    }    
//
////    public List<User> findApproved(String registrationStatus) {
////
////    }
//
//    public List<User> findApproved(int registrationStatus) {
//        Query q = em.createNamedQuery("User.findByRegistrationStatus");
//        q.setParameter("registrationStatus", registrationStatus);
//                
//        List users = q.getResultList();     
//            
//        return users;    
//    }
//
//    public List<User> update(User thisUser) {
//        em.merge(thisUser);
//        
//        List users = new ArrayList();
//        
//        users.add(thisUser);
//        
//        return users;        
//    }

    public List<Listing> export() {
        Query q = em.createNamedQuery("Listing.findAll");
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findInactiveByUserId(Integer id) {
        Query q = em.createNamedQuery("Listing.findByUserId");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findActiveByUserId(Integer id) {
        Query q = em.createNamedQuery("Listing.findActiveByUserId");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findByListingId(Integer id) {
        Query q = em.createNamedQuery("Listing.findById");
        q.setParameter("id", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> update(Listing thisListing) {
        em.merge(thisListing);

        List listings = new ArrayList();

        listings.add(thisListing);

        return listings;
    }

    public List<Listing> create(Listing listing, int userId, int typeId, List<Amenity> amenities, Photo photo, List<Rule> rules) throws BaseValidationException {
        Type type = em.find(Type.class, typeId);

        if (type == null) {
            throw new BaseValidationException("Type id is  invalid");
        }

        User user = em.find(User.class, userId);

        if (user == null) {
            throw new BaseValidationException("User id is  invalid");
        }

        listing.setTypeId(type);

        listing.setUserId(user);

        listing.setAmenityList(new ArrayList<>());

        listing.setRuleList(rules);

        listing.setPhotoList(new ArrayList<>());

        listing.getPhotoList().add(photo);

        photo.setListingId(listing);

        em.persist(listing);

        for (Amenity a : amenities) {
            Amenity ent = em.find(Amenity.class, a.getId());
            listing.getAmenityList().add(ent);

            ent.getListingList().add(listing);
        }

        List listings = new ArrayList();

        listings.add(listing);

        return listings;
    }

    public List<Listing> findWithPendingBookingsByCustomerID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithPendingBookingsByCustomerID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithAcceptedBookingsByCustomerID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithAcceptedBookingsByCustomerID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithRejectedBookingsByCustomerID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithRejectedBookingsByCustomerID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithPreviousBookingsByCustomerID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithPreviousBookingsByCustomerID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithPendingBookingsByHostID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithPendingBookingsByHostID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithAcceptedBookingsByHosyID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithAcceptedBookingsByHostID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithRejectedBookingsByHostID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithRejectedBookingsByHostID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    public List<Listing> findWithPreviousBookingsByHostID(Integer id) {
        Query q = em.createNamedQuery("Listing.findWithPreviousBookingsByHostID");
        q.setParameter("x", id);
        List<Listing> listing = q.getResultList();
        return listing;
    }

    private boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public List<Listing> search(SearchDTO params) {
//        Query q = em.createNamedQuery("Listing.findWithPreviousBookingsByHostID");

        StringBuffer b = new StringBuffer();
        b.append("SELECT distinct l FROM Listing l join l.amenityList a join l.bookingList b where 1=1 ");

        if (!isNullOrEmpty(params.getCity())) {
            b.append(" and l.city like '").append(params.getCity()).append("'");
        }

        if (!isNullOrEmpty(params.getMaxPeople())) {
            Integer m = Integer.parseInt(params.getMaxPeople());
            b.append(" and l.maxPeople >= '").append(params.getMaxPeople()).append("'");
        }

        if (!isNullOrEmpty(params.getCost())) {
            Integer m = Integer.parseInt(params.getCost());
            b.append(" and l.cost <= '").append(params.getCost()).append("'");
        }

        if (params.getTypeId() > 0) {
            Integer m = params.getTypeId();

            b.append(" and l.typeId.id = '").append(params.getTypeId()).append("'");
        }

        if (params.isHasWifi()) {
            b.append(" and a.id = '1'");
        }
        if (params.isHasKitchen()) {
            b.append(" and a.id = '2'");
        }

        if (params.isHasTv()) {
            b.append(" and a.id = '3'");
        }

        if (params.isHasParking()) {
            b.append(" and a.id = '4'");
        }

        if (params.isHasElevator()) {
            b.append(" and a.id = '5'");
        }

        if (params.isHasHeating()) {
            b.append(" and a.id = '7'");
        }
        if (params.isHasLivingRoom()) {
            b.append(" and a.id = '8'");
        }
        if (params.isHasAirCondition()) {
            b.append(" and a.id = '6'");
        }

        if (!isNullOrEmpty(params.getCheckin())) {
            b.append("where not exists (select b from Booking b where b.listingId.id = l.id and '").append(params.getCheckin()).append(" ' between b.checkin and b.checkout )");
        }

        if (!isNullOrEmpty(params.getCheckout())) {
            b.append("where not exists (select b from Booking b where b.listingId.id = l.id and '").append(params.getCheckout()).append(" ' between b.checkin and b.checkout )");
        }

        TypedQuery<Listing> query = em.createQuery(b.toString(), Listing.class);

        List<Listing> listing = query.getResultList();

        return listing;
    }
}
