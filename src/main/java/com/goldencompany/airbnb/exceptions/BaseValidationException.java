/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class BaseValidationException extends Exception {
    private List errors;

    public BaseValidationException(List errors) {
        this.errors = errors;
    }
    
    public BaseValidationException(String error) {
        errors = new ArrayList();
        errors.add(error);
    }

    public List getErrors() {
        return errors;
    }

    public void setErrors(List errors) {
        this.errors = errors;
    }
    
    
    
    
    
}
