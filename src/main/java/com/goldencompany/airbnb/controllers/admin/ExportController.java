/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.admin;

import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.xml.DatasetExportDTO;
import com.goldencompany.airbnb.dto.xml.ListingExportDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.BookingMapper;
import com.goldencompany.airbnb.mappers.ExportMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.BookingRepository;
import com.goldencompany.airbnb.repositories.ListingRepository;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class ExportController {

    @Inject
    ListingRepository listingRepository;
    
    @Inject
    BookingRepository bookingRepository;

    @Inject
    ExportMapper exportMapper;

    @Inject
    BookingMapper bookingMapper;

    public DatasetExportDTO export() {

        List<Listing> export = listingRepository.export();

        List<ListingExportDTO> data = exportMapper.toDTO(export);

        DatasetExportDTO dataset = new DatasetExportDTO(data);

        return dataset;

    }

    public List bookingOnly() {

//        List<Listing> export = listingRepository.export();

        List <Booking> bookings = bookingRepository.retrieveAllBookings();
        List  dtos  = bookingMapper.toDTO(bookings);

//        BookingDTO dataset = new BookingDTO(dtos);

        return dtos;

    }

}
