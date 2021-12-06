/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import com.goldencompany.airbnb.dto.output.AmenityDTO;
import com.goldencompany.airbnb.dto.output.RuleDTO;
import com.goldencompany.airbnb.dto.output.TypeDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class ListingCreationDTO {

    private double geolocation_lat;
    private double geolocation_long;
    private String country;
    private int bedroom_num;
    private String city;
    private String district;
    private int floor;
    private int maxPeople;

    private int bedNum;
    private int bathroomNum;
    private String description;
    private int sqrMeters;

    private int minDays;
    private int active;
    private int extraCostPerPerson;
    private int typeId;
    private String friendlyName;

    private int userId;
    private boolean hasWifi;
    //wifi
    //kitchen
    private boolean hasKitchen;
    private boolean hasTv;
    //tv
    //parking
    private boolean hasParking;
    //elevator
    private boolean hasElevator;
    private boolean hasHeating;
    //livingroom
    private boolean hasLivingRoom;
    
    private boolean hasAirCondition;

    //rules boolean Variables                
//    private List<RuleDTO> rules = new ArrayList<>();
    //pet
    private boolean hasPet;
    //event
    private boolean hasEvent;
    //smoking
    private boolean hasSmoking;
    
    private String photo_url;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
    

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

   



    public boolean isHasAirCondition() {
        return hasAirCondition;
    }

    public void setHasAirCondition(boolean hasAirCondition) {
        this.hasAirCondition = hasAirCondition;
    }
    
    

    public int getSqrMeters() {
        return sqrMeters;
    }

    public void setSqrMeters(int sqrMeters) {
        this.sqrMeters = sqrMeters;
    }

    public double getGeolocation_lat() {
        return geolocation_lat;
    }

    public void setGeolocation_lat(double geolocation_lat) {
        this.geolocation_lat = geolocation_lat;
    }

    public double getGeolocation_long() {
        return geolocation_long;
    }

    public void setGeolocation_long(double geolocation_long) {
        this.geolocation_long = geolocation_long;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBedroom_num() {
        return bedroom_num;
    }

    public void setBedroom_num(int bedroom_num) {
        this.bedroom_num = bedroom_num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public int getBathroomNum() {
        return bathroomNum;
    }

    public void setBathroomNum(int bathroomNum) {
        this.bathroomNum = bathroomNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getExtraCostPerPerson() {
        return extraCostPerPerson;
    }

    public void setExtraCostPerPerson(int extraCostPerPerson) {
        this.extraCostPerPerson = extraCostPerPerson;
    }
   
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    public boolean isHasTv() {
        return hasTv;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public boolean isHasHeating() {
        return hasHeating;
    }

    public void setHasHeating(boolean hasHeating) {
        this.hasHeating = hasHeating;
    }

    public boolean isHasLivingRoom() {
        return hasLivingRoom;
    }

    public void setHasLivingRoom(boolean hasLivingRoom) {
        this.hasLivingRoom = hasLivingRoom;
    }

    public boolean isHasPet() {
        return hasPet;
    }

    public void setHasPet(boolean hasPet) {
        this.hasPet = hasPet;
    }

    public boolean isHasEvent() {
        return hasEvent;
    }

    public void setHasEvent(boolean hasEvent) {
        this.hasEvent = hasEvent;
    }

    public boolean isHasSmoking() {
        return hasSmoking;
    }

    public void setHasSmoking(boolean hasSmoking) {
        this.hasSmoking = hasSmoking;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    
    

}
