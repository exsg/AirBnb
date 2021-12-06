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

        

public class ListingDTO {
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private double geolocation_lat;
    private double geolocation_long;
    private String country;
    private int bedroom_num;
    private String city;
    private String district;
    private int floor;
    private int maxPeople;
    private String  friendlyName;
    
    private int sqrMeters;
    
    
   
    private int bedNum;
    private int bathroomNum;
    private String description;
    
    private int minDays;
    private int active;
    
    
    private Date submittedDate;
    private int extraCostPerPerson;
    private TypeDTO type;
    
    private int cost;

   
    private List<AmenityDTO> amenities = new ArrayList<>();
    private List<RuleDTO> rules = new ArrayList<>();
    
    private List<PhotoDTO> photos = new ArrayList<>();
    private List<BookingDTO> bookings = new ArrayList<>();

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }

    public List<CriticDTO> getCritics() {
        return critics;
    }

    public void setCritics(List<CriticDTO> critics) {
        this.critics = critics;
    }
    private List<CriticDTO> critics = new ArrayList<>();

//    public List<PhotoDTO> getPhotos() {
//        return photos;
//    }
//
//    public void setPhotos(List<PhotoDTO> photos) {
//        this.photos = photos;
//    }

    public int getSqrMeters() {
        return sqrMeters;
    }

    public void setSqrMeters(int sqrMeters) {
        this.sqrMeters = sqrMeters;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGeolocation_lat() {
        return geolocation_lat;
    }

    public void setGeolocation_lat(Double geolocation_lat) {
        this.geolocation_lat = geolocation_lat;
    }

    public Double getGeolocation_long() {
        return geolocation_long;
    }

    public void setGeolocation_long(Double geolocation_long) {
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

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getExtraCostPerPerson() {
        return extraCostPerPerson;
    }

    public void setExtraCostPerPerson(int extraCostPerPerson) {
        this.extraCostPerPerson = extraCostPerPerson;
    }
    
    public ListingDTO() {
        
    }

//
    public List<AmenityDTO> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityDTO> amenities) {
        this.amenities = amenities;
    }
    
      public List<RuleDTO> getRules() {
        return rules;
    }

    public void setRules(List<RuleDTO> rules) {
        this.rules = rules;
    }
    
     public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }
    
    
    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }
    
    
     public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
  
}
