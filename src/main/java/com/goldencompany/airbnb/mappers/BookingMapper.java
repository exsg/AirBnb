/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class BookingMapper {

    @Inject
    UserMapper userMapper;
    
//    @Inject
//    ListingMapper listingMapper;

    public BookingDTO toDTO(Booking entity) {
        BookingDTO dto = new BookingDTO();

        dto.setId(entity.getId());
        dto.setCheckIn(entity.getCheckin());
        dto.setCheckOut(entity.getCheckout());
        dto.setBookingStatus(entity.getBookingStatus());
        dto.setHowManyPeople(entity.getHowManyPeople());

//        User bookingUser = entity.getUserId();
//        Listing listing = entity.getListingId();
        
        
        User user =entity.getUserId();               
        UserDTO userDTO= userMapper.toDTO(user);
        dto.setUser(userDTO);
//den mporw na valw ta listings giati m kanei loop kai den mporw na skeftw pws na to kseperasw to loop , isws an ftia3w kapoia allh function alla kai pali 
//mporei na mhn ftia3ei ... sunexizw me alla.
        Listing listing = entity.getListingId();
                
//        ListingDTO listingDTO = listingMapper.toDTO(listing);
//        dto.setListing(listingDTO);
        return dto;
    }

    public List toDTO(List<Booking> entities) {
        List list = new ArrayList();

        for (Booking entity : entities) {
            BookingDTO booking = toDTO(entity);
            list.add(booking);
        }

        return list;
    }
    
    
//    public static final int PENDING = 0;
//    public static final int APPROVED = 1;
//    public static final int REJECTED = 2;

    public Booking toEntity(BookingCreationDTO input, User user, Listing listing) {
        Booking entity = new Booking();
        entity.setBookingStatus(0);
        entity.setCheckin(input.getCheckIn());
        entity.setCheckout(input.getCheckOut());
        entity.setHowManyPeople(input.getHowManyPeople());
        entity.setListingId(listing);
        entity.setUserId(user);
//        entity.setMessageList(messageList);
        entity.setListingId(listing);
        return entity;
    }
}
