/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Amenity;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.Photo;
import com.goldencompany.airbnb.entity.Rule;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class ListingMapper {

    @Inject
    AmenityMapper amenityMapper;

    @Inject
    RuleMapper ruleMapper;

    @Inject
    TypeMapper typeMapper;
//    
    @Inject
    PhotoMapper photoMapper;

    @Inject
    BookingMapper bookingMapper;

    @Inject
    CriticMapper criticMapper;

    public ListingDTO toDTO(Listing entity) {
        ListingDTO dto = new ListingDTO();

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
        dto.setFriendlyName(entity.getFriendlyName());
        dto.setCost(entity.getCost());
        dto.setSqrMeters(entity.getSqrMeters());

        for (Photo p : entity.getPhotoList()) {
            dto.getPhotos().add(photoMapper.toDTO(p));
        }

//        User from = entity.getUserIdFrom();
//        User to = entity.getUserIdTo();
//        List<User> entities = new ArrayList<>();
//        
//        entities.add(from);
//        entities.add(to);
//        
//        List dtos = userMapper.toDTO(entities);
//        
//        UserDTO fromdto = (UserDTO) dtos.get(0);
//        UserDTO todto = (UserDTO) dtos.get(1);
//        
//        dto.setSender(fromdto);
//        dto.setReceiver(todto);
        return dto;
    }

    public List toDTO(List<Listing> entities) {
        List list = new ArrayList();

        for (Listing entity : entities) {
            ListingDTO listing = toDTO(entity);
            list.add(listing);

            for (Amenity a : entity.getAmenityList()) {
                listing.getAmenities().add(amenityMapper.toDTO(a));
            }

            listing.setType(typeMapper.toDTO(entity.getTypeId()));

            for (Rule r : entity.getRuleList()) {
                listing.getRules().add(ruleMapper.toDTO(r));
//                        .getRule().add(rule);
            }

            for (Booking b : entity.getBookingList()) {
                listing.getBookings().add(bookingMapper.toDTO(b));
            }
            for (Critic c : entity.getCriticList()) {
                listing.getCritics().add(criticMapper.toDTO(c));
            }
        }

        return list;
    }

    public Listing toEntity(ListingCreationDTO dto) {
        Listing entity = new Listing();

        entity.setGeolocationLatitude(dto.getGeolocation_lat());
        entity.setGeolocationLongitude(dto.getGeolocation_long());
        entity.setCountry(dto.getCountry());
        entity.setBedroomNumber(dto.getBedroom_num());
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setSqrMeters(dto.getSqrMeters());
        entity.setFloor(dto.getFloor());
        entity.setMaxPeople(dto.getMaxPeople());
        entity.setBedNumber(dto.getBedNum());
        entity.setDescription(dto.getDescription());
        entity.setMinimumDays(dto.getMinDays());
        entity.setSubmittedDate(new Date());
        entity.setExtraCostPerPerson(dto.getExtraCostPerPerson());
        entity.setFriendlyName(dto.getFriendlyName());
        entity.setBathroomNumber(dto.getBathroomNum());
        entity.setCost(dto.getCost());

//        dto.setId(entity.getId());
//        dto.setGeolocation_lat(entity.getGeolocationLatitude());
//        dto.setGeolocation_long(entity.getGeolocationLongitude());
//        dto.setCountry(entity.getCountry());
//        dto.setCity(entity.getCity());
//        dto.setBedroom_num(entity.getBedroomNumber());
//        dto.setDistrict(entity.getDistrict());
//        dto.setFloor(entity.getFloor());
//        dto.setMaxPeople(entity.getMaxPeople());
//        dto.setBedNum(entity.getBedNumber());
//        dto.setBathroomNum(entity.getBathroomNumber());
//        dto.setDescription(entity.getDescription());
//        dto.setMinDays(entity.getMinimumDays());
//        dto.setActive(entity.getActive());
//        dto.setSubmittedDate(entity.getSubmittedDate());
//        dto.setExtraCostPerPerson(entity.getExtraCostPerPerson());
//        dto.setFriendlyName(entity.getFriendlyName());
//        User from = entity.getUserIdFrom();
//        User to = entity.getUserIdTo();
//        List<User> entities = new ArrayList<>();
//        
//        entities.add(from);
//        entities.add(to);
//        
//        List dtos = userMapper.toDTO(entities);
//        
//        UserDTO fromdto = (UserDTO) dtos.get(0);
//        UserDTO todto = (UserDTO) dtos.get(1);
//        
//        dto.setSender(fromdto);
//        dto.setReceiver(todto);
        return entity;
    }

}
