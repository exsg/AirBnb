/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.output;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author george
 */

        

public class SessionDataDTO {
    private UserDTO user;
    private String token;

    public SessionDataDTO() {
    }
    
    

    public SessionDataDTO(UserDTO user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
    
    
  
}
