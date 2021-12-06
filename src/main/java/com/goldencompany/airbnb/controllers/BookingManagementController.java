/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.dto.input.BookingCreationDTO;
import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.BookingDTO;
import com.goldencompany.airbnb.dto.output.ListingDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Listing;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.BaseValidationException;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.BookingMapper;
import com.goldencompany.airbnb.mappers.ListingMapper;
import com.goldencompany.airbnb.mappers.MessageMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.BookingRepository;
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
public class BookingManagementController {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    BookingRepository bookingRepository;

    @Inject
    BookingMapper bookingMapper;

    @Inject
    ListingMapper listingMapper;

    @Inject
    ListingRepository listingRepository;

    public List retrieveAllBookings() {
        List<Booking> bookings = bookingRepository.retrieveAllBookings();

        List dtos = bookingMapper.toDTO(bookings);

        return dtos;
    }

    public List retrieveBookingsByUserID(Integer id) {
        List<Booking> bookings = bookingRepository.retrieveAllBookingsByUserId(id);

        List dtos = bookingMapper.toDTO(bookings);

        return dtos;
    }

//    public List retrieveSentMessageByUserID(Integer id) {
//        List<Message> messages = messageRepository.findSentByUserID(id);
//
//        List dtos = messageMapper.toDTO(messages);
//
//        return dtos;
//    }
//
//    //edw
//    public List retrieveMessageDetailsByID(Integer id) {
//        List<Message> messages = messageRepository.findDetailsByID(id);
//
//        List dtos = messageMapper.toDTO(messages);
//
//        return dtos;
//    }
//
////        public List retrieveAllMessageByUserID(Integer id) {
////        List<Message> messages = messageRepository.retrieveAllMessagesByUserID(id);
////
////        List dtos = messageMapper.toDTO(messages);
////
////        return dtos;
////    }    
////    public List findDetailsByID(Integer id) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
//    public List retrieveAllMessagesByUserID(Integer id) {
//        List<Message> messages = messageRepository.findByUserID(id);
//
//        List dtos = messageMapper.toDTO(messages);
//
//        return dtos;
//    }
//
//    public MessageCreationDTO sendMessage(MessageCreationDTO dto) {
////        
////        List<User> users = userRepository.find(id);
////User<List> receiver = userRepository.find(dto.getReceiver());
//        List<User> users = userRepository.find(dto.getReceiver());
//        User receiver = users.get(0);
//        List<User> users2 = userRepository.find(dto.getSender());
//        User sender = users2.get(0);
//
//        //na valw booking sto to entity san orisma
//        List<Booking> bookings = bookingRepository.findByBookingID(dto.getBookingId());
//        Booking booking = bookings.get(0);
//        Message rofl = messageMapper.toEntity(dto, sender, receiver, booking);
//
//        messageRepository.create(rofl);
//
//        return dto;
//    }
//
//    public MessageDTO deleteMessage(Integer id) throws UserValidationException {
//        List<Message> messages = messageRepository.findDetailsByID(id);
//        List errors = new ArrayList();
//
//        if (messages.isEmpty()) {
//            errors.add("message does not exist");
//            throw new UserValidationException(errors);
//        }
//        Message thisMessage = messages.get(0);
//
//        if (thisMessage.getActive() == 1) {
//            thisMessage.setActive(0);
//
//            thisMessage = messageRepository.update(thisMessage);
//
//            List dtos = messageMapper.toDTO(messages);
//            MessageDTO returnMessage = (MessageDTO) dtos.get(0);
//
////            MessageDTO dtos = messageMapper.toDTO(thisMessage);
//            return returnMessage;
//        } else {
//            errors.add("this message is already deleted");
//            throw new UserValidationException(errors);
//        }
//    }
//
//    public MessageDTO undeleteMessage(Integer id) throws UserValidationException {
//        List<Message> messages = messageRepository.findDetailsByID(id);
//        List errors = new ArrayList();
//
//        if (messages.isEmpty()) {
//            errors.add("message does not exist");
//            throw new UserValidationException(errors);
//        }
//        Message thisMessage = messages.get(0);
//
//        if (thisMessage.getActive() == 0) {
//            thisMessage.setActive(1);
//
//            thisMessage = messageRepository.update(thisMessage);
//
//            List dtos = messageMapper.toDTO(messages);
//            MessageDTO returnMessage = (MessageDTO) dtos.get(0);
//
////            MessageDTO dtos = messageMapper.toDTO(thisMessage);
//            return returnMessage;
//        } else {
//            errors.add("this message is not deleted so it cannot be undeleted");
//            throw new UserValidationException(errors);
//        }
//    }
    public BookingCreationDTO createBooking(BookingCreationDTO input) {
        List<User> users = userRepository.find(input.getUserId());
        List<Listing> listings = listingRepository.find(input.getListingId());
        Booking thisBooking = bookingMapper.toEntity(input, users.get(0), listings.get(0));
//
        bookingRepository.create(thisBooking);
//
//        return dto;

        return input;

    }

    public List retrieveBookingsByListingId(Integer id) {
        List<Booking> bookings = bookingRepository.retrieveAllBookingsByListingId(id);

        List dtos = bookingMapper.toDTO(bookings);

        return dtos;
    }

    public BookingDTO acceptPendingBooking(Integer id) throws UserValidationException {
        List<Booking> bookings = bookingRepository.findByBookingID(id);
        Booking thisBooking = new Booking();
        List errors = new ArrayList();

        if (!bookings.isEmpty()) {
            thisBooking = bookings.get(0);
        } else {
            //throw error message 
            errors.add("This Booking does not exist");
//            return new BookingDTO();
            throw new UserValidationException(errors);
        }

        if (thisBooking.getBookingStatus() != 0) {
            errors.add("Booking exists but is already accepted or rejected");
            throw new UserValidationException(errors);
        }

        thisBooking.setBookingStatus(1);
        bookingRepository.update(thisBooking);
        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
        return returnBooking;
    }

    public BookingDTO rejectPendingBooking(Integer id) throws UserValidationException {
        List<Booking> bookings = bookingRepository.findByBookingID(id);
        List errors = new ArrayList();

        Booking thisBooking = new Booking();
        if (!bookings.isEmpty()) {
            thisBooking = bookings.get(0);
        } else {
            //throw error message 
            errors.add("This Booking does not exist");
//            return new BookingDTO();
            throw new UserValidationException(errors);
        }

        if (thisBooking.getBookingStatus() != 0) {
            errors.add("Booking exists but is already accepted or rejected");
            throw new UserValidationException(errors);
        }

        thisBooking.setBookingStatus(2);
        bookingRepository.update(thisBooking);
        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
        return returnBooking;
    }

    public BookingDTO makeBookingPending(Integer id) throws UserValidationException {
        List<Booking> bookings = bookingRepository.findByBookingID(id);
        List errors = new ArrayList();

        Booking thisBooking = new Booking();
        if (!bookings.isEmpty()) {
            thisBooking = bookings.get(0);
        } else {
            //throw error message 
            errors.add("make Booking Pending :This Booking does not exist");
//            return new BookingDTO();
            throw new UserValidationException(errors);
        }

        if (thisBooking.getBookingStatus() == 0) {
            errors.add("make Booking Pending : Booking exists but is already pending");
            throw new UserValidationException(errors);
        }

        thisBooking.setBookingStatus(0);
        bookingRepository.update(thisBooking);
        BookingDTO returnBooking = bookingMapper.toDTO(thisBooking);
        return returnBooking;
    }

    public List retrieveListingsWithPendingBookingByUserId(Integer id) throws BaseValidationException {
        List errors = new ArrayList();
        List<Booking> bookings = new ArrayList();
        List bookingz = new ArrayList();
//        errors.add("Not supported yet.");
        List<User> UserList = userRepository.find(id);
//        User thisUser= UserList.get(0);
        if (UserList.isEmpty()) {
            errors.add("this user does not exist");
            throw new BaseValidationException(errors); //To change body of generated methods, choose Tools | Templates.

        } else {

            List<Listing> listings = new ArrayList();

//            bookings = bookingRepository.findByUserIDAndActive(id);
            bookings = bookingRepository.findByUserIDAndPending(id);
            if(bookings.isEmpty()){
                return new ArrayList();
            }else{
            for (Booking b : bookings) {
                listings.add(b.getListingId());
            }
               List<ListingDTO> listingsDTO= listingMapper.toDTO(listings);

            bookingz = bookingMapper.toDTO(bookings);
            return listingsDTO;
//            return bookingz;
            }
        }

    }

}
