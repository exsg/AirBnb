/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alex
 */
@Entity
@Table(name = "listing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listing.findAll", query = "SELECT l FROM Listing l"),
    @NamedQuery(name = "Listing.findById", query = "SELECT l FROM Listing l WHERE l.id = :id"),
    @NamedQuery(name = "Listing.findByGeolocationLatitude", query = "SELECT l FROM Listing l WHERE l.geolocationLatitude = :geolocationLatitude"),
    @NamedQuery(name = "Listing.findByGeolocationLongitude", query = "SELECT l FROM Listing l WHERE l.geolocationLongitude = :geolocationLongitude"),
    @NamedQuery(name = "Listing.findByCountry", query = "SELECT l FROM Listing l WHERE l.country = :country"),
    @NamedQuery(name = "Listing.findByBedroomNumber", query = "SELECT l FROM Listing l WHERE l.bedroomNumber = :bedroomNumber"),
    @NamedQuery(name = "Listing.findByCity", query = "SELECT l FROM Listing l WHERE l.city = :city"),
    @NamedQuery(name = "Listing.findByDistrict", query = "SELECT l FROM Listing l WHERE l.district = :district"),
    @NamedQuery(name = "Listing.findBySqrMeters", query = "SELECT l FROM Listing l WHERE l.sqrMeters = :sqrMeters"),
    @NamedQuery(name = "Listing.findByFloor", query = "SELECT l FROM Listing l WHERE l.floor = :floor"),
    @NamedQuery(name = "Listing.findByMaxPeople", query = "SELECT l FROM Listing l WHERE l.maxPeople = :maxPeople"),
    @NamedQuery(name = "Listing.findByBedNumber", query = "SELECT l FROM Listing l WHERE l.bedNumber = :bedNumber"),
    @NamedQuery(name = "Listing.findByBathroomNumber", query = "SELECT l FROM Listing l WHERE l.bathroomNumber = :bathroomNumber"),
    @NamedQuery(name = "Listing.findByMinimumDays", query = "SELECT l FROM Listing l WHERE l.minimumDays = :minimumDays"),
    @NamedQuery(name = "Listing.findByActive", query = "SELECT l FROM Listing l WHERE l.active = :active"),
    @NamedQuery(name = "Listing.findBySubmittedDate", query = "SELECT l FROM Listing l WHERE l.submittedDate = :submittedDate"),
    @NamedQuery(name = "Listing.findByExtraCostPerPerson", query = "SELECT l FROM Listing l WHERE l.extraCostPerPerson = :extraCostPerPerson"),
    @NamedQuery(name = "Listing.findByFriendlyName", query = "SELECT l FROM Listing l WHERE l.friendlyName = :friendlyName"),
    @NamedQuery(name = "Listing.findByCost", query = "SELECT l FROM Listing l WHERE l.cost = :cost")})
public class Listing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geolocation_latitude")
    private double geolocationLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geolocation_longitude")
    private double geolocationLongitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bedroom_number")
    private int bedroomNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sqr_meters")
    private int sqrMeters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "floor")
    private int floor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_people")
    private int maxPeople;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bed_number")
    private int bedNumber;
    @Column(name = "bathroom_number")
    private Integer bathroomNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimum_days")
    private int minimumDays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private int active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submitted_date")
    @Temporal(TemporalType.DATE)
    private Date submittedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extra_cost_per_person")
    private int extraCostPerPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "friendly_name")
    private String friendlyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @ManyToMany(mappedBy = "listingList", fetch = FetchType.LAZY)
    private List<Amenity> amenityList;
    @JoinTable(name = "listing_has_rule", joinColumns = {
        @JoinColumn(name = "listing_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "rule_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rule> ruleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingId", fetch = FetchType.LAZY)
    private List<Booking> bookingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingId", fetch = FetchType.LAZY)
    private List<Critic> criticList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingId", fetch = FetchType.LAZY)
    private List<Photo> photoList;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Type typeId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listingId", fetch = FetchType.LAZY)
    private List<UserViewsListing> userViewsListingList;

    public Listing() {
    }

    public Listing(Integer id) {
        this.id = id;
    }

    public Listing(Integer id, double geolocationLatitude, double geolocationLongitude, String country, int bedroomNumber, String city, String district, int sqrMeters, int floor, int maxPeople, int bedNumber, String description, int minimumDays, int active, Date submittedDate, int extraCostPerPerson, String friendlyName, int cost) {
        this.id = id;
        this.geolocationLatitude = geolocationLatitude;
        this.geolocationLongitude = geolocationLongitude;
        this.country = country;
        this.bedroomNumber = bedroomNumber;
        this.city = city;
        this.district = district;
        this.sqrMeters = sqrMeters;
        this.floor = floor;
        this.maxPeople = maxPeople;
        this.bedNumber = bedNumber;
        this.description = description;
        this.minimumDays = minimumDays;
        this.active = active;
        this.submittedDate = submittedDate;
        this.extraCostPerPerson = extraCostPerPerson;
        this.friendlyName = friendlyName;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(int bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
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

    public int getSqrMeters() {
        return sqrMeters;
    }

    public void setSqrMeters(int sqrMeters) {
        this.sqrMeters = sqrMeters;
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

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Integer getBathroomNumber() {
        return bathroomNumber;
    }

    public void setBathroomNumber(Integer bathroomNumber) {
        this.bathroomNumber = bathroomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinimumDays() {
        return minimumDays;
    }

    public void setMinimumDays(int minimumDays) {
        this.minimumDays = minimumDays;
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

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @XmlTransient
    public List<Amenity> getAmenityList() {
        return amenityList;
    }

    public void setAmenityList(List<Amenity> amenityList) {
        this.amenityList = amenityList;
    }

    @XmlTransient
    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @XmlTransient
    public List<Critic> getCriticList() {
        return criticList;
    }

    public void setCriticList(List<Critic> criticList) {
        this.criticList = criticList;
    }

    @XmlTransient
    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<UserViewsListing> getUserViewsListingList() {
        return userViewsListingList;
    }

    public void setUserViewsListingList(List<UserViewsListing> userViewsListingList) {
        this.userViewsListingList = userViewsListingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listing)) {
            return false;
        }
        Listing other = (Listing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goldencompany.airbnb.entity.Listing[ id=" + id + " ]";
    }
    
}
