/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.output.TypeDTO;
import com.goldencompany.airbnb.entity.Type;
import com.goldencompany.airbnb.exceptions.BaseValidationException;

/**
 *
 * @author george
 */
public class TypeMapper {
     public TypeDTO toDTO(Type entity){
         TypeDTO dto = new TypeDTO();
         
         dto.setId(entity.getId());
         dto.setName(entity.getName());
         
         return dto;
     }

    public Type toEntity(ListingCreationDTO input) throws BaseValidationException{
        Type type = new Type();
        
        
        type.setId(input.getTypeId());
        
        switch(input.getTypeId()) {
            case 0:
                type.setName("entire");
                break;
            case 1:
                type.setName("private");
                break;
            case 2:
                type.setName("shared");
                break;
            default:
                throw new BaseValidationException("Invalid typeid: " + input.getTypeId());
                
        }
        
        return type;
    }          
}
