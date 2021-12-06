package com.goldencompany.airbnb.resources.listing;

import com.goldencompany.airbnb.annotations.SecuredCustomer;
import com.goldencompany.airbnb.annotations.SecuredHost;
import com.goldencompany.airbnb.controllers.listing.ListingManagementController;
import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.input.ListingUpdateDTO;
import com.goldencompany.airbnb.dto.input.SearchDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.entity.constants.UserConstants;
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
@Path("/listing")
public class ListingResource {

    @Inject
    ListingManagementController controller;

    @GET
    @Path("/all")
    public Response list() {
        List listings = controller.retrieveListings();

        return Response
                .ok(listings)
                .build();
    }

    @GET
    @Path("{id}")
    public Response id(@PathParam("id") Integer id) {
        List user = controller.retrieveListingByID(id);

        return Response
                .ok(user)
                .build();
    }
//

    @GET
    @Path("active")
    public Response active() {
        List listings = controller.retrieveActiveListings();

        return Response
                .ok(listings)
                .build();
    }
//

    @GET
    @Path("inactive")
    public Response inactive() {
        List listings = controller.retrieveInactiveListings();

        return Response
                .ok(listings)
                .build();
    }

    //exw meinei sto oti prepei na ftia3w to function ston controller gia na kanei query me to id touy user
    @GET
    @Path("inactive/{id}")
    public Response inactive(@PathParam("id") Integer id) {
//        List listings = controller.retrieveInactiveByUserListings( id);
        List listings = controller.findInactiveByUserId(id);

        return Response
                .ok(listings)
                .build();
    }

    @GET
    @Path("active/{id}")
    public Response active(@PathParam("id") Integer id) {
//        List listings = controller.retrieveInactiveByUserListings( id);
        List listings = controller.findactiveByUserId(id);

        return Response
                .ok(listings)
                .build();
    }

    @POST
//    @SecuredHost
    @Path("update/{id}")
    public Response update(@PathParam("id") Integer id, ListingUpdateDTO input) {
        try {
            List listings = controller.updateListing(id, input);
//            List users = controller.approveUser(id);

            return Response
                    .ok(listings)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

    }

    @POST
//    @SecuredHost
    @Path("create")
    public Response create(ListingCreationDTO input) {
        try {
            List listing = controller.createListing(input);

            return Response
                    .ok(listing)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

//        return Response.ok().build();
    }

    @POST
//    @SecuredHost
    @Path("deactivate/{id}")
    public Response deactivate(@PathParam("id") Integer id) {
        try {
            List listings = controller.deactivateListing(id);

            return Response
                    .ok(listings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

//        return Response.ok().build();
    }

    @POST
//    @SecuredHost
    @Path("activate/{id}")
    public Response activate(@PathParam("id") Integer id) {
        try {
            List listings = controller.activateListing(id);

            return Response
                    .ok(listings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

//        return Response.ok().build();
    }

    @GET
//    @SecuredCustomer
    @Path("pending_bookings/customer/{id}")
    public Response with_pending_bookings(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithPendingBookingByUserId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredCustomer
    @Path("accepted_bookings/customer/{id}")
    public Response with_accepted_bookings(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithAcceptedBookingByUserId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredCustomer
    @Path("rejected_bookings/customer/{id}")
    public Response with_rejected_bookings(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithRejectedBookingByUserId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredCustomer
    @Path("previous_bookings/customer/{id}")
    public Response with_previous_bookings(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithPreviousBookingByUserId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    /////////////////////for host=============================================
    @GET
//    @SecuredHost
    @Path("pending_bookings/host/{id}")
    public Response with_pending_bookings_host(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithPendingBookingByHostId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredHost
    @Path("accepted_bookings/host/{id}")
    public Response with_accepted_bookings_host(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithAcceptedBookingByHostId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredHost
    @Path("rejected_bookings/host/{id}")
    public Response with_rejected_bookings_host(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithRejectedBookingByHostId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @GET
//    @SecuredHost
    @Path("previous_bookings/host/{id}")
    public Response with_previous_bookings_host(@PathParam("id") Integer id) {
        try {
            List bookings = controller.retrieveWithPreviousBookingByHostId(id);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }

    @POST
    @Path("search")
    public Response search(SearchDTO params) {
        try {
            List bookings = controller.search(params);

            return Response
                    .ok(bookings)
                    .build();
        } catch (BaseValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();

        }
    }
}
