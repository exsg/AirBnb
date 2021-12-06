package com.goldencompany.airbnb.resources.account;

import com.goldencompany.airbnb.auth.AuthController;
import com.goldencompany.airbnb.controllers.AccountManagementController;
import com.goldencompany.airbnb.dto.input.LoginDTO;
import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.SessionDataDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import com.goldencompany.airbnb.entity.User;
import com.goldencompany.airbnb.exceptions.UserValidationException;
import com.goldencompany.airbnb.mappers.UserMapper;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
//| /api/admin/account/active | GET | - | all active accounts
//| /api/admin/account/inactive | GET | - | all inactive accounts
//| /api/admin/account/activate/:id | POST | - | success / fail
//| /api/admin/account/deactivate/:id | POST | - | success / fail
@Path("/account")
public class AccountResource {

    @Inject
    AccountManagementController controller;
    
    @Inject
    UserMapper userMapper;

    @POST
    @Path("/register")
    public Response register(RegisterDTO input) {
        try {
            List user = controller.createUser(input);
            return Response.ok(user).build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }
        
    }
    
    @POST
    @Path("/login")
    public Response login(LoginDTO input) {
        try {
            User user = controller.loginUser(input);
            
            UserDTO dto = userMapper.toDTO(user);
            
            String token = AuthController.issueToken(user);
            
            SessionDataDTO data = new SessionDataDTO();
            
            data.setUser(dto);
            data.setToken(token);
            
            return Response.ok(data).build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.UNAUTHORIZED).build();
        }
        
    }
    
    @POST
    @Path("/edit/{id}")//na valoyme id path param
    public Response edit(@PathParam("id") Integer id,  RegisterDTO input) {
        try {
            List user = controller.editUser(id ,input);
            return Response.ok(user).build();
        } catch (UserValidationException ex) {
            return Response.ok(ex.getErrors()).status(Response.Status.NOT_ACCEPTABLE).build();
        }

        
        
    }
    //peiramata
    @GET    
    @Path("{id}")
    public Response id(@PathParam("id") Integer id){     
//        List user = controller.retrieveUserByID(id);        
        if(id==1){
        return Response
                .ok("id = 1")
                .build();
        }else{
            return Response
                .ok("id = something else")
                .build();
        }
    }
    
    @GET
    @Path("/view/{id}")
    public Response view(@PathParam("id") Integer id){
        List user = controller.viewUserByID(id);

        return Response
                .ok(user)
                .build();
        }
    
        
 }
