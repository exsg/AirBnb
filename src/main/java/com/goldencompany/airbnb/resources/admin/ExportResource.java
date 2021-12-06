package com.goldencompany.airbnb.resources.admin;

import com.goldencompany.airbnb.auth.AuthController;
import com.goldencompany.airbnb.controllers.admin.ExportController;
import com.goldencompany.airbnb.controllers.admin.UserManagementController;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.xml.DatasetExportDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.goldencompany.airbnb.annotations.SecuredModerator;

/**
 *
 * @author
 */
// | /api/admin/data/export | GET | - | complete dataset
@Path("/admin/export")
public class ExportResource {

    @Inject
    ExportController controller;

    @GET
    @Path("json")
    @SecuredModerator
    @Produces({MediaType.APPLICATION_JSON})
    public Response json() {
        DatasetExportDTO dataset = controller.export();

        return Response
                .ok(dataset)
                .build();
    }

    @GET
    @Path("xml")
    @SecuredModerator
    @Produces({MediaType.APPLICATION_XML})
    public Response xml() {
        DatasetExportDTO dataset = controller.export();

        return Response
                .ok(dataset)
                .build();
    }

    
    @GET
    @Path("jsonBooking")
    @SecuredModerator
//    @Produces({MediaType.APPLICATION_JSON})
    public Response jsonBooking() {
         List dataset = controller.bookingOnly();

        return Response
                .ok(dataset)
                .build();
    }

}
