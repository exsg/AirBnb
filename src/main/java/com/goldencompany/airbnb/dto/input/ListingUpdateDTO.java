/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.input;

import com.goldencompany.airbnb.dto.output.AmenityDTO;
import com.goldencompany.airbnb.dto.output.PhotoDTO;
import com.goldencompany.airbnb.dto.output.RuleDTO;
import com.goldencompany.airbnb.dto.output.TypeDTO;
import com.goldencompany.airbnb.dto.output.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author george
 */
public class ListingUpdateDTO {

    private int bedroom_num;
    private int maxPeople;

    private int bedNum;
    private int bathroomNum;
    private String description;

    private int minDays;
    private int active;
    private int extraCostPerPerson;
//    private TypeDTO type;

    //Amenity integer variables where 0 means set to no , 1 means set to yes , maybe null means no change.
//    private List<AmenityDTO> amenities = new ArrayList<>();
    private boolean hasWifi;
    //////
    private double geolocationLatitude;
    private double geolocationLongitude;
    private String city;
    private String country;
    private String district;
    private String friendlyName;
    private int floor;
    private int sqrMeters;
    private List<PhotoDTO> photos;
    //mhn ksexaseis to cost
    
    /////
//wifi
    //kitchen
    private boolean hasKitchen;
    private boolean hasAirCondition;
    //heating
    private boolean hasHeating;
    //livingroom
    private boolean hasLivingRoom;

    //rules boolean Variables                
//    private List<RuleDTO> rules = new ArrayList<>();
    //pet
    private boolean hasPet;
    //event
    private boolean hasEvent;
    //smoking
    private boolean hasSmoking;
    private boolean hasTv;
    //tv
    //parking
    private boolean hasParking;
    //elevator
    private boolean hasElevator;
    private int cost;

    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }
 
    public double getGeolocationLatitude() {
        return geolocationLatitude;
    }

    public void setGeolocationLatitude(double geolocationLatitude) {
        this.geolocationLatitude = geolocationLatitude;
    }

    public double getGeolocationLongitude() {
        return geolocationLongitude;
    }

    public void setGeolocationLongitude(double geolocationLongitude) {
        this.geolocationLongitude = geolocationLongitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSqrMeters() {
        return sqrMeters;
    }

    public void setSqrMeters(int sqrMeters) {
        this.sqrMeters = sqrMeters;
    }
    

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isHasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
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

    public boolean isHasAirCondition() {
        return hasAirCondition;
    }

    public void setHasAirCondition(boolean hasAirCondition) {
        this.hasAirCondition = hasAirCondition;
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
//aircondition

    public int getBedroom_num() {
        return bedroom_num;
    }

    public void setBedroom_num(int bedroom_num) {
        this.bedroom_num = bedroom_num;
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
}
