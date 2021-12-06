/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.CriticCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationUserForUserDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.CriticDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.UserRatesUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class CriticMapper {

    @Inject
    UserMapper userMapper;

//    @Inject
//    ListingMapper listingMapper;
//    
    public CriticDTO toDTO(Critic entity) {
        CriticDTO dto = new CriticDTO();

        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setRating(entity.getRating());
        dto.setDate(entity.getDate());

//        User bookingUser = entity.getUserId();
//        Listing listing = entity.getListingId();
        User user = entity.getUserId();

//        Listing listing = entity.getListingId();
        UserDTO userDTO = userMapper.toDTO(user);
//        ListingDTO listingDTO=listingMapper.toDTO(listing);

        dto.setUserId(userDTO);
//        dto.setListingId(listingDTO);

        return dto;
    }

    public List toDTO(List<Critic> entities) {
        List list = new ArrayList();

        for (Critic entity : entities) {
            CriticDTO critic = toDTO(entity);
            list.add(critic);
        }

        return list;
    }

    public Critic toEntity(CriticCreationDTO input, User user, Listing listing) {
        Critic thisCritic = new Critic();
        thisCritic.setDate(new Date());
        thisCritic.setListingId(listing);
        thisCritic.setUserId(user);
        thisCritic.setText(input.getText());
        return thisCritic;
    }
    
    
    //epeidh einai kai ayto ena critic alla se user anti gia listing, protimw na to valw edw anti na ftia3w kainourio mapper
    public UserRatesUser toEntity(CriticCreationUserForUserDTO input, User user1, User user2) {
        UserRatesUser thisCritic = new UserRatesUser();
        thisCritic.setDate(new Date());
        thisCritic.setUserId1(user1);
        thisCritic.setUserId2(user2);
        thisCritic.setText(input.getText());
        thisCritic.setRating(input.getRating());
        return thisCritic;
    }
    
    public CriticCreationUserForUserDTO toDTOuser(UserRatesUser entity){
        CriticCreationUserForUserDTO dto = new CriticCreationUserForUserDTO();
        dto.setRating(entity.getRating());
        dto.setText(entity.getText());
        dto.setUserRater(entity.getUserId1().getId());
        dto.setUserRated(entity.getUserId2().getId());
        return dto;
    }

    public List<CriticCreationUserForUserDTO> toDTOuser(List<UserRatesUser> entities) {
        List list = new ArrayList();
         for (UserRatesUser entity : entities) {
            CriticCreationUserForUserDTO critic = toDTOuser(entity);
            list.add(critic);
        }

        return list;
    }

   
}
