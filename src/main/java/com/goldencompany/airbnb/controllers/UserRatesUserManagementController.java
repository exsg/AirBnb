/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationDTO;
import com.goldencompany.airbnb.dto.input.CriticCreationUserForUserDTO;
import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.dto.output.UserRatesUserDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Critic;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.UserRatesUser;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.BookingMapper;
import com.goldencompany.airbnb.mappers.CriticMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.MessageMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.mappers.UserRatesUserMapper;
import com.goldencompany.airbnb.repositories.BookingRepository;
import com.goldencompany.airbnb.repositories.CriticRepository;
import com.goldencompany.airbnb.repositories.CriticUserForUserRepository;
import com.goldencompany.airbnb.repositories.ListingRepository;
import com.goldencompany.airbnb.repositories.MessageRepository;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class UserRatesUserManagementController {

    @Inject
    UserRepository userRepository;

//    @Inject
//    UserMapper userMapper;
//
//    @Inject
//    BookingRepository bookingRepository;
//
//    @Inject
//    BookingMapper bookingMapper;
//
//    @Inject
//    ListingMapper listingMapper;
//
    @Inject
    ListingRepository listingRepository;
    @Inject
    UserRatesUserMapper userRatesUserMapper;

//    @Inject
//    CriticUserForUserRepository criticUserForUserRepository;
    @Inject
    CriticUserForUserRepository userRatesUserRepository;

//    @Inject
//    CriticRepository criticRepository;

    public UserRatesUserDTO createCriticUserForUser(CriticCreationUserForUserDTO input) throws BaseValidationException {
        List<User> users = userRepository.find(input.getUserRater());
        List errors = new ArrayList();
        if (users.isEmpty()) {
            errors.add("createCritic : This Rater User Does not Exist");
            throw new BaseValidationException(errors);
        }

        List<User> users2 = userRepository.find(input.getUserRated());
        if (users2.isEmpty()) {
            errors.add("createCritic : The User you're trying to rate Does not Exist");
            throw new BaseValidationException(errors);
        }

        UserRatesUser thisCritic = userRatesUserMapper.toEntity(input, users.get(0), users2.get(0));
        UserRatesUserDTO dto = userRatesUserMapper.toDTO(thisCritic);
        userRatesUserRepository.create(thisCritic);

        return dto;
    }

//    public List<CriticCreationUserForUserDTO> retrieveAllForUser() {
//        List<UserRatesUser> dtos = new ArrayList();
//        dtos = criticUserForUserRepository.retrieveAllCritics();
//        List UserRatings = new ArrayList();
//        UserRatings = criticMapper.toDTOuser(dtos);
//        return UserRatings;
//
//    }
    
    
        public List<UserRatesUserDTO> retrieveAllUserRatesUser() {
       List <UserRatesUser> entities= new ArrayList();
       entities = userRatesUserRepository.retrieveAllCritics();
       List <UserRatesUserDTO> dtos= new ArrayList();
       dtos = userRatesUserMapper.toDTO(entities);
       return dtos;
       
    }
//
    public List<UserRatesUserDTO> retrieveByRaterId(Integer id) throws BaseValidationException {

        List<UserRatesUser> entities = new ArrayList();
        entities = userRatesUserRepository.retrieveCriticsByRaterId(id);
        List<UserRatesUserDTO> dtos = new ArrayList();
        dtos = userRatesUserMapper.toDTO(entities);
        
        return dtos;
    }



    public List<UserRatesUserDTO> retrieveByRatedId(Integer id)  throws BaseValidationException {

        List<UserRatesUser> entities = new ArrayList();
//        User user = userRepository()
        entities = userRatesUserRepository.retrieveCriticsByRatedId(id);
        List<UserRatesUserDTO> dtos = new ArrayList();
        dtos = userRatesUserMapper.toDTO(entities);
        
        return dtos;
    }

}
