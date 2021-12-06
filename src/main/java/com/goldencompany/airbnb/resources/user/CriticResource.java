package com.goldencompany.airbnb.resources.user;

import com.goldencompany.airbnb.controllers.BookingManagementController;
import com.goldencompany.airbnb.controllers.CriticManagementController;
import com.goldencompany.airbnb.controllers.MessageManagementController;
import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationUserForUserDTO;
import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
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
@Path("/critic")
public class CriticResource {

    @Inject
    CriticManagementController controller;
//    

    @GET
    @Path("test_all")
    public Response test_all() {
        List critics = controller.retrieveAllCritics();

        return Response
                .ok(critics)
                .build();
    }

    @GET
    @Path("{id}")
    public Response id(@PathParam("id") Integer id) {
        try {
            List critics = controller.retrieveCriticsByCriticId(id);

            return Response
                    .ok(critics)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path("/by_user_id/{id}")
    public Response by_user_id(@PathParam("id") Integer id) {
        try {
            List critics = controller.retrieveCriticsByUserId(id);

            return Response
                    .ok(critics)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @GET
    @Path("/by_listing_id/{id}")
    public Response by_listing_id(@PathParam("id") Integer id) {
        try {
            List critics = controller.retrieveCriticsByListingId(id);

            return Response
                    .ok(critics)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    //den einai etoimh h create
    @POST
    @Path("/create")
    public Response create(CriticCreationDTO input) {
        try {
//            List critics = controller.retrieveCriticsByListingId(id);
            CriticCreationDTO critic = controller.createCritic(input);
            return Response
                    .ok(critic)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

//    @POST
//    @Path("/create/for_user")
//    public Response createForUser(CriticCreationUserForUserDTO input) {
//        try {
////            List critics = controller.retrieveCriticsByListingId(id);
//            CriticCreationUserForUserDTO critic = controller.createCriticUserForUser(input);
//            return Response
//                    .ok(critic)
//                    .build();
//        } catch (BaseValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
//
//    @GET
//    @Path("/test_all/user")
//    public Response createForUser() {
//
////            List critics = controller.retrieveCriticsByListingId(id);
//        List<CriticCreationUserForUserDTO> critics = controller.retrieveAllForUser();
//        return Response
//                .ok(critics)
//                .build();
//
//    }
//
//    @GET
//    @Path("/by_rater_id/{id}")
//    public Response by_rater_id(@PathParam("id") Integer id) {
//
////            List critics = controller.retrieveCriticsByListingId(id);
//        try {
//            List<CriticCreationUserForUserDTO> critics = controller.retrieveByRaterId(id);
//            return Response
//                    .ok(critics)
//                    .build();
//        } catch (BaseValidationException ex) {
//            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
//        }
//    }
//
//}

}
