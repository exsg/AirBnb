package com.goldencompany.airbnb.resources;

import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("test")
public class JavaEE8Resource {
    
    @PersistenceUnit(unitName = "airbnb_db_pool_pu")
    private EntityManagerFactory entityManagerFactory;


     
    @GET
    @Path("ping")
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("peng")
    public Response peng(){
        return Response
                .ok("peng")
                .build();
    }
    
    @GET
    @Path("users")
    public Response pong(){
        
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            
            Query q = em.createQuery("Select u from User u");
            List users = q.getResultList();                                                                                      
            
            
            
                      
            return Response
                .ok(users)
                .build();
        } catch (Exception ex) {
               return Response
                .ok(ex.toString())
                .build();
        }
         
//        UserRepository userRep = new UserRepository();
        
//        User user = userRep.findByUsername("bob");
        
     
    }
    
}
