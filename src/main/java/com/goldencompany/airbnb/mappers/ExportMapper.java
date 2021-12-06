/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.dto.xml.ListingExportDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.Photo;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class ExportMapper {

    @Inject
    AmenityMapper amenityMapper;

    @Inject
    TypeMapper typeMapper;

    @Inject
    RuleMapper ruleMapper;

    @Inject
    PhotoMapper photoMapper;

    @Inject
    BookingMapper bookingMapper;

    @Inject
    CriticMapper criticMapper;

    public ListingExportDTO toDTO(Listing entity) {
        ListingExportDTO dto = new ListingExportDTO();

        dto.setId(entity.getId());
        dto.setGeolocation_lat(entity.getGeolocationLatitude());
        dto.setGeolocation_long(entity.getGeolocationLongitude());
        dto.setCountry(entity.getCountry());
        dto.setCity(entity.getCity());
        dto.setBedroom_num(entity.getBedroomNumber());
        dto.setDistrict(entity.getDistrict());
        dto.setFloor(entity.getFloor());
        dto.setMaxPeople(entity.getMaxPeople());
        dto.setBedNum(entity.getBedNumber());
        dto.setBathroomNum(entity.getBathroomNumber());
        dto.setDescription(entity.getDescription());
        dto.setMinDays(entity.getMinimumDays());
        dto.setActive(entity.getActive());
        dto.setSubmittedDate(entity.getSubmittedDate());
        dto.setExtraCostPerPerson(entity.getExtraCostPerPerson());

        return dto;
    }

    public List<ListingExportDTO> toDTO(List<Listing> entities) {
        List<ListingExportDTO> list = new ArrayList();

        for (Listing entity : entities) {
            ListingExportDTO listing = toDTO(entity);
            list.add(listing);

            for (Amenity a : entity.getAmenityList()) {
                listing.getAmenities().add(amenityMapper.toDTO(a));
            }

            listing.setType(typeMapper.toDTO(entity.getTypeId()));

            for (Rule r : entity.getRuleList()) {
                listing.getRules().add(ruleMapper.toDTO(r));
//                        .getRule().add(rule);
            }

            for (Photo p : entity.getPhotoList()) {
                listing.getPhoto().add(photoMapper.toDTO(p));
//                        .getRule().add(rule);
            }

            for (Booking b : entity.getBookingList()) {
                listing.getBooking().add(bookingMapper.toDTO(b));
//                        .getRule().add(rule);
            }

            for (Critic c : entity.getCriticList()) {
                listing.getCritic().add(criticMapper.toDTO(c));
//                        .getRule().add(rule);
            }
//            
        }

        return list;
    }
}
