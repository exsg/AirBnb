/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.RoleDTO;
import com.goldencompany.airbnb.entity.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class RoleMapper {
     public RoleDTO toDTO(Role entity){
         RoleDTO dto = new RoleDTO();
         
         dto.setId(entity.getId());
         dto.setName(entity.getName());
         
         return dto;
     }

    public List<Role> toEntities(RegisterDTO dto) {
         List<Role> roleList = new ArrayList();
        
        if (dto.isIs_host()) {
            Role r = new Role();
            r.setId(1);
            roleList.add(r);
        }
        
        
        if (dto.isIs_customer()) {
            Role r = new Role();
            r.setId(2);
            roleList.add(r);
        }
        
        return roleList;
        
    }
}
