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
import com.goldencompany.airbnb.dto.output.UserRatesUserDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.UserRatesUser;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class UserRatesUserMapper {

    @Inject
    UserMapper userMapper;

//    @Inject
//    UserRepository userRepository;
//    @Inject
//    ListingMapper listingMapper;
//    
    public UserRatesUserDTO toDTO(UserRatesUser entity) {
        UserRatesUserDTO dto = new UserRatesUserDTO();

        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setRating(entity.getRating());
        dto.setDate(entity.getDate());
        
        
        UserDTO user1DTO = userMapper.toDTO(entity.getUserId1());
        UserDTO user2DTO = userMapper.toDTO(entity.getUserId2());

        dto.setUserId1(user1DTO);
        dto.setUserId2(user2DTO);
        

//       

        return dto;
    }

    public List toDTO(List<UserRatesUser> entities) {
        List list = new ArrayList();

        for (UserRatesUser entity : entities) {
            UserRatesUserDTO critic = toDTO(entity);
            list.add(critic);
        }

        return list;
    }
    
    public UserRatesUser toEntity(CriticCreationUserForUserDTO input, User user1, User user2) {
        UserRatesUser thisCritic = new UserRatesUser();
        thisCritic.setDate(new Date());
        thisCritic.setUserId1(user1);
        thisCritic.setUserId2(user2);
        thisCritic.setText(input.getText());
        thisCritic.setRating(input.getRating());
        return thisCritic;
    }

//    public Critic toEntity(CriticCreationDTO input, User user, Listing listing) {
//        Critic thisCritic = new Critic();
//        thisCritic.setDate(new Date());
//        thisCritic.setListingId(listing);
//        thisCritic.setUserId(user);
//        thisCritic.setText(input.getText());
//        return thisCritic;
//    }
//
//    //epeidh einai kai ayto ena critic alla se user anti gia listing, protimw na to valw edw anti na ftia3w kainourio mapper
//    public UserRatesUser toEntity(CriticCreationUserForUserDTO input, User user1, User user2) {
//        UserRatesUser thisCritic = new UserRatesUser();
//        thisCritic.setDate(new Date());
//        thisCritic.setUserId1(user1);
//        thisCritic.setUserId2(user2);
//        thisCritic.setText(input.getText());
//        thisCritic.setRating(input.getRating());
//        return thisCritic;
//    }
//
//    public CriticCreationUserForUserDTO toDTOuser(UserRatesUser entity) {
//        CriticCreationUserForUserDTO dto = new CriticCreationUserForUserDTO();
//        dto.setRating(entity.getRating());
//        dto.setText(entity.getText());
//        dto.setUserRater(entity.getUserId1().getId());
//        dto.setUserRated(entity.getUserId2().getId());
//        return dto;
//    }
//
//    public List<CriticCreationUserForUserDTO> toDTOuser(List<UserRatesUser> entities) {
//        List list = new ArrayList();
//        for (UserRatesUser entity : entities) {
//            CriticCreationUserForUserDTO critic = toDTOuser(entity);
//            list.add(critic);
//        }
//
//        return list;
//    }

}
