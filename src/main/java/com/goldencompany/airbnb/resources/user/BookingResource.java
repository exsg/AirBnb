package com.goldencompany.airbnb.resources.user;

import com.goldencompany.airbnb.annotations.SecuredHost;
import com.goldencompany.airbnb.controllers.BookingManagementController;
import com.goldencompany.airbnb.controllers.MessageManagementController;
import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
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
@Path("/bookings")
public class BookingResource {

    @Inject
    BookingManagementController controller;
//    

    @GET
    @Path("test_all")
    public Response test_all() {
        List bookings = controller.retrieveAllBookings();

        return Response
                .ok(bookings)
                .build();
    }

    @GET
    @Path("my_bookings/{id}")
    public Response sent(@PathParam("id") Integer id) {
        List message = controller.retrieveBookingsByUserID(id);

        return Response
                .ok(message)
                .build();
    }
//
//    //peirama 
    //get booking by listing id

    @GET
    @Path("incoming_bookings/{id}")
    public Response incoming_bookings(@PathParam("id") Integer id) {
        List bookings = controller.retrieveBookingsByListingId(id);

        return Response
                .ok(bookings)
                .build();
    }

    //create listing
    @POST
    @Path("/create")
    public Response create_booking(BookingCreationDTO input) {
//        return Response
//                .ok()
//                .build();

        BookingCreationDTO booking = controller.createBooking(input);

        return Response
                .ok(booking)
                .build();
    }

    //na ftia3w kai to postman
    @POST
//    @SecuredHost
    @Path("/accept_pending_booking/{id}")
    public Response accept_pending_booking(@PathParam("id") Integer id) {
//        return Response
//                .ok()
//                .build();
        try {
            BookingDTO booking = controller.acceptPendingBooking(id);

            return Response
                    .ok(booking)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
//    @SecuredHost
    @Path("/reject_pending_booking/{id}")
    public Response reject_pending_booking(@PathParam("id") Integer id) {
//        return Response
//                .ok()
//                .build();
        try {
            BookingDTO booking = controller.rejectPendingBooking(id);

            return Response
                    .ok(booking)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

    @POST
    @Path("/debug_make_booking_pending/{id}")
    public Response debug_make_booking_pending(@PathParam("id") Integer id) {
//        return Response
//                .ok()
//                .build();
        try {
            BookingDTO booking = controller.makeBookingPending(id);

            return Response
                    .ok(booking)
                    .build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }


}
