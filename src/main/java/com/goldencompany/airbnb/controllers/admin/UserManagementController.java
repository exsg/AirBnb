/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.controllers.admin;

import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.entity.constants.UserConstants;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.RoleMapper;
import com.goldencompany.airbnb.mappers.UserMapper;
import com.goldencompany.airbnb.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author george
 */
public class UserManagementController {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Inject
    RoleMapper roleMapper;

    public List retrieveUsers() {
        List<User> users = userRepository.findAll();

        List dtos = userMapper.toDTO(users);

        return dtos;
    }

    public List retrieveUserByID(Integer id) {
        List<User> users = userRepository.find(id);

        List dtos = userMapper.toDTO(users);

        return dtos;
    }

    public List retrieveActiveUsers() {
        List<User> users = userRepository.findActive();

        List dtos = userMapper.toDTO(users);

        return dtos;
    }

    public List retrieveInactiveUsers() {
        List<User> users = userRepository.findInactive();

        List dtos = userMapper.toDTO(users);

        return dtos;
    }

    public List retrieveUsersByStatus(int registrationStatus) {
        List<User> users = userRepository.findApproved(registrationStatus);

        List dtos = userMapper.toDTO(users);

        return dtos;
    }

    public List approveUser(Integer id) throws UserValidationException {
        List<User> users = userRepository.find(id);
        List errors = new ArrayList();

        if (users.isEmpty()) {
            errors.add("user does not exist");
            throw new UserValidationException(errors);
        }
        User thisUser = users.get(0);

        if (thisUser.getRegistrationStatus() == UserConstants.PENDING) {
            thisUser.setRegistrationStatus(UserConstants.APPROVED);

            users = userRepository.update(thisUser);

            List dtos = userMapper.toDTO(users);

            return dtos;
        } else {
            errors.add("user is approved or rejected");
            throw new UserValidationException(errors);
        }
    }

    public List rejectUser(Integer id) throws UserValidationException {
        List<User> users = userRepository.find(id);
        List errors = new ArrayList();

        if (users.isEmpty()) {
            errors.add("user does not exist");
            throw new UserValidationException(errors);
        }
        User thisUser = users.get(0);

        if (thisUser.getRegistrationStatus() == UserConstants.PENDING) {
            thisUser.setRegistrationStatus(UserConstants.REJECTED);

            users = userRepository.update(thisUser);

            List dtos = userMapper.toDTO(users);

            return dtos;
        } else {
            errors.add("user is approved or already rejected"); // exei nohma na kanome reject kapoion p einai approved?
            throw new UserValidationException(errors);
        }
    }

    public List rejectApprovedUser(Integer id) throws UserValidationException {
        List<User> users = userRepository.find(id);
        List errors = new ArrayList();

        if (users.isEmpty()) {
            errors.add("user does not exist");
            throw new UserValidationException(errors);
        }
        User thisUser = users.get(0);

        if (thisUser.getRegistrationStatus() == UserConstants.APPROVED) {
            thisUser.setRegistrationStatus(UserConstants.REJECTED);

            users = userRepository.update(thisUser);

            List dtos = userMapper.toDTO(users);

            return dtos;
        } else {
            errors.add("this user is already rejected or pending"); // exei nohma na kanome reject kapoion p einai approved?
            throw new UserValidationException(errors);
        }
    }

    public List approveRejectedUser(Integer id) throws UserValidationException {
        List<User> users = userRepository.find(id);
        List errors = new ArrayList();

        if (users.isEmpty()) {
            errors.add("user does not exist");
            throw new UserValidationException(errors);
        }
        User thisUser = users.get(0);

        if (thisUser.getRegistrationStatus() == UserConstants.REJECTED) {
            thisUser.setRegistrationStatus(UserConstants.APPROVED);

            users = userRepository.update(thisUser);

            List dtos = userMapper.toDTO(users);

            return dtos;
        } else {
            errors.add("this user is already Approved or pending"); // exei nohma na kanome reject kapoion p einai approved?
            throw new UserValidationException(errors);
        }
    }

}
