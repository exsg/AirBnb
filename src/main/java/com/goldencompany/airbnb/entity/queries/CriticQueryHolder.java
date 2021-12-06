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
    @NamedQuery(name = "Critic.findByUserId", query = "SELECT c FROM Critic c WHERE c.userId.id = :id"),
    @NamedQuery(name = "Critic.findByListingId", query = "SELECT c FROM Critic c WHERE c.listingId.id = :id"), 
//    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE m.userIdTo.id = :x"),
//    @NamedQuery(name = "Message.findSentByUserId", query = "SELECT m FROM Message m WHERE m.userIdFrom.id = :x"),
//    @NamedQuery(name = "Message.findDetailsByID", query = "SELECT m FROM Message m WHERE m.id = :x"),
//        findAllMessagesByUserID
//    @NamedQuery(name = "Message.findAllMessagesByUserID", query = "SELECT m FROM Message m WHERE m.userIdFrom.id = :x or m.userIdTo.id = :x")
})
public class CriticQueryHolder implements Serializable {

    @Id
    private long id;

}
