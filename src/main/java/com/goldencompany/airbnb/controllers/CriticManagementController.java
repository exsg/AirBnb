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
public class CriticManagementController {

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
    CriticMapper criticMapper;

    @Inject
    CriticUserForUserRepository criticUserForUserRepository;

    @Inject
    CriticRepository criticRepository;

    public List retrieveAllCritics() {
        List<Critic> critics = criticRepository.retrieveAllCritics();

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public List retrieveCriticsByCriticId(Integer id) throws BaseValidationException {
        List<Critic> critics = criticRepository.retrieveCriticsByCriticId(id);
        List errors = new ArrayList();

        if (critics.isEmpty()) {
            errors.add("Critic with such id does not exist");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public List retrieveCriticsByUserId(Integer id) throws BaseValidationException {

        List<User> users = userRepository.find(id);

        List errors = new ArrayList();
        if (users.isEmpty()) {
            errors.add("retrieveCriticsByUserId : User with such id does not exist ");
            throw new BaseValidationException(errors);
        }

        List<Critic> critics = criticRepository.retrieveCriticsByUserId(id);
        if (critics.isEmpty()) {
            errors.add("User hasn't made any critic(s) yet");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public List retrieveCriticsByListingId(Integer id) throws BaseValidationException {
        List<Listing> listings = listingRepository.find(id);

        List errors = new ArrayList();
        if (listings.isEmpty()) {
            errors.add("retrieveCriticsByUserId : listing with such id does not exist ");
            throw new BaseValidationException(errors);
        }

        List<Critic> critics = criticRepository.retrieveCriticsByListingId(id);
        if (critics.isEmpty()) {
            errors.add("This Listing doesn't have any critic(s) yet");
            throw new BaseValidationException(errors);
        }

        List dtos = criticMapper.toDTO(critics);

        return dtos;
    }

    public CriticCreationDTO createCritic(CriticCreationDTO input) throws BaseValidationException {
        List<User> users = userRepository.find(input.getUserId());
        List errors = new ArrayList();
        if (users.isEmpty()) {
            errors.add("createCritic : This User Does not Exist");
            throw new BaseValidationException(errors);
        }

        List<Listing> listings = listingRepository.find(input.getListingId());
        if (listings.isEmpty()) {
            errors.add("createCritic : This Listing Does not Exist");
            throw new BaseValidationException(errors);
        }

        Critic thisCritic = criticMapper.toEntity(input, users.get(0), listings.get(0));
//
        criticRepository.create(thisCritic);
//
//        return dto;

        return input;
    }

    public CriticCreationUserForUserDTO createCriticUserForUser(CriticCreationUserForUserDTO input) throws BaseValidationException {
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

        UserRatesUser thisCritic = criticMapper.toEntity(input, users.get(0), users2.get(0));
        criticRepository.create(thisCritic);

        return input;
    }

    public List<CriticCreationUserForUserDTO> retrieveAllForUser() {
        List<UserRatesUser> dtos = new ArrayList();
        dtos = criticUserForUserRepository.retrieveAllCritics();
        List UserRatings = new ArrayList();
        UserRatings = criticMapper.toDTOuser(dtos);
        return UserRatings;

    }

//    public List<CriticCreationUserForUserDTO> retrieveByRaterId(Integer id) throws BaseValidationException {
//
//        List<UserRatesUser> entities = new ArrayList();
//        entities = criticUserForUserRepository.retrieveCriticsByRaterId(id);
//        List UserRatings = new ArrayList();
//        UserRatings = UserMapper.toDTOuser(entities);
//        return UserRatings;
//    }

}
