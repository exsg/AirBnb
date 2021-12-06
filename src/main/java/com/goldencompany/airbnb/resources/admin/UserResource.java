package com.goldencompany.airbnb.resources.admin;

import com.goldencompany.airbnb.annotations.SecuredModerator;
import com.goldencompany.airbnb.controllers.admin.UserManagementController;
import com.goldencompany.airbnb.entity.constants.UserConstants;
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
@Path("/admin/users")
public class UserResource {

    @Inject
    UserManagementController controller;

    @GET
    @Path("")
    public Response list() {
        List users = controller.retrieveUsers();

        return Response
                .ok(users)
                .build();
    }

    @GET
    @Path("{id}")
//    @SecuredModerator
    public Response id(@PathParam("id") Integer id) {
        List user = controller.retrieveUserByID(id);

        return Response
                .ok(user)
                .build();
    }

    @GET
    @Path("active")
    @SecuredModerator
    public Response active() {
        List users = controller.retrieveActiveUsers();

        return Response
                .ok(users)
                .build();
    }

    @GET
    @Path("inactive")
    @SecuredModerator
    public Response inactive() {
        List users = controller.retrieveInactiveUsers();

        return Response
                .ok(users)
                .build();
    }

    @GET
    @Path("approved")
    @SecuredModerator
    public Response approved() {
        List users = controller.retrieveUsersByStatus(UserConstants.APPROVED);

        return Response
                .ok(users)
                .build();
    }

    @GET
    @Path("pending")
    @SecuredModerator
    public Response pending() {
        List users = controller.retrieveUsersByStatus(UserConstants.PENDING);

        return Response
                .ok(users)
                .build();
    }

    @GET
    @Path("rejected")
    @SecuredModerator
    public Response rejected() {
        List users = controller.retrieveUsersByStatus(UserConstants.REJECTED);

        return Response
                .ok(users)
                .build();
    }

    @POST
    @Path("approve/{id}")
    @SecuredModerator
    public Response approve(@PathParam("id") Integer id) {
        try {
            List users = controller.approveUser(id);

            return Response
                    .ok(users)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path("reject/{id}")
    @SecuredModerator
    public Response reject(@PathParam("id") Integer id) {
        try {
            List users = controller.rejectUser(id);
//            List users = controller.approveUser(id);

            return Response
                    .ok(users)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path("reject_approved/{id}")
    @SecuredModerator
    public Response reject_approved(@PathParam("id") Integer id) {
        try {
            List users = controller.rejectApprovedUser(id);
//            List users = controller.approveUser(id);

            return Response
                    .ok(users)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path("approve_rejected/{id}")
    @SecuredModerator
    public Response approve_rejected(@PathParam("id") Integer id) {
        try {
            List users = controller.approveRejectedUser(id);
//            List users = controller.approveUser(id);

            return Response
                    .ok(users)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
