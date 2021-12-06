/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.exceptions;

import java.util.List;

/**
 *
 * @author george
 */
public class UserValidationException extends BaseValidationException {

    public UserValidationException(List errors) {
        super(errors);
    }

    public UserValidationException(String error) {
        super(error);
    }
    
    
    
}
