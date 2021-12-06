package com.goldencompany.airbnb.resources.user;

import com.goldencompany.airbnb.controllers.MessageManagementController;
import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// | /api/admin/users | GET | - | all users
// | /api/admin/users/:id | GET | id | user details of user with that ID
/**
 *
 * @author
 */
@Path("/messages")
public class MessagingResource {

    @Inject
    MessageManagementController controller;
//    
//    @GET    
//    @Path("")
//    public Response list(){     
//        List users = controller.retrieveUsers();
//        
//        return Response
//                .ok(users)
//                .build();
//    }
//    

    @GET
    @Path("received/{id}")
    public Response received(@PathParam("id") Integer id) {
        List message = controller.retrieveReceivedMessageByUserID(id);

        return Response
                .ok(message)
                .build();
    }

    @GET
    @Path("sent/{id}")
    public Response sent(@PathParam("id") Integer id) {
        List message = controller.retrieveSentMessageByUserID(id);

        return Response
                .ok(message)
                .build();
    }

    //peirama 
    @GET
    @Path("details/{id}")
    public Response details(@PathParam("id") Integer id) {
        List message = controller.retrieveMessageDetailsByID(id);

        return Response
                .ok(message)
                .build();
    }

    @GET
    @Path("all/{id}")
    public Response all(@PathParam("id") Integer id) {
        List message = controller.retrieveAllMessagesByUserID(id);

        return Response
                .ok(message)
                .build();
    }

    @POST
    @Path("/send_message")
    public Response sendMessage(MessageCreationDTO input) {
        MessageCreationDTO message = controller.sendMessage(input);

        return Response
                .ok(message)
                .build();
    }

    @POST
    @Path("/delete_message/{id}")
    public Response deleteMessage(@PathParam("id") Integer id) {
        try {
        MessageDTO message = controller.deleteMessage(id);

        return Response
                .ok(message)
                .build();
        } catch(UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
    
    
        @POST
    @Path("/undelete_message/{id}")
    public Response undeleteMessage(@PathParam("id") Integer id) {
        try {
        MessageDTO message = controller.undeleteMessage(id);

        return Response
                .ok(message)
                .build();
        } catch(UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
