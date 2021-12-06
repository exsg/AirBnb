/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers;

import com.goldencompany.airbnb.dto.input.MessageCreationDTO;
import com.goldencompany.airbnb.dto.output.MessageDTO;
import com.goldencompany.airbnb.entity.Booking;
import com.goldencompany.airbnb.entity.Message;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.MessageMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.BookingRepository;
import com.goldencompany.airbnb.repositories.MessageRepository;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class MessageManagementController {

    @Inject
    MessageRepository messageRepository;

    @Inject
    MessageMapper messageMapper;

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    BookingRepository bookingRepository;

    public List retrieveReceivedMessageByUserID(Integer id) {
        List<Message> messages = messageRepository.findReceivedByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }

    public List retrieveSentMessageByUserID(Integer id) {
        List<Message> messages = messageRepository.findSentByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }

    //edw
    public List retrieveMessageDetailsByID(Integer id) {
        List<Message> messages = messageRepository.findDetailsByID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }

//        public List retrieveAllMessageByUserID(Integer id) {
//        List<Message> messages = messageRepository.retrieveAllMessagesByUserID(id);
//
//        List dtos = messageMapper.toDTO(messages);
//
//        return dtos;
//    }    
//    public List findDetailsByID(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public List retrieveAllMessagesByUserID(Integer id) {
        List<Message> messages = messageRepository.findByUserID(id);

        List dtos = messageMapper.toDTO(messages);

        return dtos;
    }

    public MessageCreationDTO sendMessage(MessageCreationDTO dto) {
//        
//        List<User> users = userRepository.find(id);
//User<List> receiver = userRepository.find(dto.getReceiver());
        List<User> users = userRepository.find(dto.getReceiver());
        User receiver = users.get(0);
        List<User> users2 = userRepository.find(dto.getSender());
        User sender = users2.get(0);

        //na valw booking sto to entity san orisma
        if (dto.getBookingId() != null) {
            List<Booking> bookings = bookingRepository.findByBookingID(dto.getBookingId());
            Booking booking = bookings.get(0);
            Message rofl = messageMapper.toEntity(dto, sender, receiver, booking);
            messageRepository.create(rofl);
        } else {
            Message rofl = messageMapper.toEntity(dto, sender, receiver, null);
            messageRepository.create(rofl);
        }
        

        

        return dto;
    }

    public MessageDTO deleteMessage(Integer id) throws UserValidationException {
        List<Message> messages = messageRepository.findDetailsByID(id);
        List errors = new ArrayList();

        if (messages.isEmpty()) {
            errors.add("message does not exist");
            throw new UserValidationException(errors);
        }
        Message thisMessage = messages.get(0);

        if (thisMessage.getActive() == 1) {
            thisMessage.setActive(0);

            thisMessage = messageRepository.update(thisMessage);

            List dtos = messageMapper.toDTO(messages);
            MessageDTO returnMessage = (MessageDTO) dtos.get(0);

//            MessageDTO dtos = messageMapper.toDTO(thisMessage);
            return returnMessage;
        } else {
            errors.add("this message is already deleted");
            throw new UserValidationException(errors);
        }
    }

    public MessageDTO undeleteMessage(Integer id) throws UserValidationException {
        List<Message> messages = messageRepository.findDetailsByID(id);
        List errors = new ArrayList();

        if (messages.isEmpty()) {
            errors.add("message does not exist");
            throw new UserValidationException(errors);
        }
        Message thisMessage = messages.get(0);

        if (thisMessage.getActive() == 0) {
            thisMessage.setActive(1);

            thisMessage = messageRepository.update(thisMessage);

            List dtos = messageMapper.toDTO(messages);
            MessageDTO returnMessage = (MessageDTO) dtos.get(0);

//            MessageDTO dtos = messageMapper.toDTO(thisMessage);
            return returnMessage;
        } else {
            errors.add("this message is not deleted so it cannot be undeleted");
            throw new UserValidationException(errors);
        }
    }

}
