/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.mappers;

import com.goldencompany.airbnb.dto.input.ListingCreationDTO;
import com.goldencompany.airbnb.dto.input.ListingUpdateDTO;
import com.goldencompany.airbnb.dto.input.RegisterDTO;
import com.goldencompany.airbnb.dto.output.AmenityDTO;
import com.goldencompany.airbnb.entity.Amenity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class AmenityMapper {

    public AmenityDTO toDTO(Amenity entity) {
        AmenityDTO dto = new AmenityDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

//    public List<Amenity> toEntities(RegisterDTO dto) {
//         List<Amenity> amenityList = new ArrayList();
//        
//        if (dto.isIs_host()) {
//            Amenity r = new Amenity();
//            r.setId(1);
//            amenityList.add(r);
//        }
//        
//        
//        if (dto.isIs_customer()) {
//            Amenity r = new Amenity();
//            r.setId(2);
//            amenityList.add(r);
//        }
//        
//        return amenityList;
//        
//    }
    public List<Amenity> toEntities(ListingUpdateDTO dto) {
        List<Amenity> amenityList = new ArrayList();

        if (dto.isHasWifi()) {
            Amenity r = new Amenity();
            r.setId(1);
            amenityList.add(r);
        }
        if (dto.isHasKitchen()) {
            Amenity r = new Amenity();
            r.setId(2);
            amenityList.add(r);
        }

        if (dto.isHasTv()) {
            Amenity r = new Amenity();
            r.setId(3);
            amenityList.add(r);
        }

        if (dto.isHasParking()) {
            Amenity r = new Amenity();
            r.setId(4);
            amenityList.add(r);
        }
        if (dto.isHasElevator()) {
            Amenity r = new Amenity();
            r.setId(5);
            amenityList.add(r);
        }

        if (dto.isHasAirCondition()) {
            Amenity r = new Amenity();
            r.setId(6);
            amenityList.add(r);
        }

        if (dto.isHasHeating()) {
            Amenity r = new Amenity();
            r.setId(7);
            amenityList.add(r);
        }
        if (dto.isHasLivingRoom()) {
            Amenity r = new Amenity();
            r.setId(8);
            amenityList.add(r);
        }

        return amenityList;

    }
    
     public List<Amenity> toEntities(ListingCreationDTO dto) {
        List<Amenity> amenityList = new ArrayList();

        if (dto.isHasWifi()) {
            Amenity r = new Amenity();
            r.setId(1);
            amenityList.add(r);
        }
        if (dto.isHasKitchen()) {
            Amenity r = new Amenity();
            r.setId(2);
            amenityList.add(r);
        }

        if (dto.isHasTv()) {
            Amenity r = new Amenity();
            r.setId(3);
            amenityList.add(r);
        }

        if (dto.isHasParking()) {
            Amenity r = new Amenity();
            r.setId(4);
            amenityList.add(r);
        }
        if (dto.isHasElevator()) {
            Amenity r = new Amenity();
            r.setId(5);
            amenityList.add(r);
        }

        if (dto.isHasAirCondition()) {
            Amenity r = new Amenity();
            r.setId(6);
            amenityList.add(r);
        }

        if (dto.isHasHeating()) {
            Amenity r = new Amenity();
            r.setId(7);
            amenityList.add(r);
        }
        if (dto.isHasLivingRoom()) {
            Amenity r = new Amenity();
            r.setId(8);
            amenityList.add(r);
        }

        return amenityList;

    }
}
