package com.hasan.crowdcarnival.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String addressType;

    @NotBlank(message = "House field is required !!")
    private String house;
    private String lane;
    private String road;
    private String village;
    private String postOffice;
    private String postCode;
    private String policeStation;
    private String upozella;
    private String district;
    private String nearestLandMark;
    private String googleMap;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getUpozella() {
        return upozella;
    }

    public void setUpozella(String upozella) {
        this.upozella = upozella;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNearestLandMark() {
        return nearestLandMark;
    }

    public void setNearestLandMark(String nearestLandMark) {
        this.nearestLandMark = nearestLandMark;
    }

    public String getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(String googleMap) {
        this.googleMap = googleMap;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
