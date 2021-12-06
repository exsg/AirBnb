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
    @NamedQuery(name = "Message.findByUserId", query = "SELECT m FROM Message m WHERE m.active=1 and m.userIdFrom.id = :x or m.userIdTo.id = :y"),
    @NamedQuery(name = "Message.findReceivedByUserId", query = "SELECT m FROM Message m WHERE  m.active=1 and  m.userIdTo.id = :x"),
    @NamedQuery(name = "Message.findSentByUserId", query = "SELECT m FROM Message m WHERE  m.active=1 and m.userIdFrom.id = :x"),
    @NamedQuery(name = "Message.findDetailsByID", query = "SELECT m FROM Message m WHERE  m.active=1 and m.id = :x"),
//        findAllMessagesByUserID
//    @NamedQuery(name = "Message.findAllMessagesByUserID", query = "SELECT m FROM Message m WHERE m.userIdFrom.id = :x or m.userIdTo.id = :x")
    
})
public class MessageQueryHolder  implements Serializable {
     @Id
     private long id;
    
}
