/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.dto.xml;

import com.goldencompany.airbnb.dto.output.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author george
 */
public class ListingExportDTO {

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

    private int bedNum;
    private int bathroomNum;
    private String description;

    private int minDays;
    private int active;

    private Date submittedDate;
    private int extraCostPerPerson;

    private List<AmenityDTO> amenities = new ArrayList<>();
    private List<RuleDTO> rules = new ArrayList<>();
    private List<PhotoDTO> photo = new ArrayList<>();
    private List <BookingDTO> booking = new ArrayList<>();
    private List <CriticDTO> critic = new ArrayList<>();

    
    @XmlElementWrapper(name = "critics")
    @XmlElement(name = "critic")
    public List<CriticDTO> getCritic() {
        return critic;
    }

    public void setCritic(List<CriticDTO> critic) {
        this.critic = critic;
    }
  

    //
    @XmlElementWrapper(name = "photos")
    @XmlElement(name = "photo")
    public List<PhotoDTO> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoDTO> photo) {
        this.photo = photo;
    }

    private TypeDTO type;

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

//    private List<RoleDTO> roles = new ArrayList<>();
    public ListingExportDTO() {

    }

//
    @XmlElementWrapper(name = "amenities")
    @XmlElement(name = "amenity")
    public List<AmenityDTO> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityDTO> amenities) {
        this.amenities = amenities;
    }

//    
    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    @XmlElementWrapper(name = "rules")
    @XmlElement(name = "rule")
    public List<RuleDTO> getRules() {
        return rules;
    }

    public void setRules(List<RuleDTO> rules) {
        this.rules = rules;
    }
    @XmlElementWrapper(name = "bookings")
    @XmlElement(name = "booking")
      public List<BookingDTO> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingDTO> booking) {
        this.booking = booking;
    }

}
