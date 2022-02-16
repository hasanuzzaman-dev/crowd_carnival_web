package com.hasan.crowdcarnival.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nominee")
public class Nominee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long nomineeId;

    private String nomineeName;
    private String nomineeRelationShip;
    private String nomineePhone;
    private String nomineePercentage;
    private String nomineeHouseNumber;
    private String nomineeHouseName;
    private String nomineeLaneNumber;
    private String nomineeLaneName;
    private String nomineeRoadNumber;
    private String nomineeRoadName;
    private String nomineeVillage;
    private String nomineePostOffice;
    private String nomineePostCode;
    private String nomineePoliceStation;
    private String nomineeUpozella;
    private String nomineeDistrict;
    private String nomineeNearestLandMark;
    private String nomineeGoogleMap;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Nominee() {
    }

    public long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(long nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeRelationShip() {
        return nomineeRelationShip;
    }

    public void setNomineeRelationShip(String nomineeRelationShip) {
        this.nomineeRelationShip = nomineeRelationShip;
    }

    public String getNomineePhone() {
        return nomineePhone;
    }

    public void setNomineePhone(String nomineePhone) {
        this.nomineePhone = nomineePhone;
    }

    public String getNomineePercentage() {
        return nomineePercentage;
    }

    public void setNomineePercentage(String nomineePercentage) {
        this.nomineePercentage = nomineePercentage;
    }

    public String getNomineeHouseNumber() {
        return nomineeHouseNumber;
    }

    public void setNomineeHouseNumber(String nomineeHouseNumber) {
        this.nomineeHouseNumber = nomineeHouseNumber;
    }

    public String getNomineeHouseName() {
        return nomineeHouseName;
    }

    public void setNomineeHouseName(String nomineeHouseName) {
        this.nomineeHouseName = nomineeHouseName;
    }

    public String getNomineeLaneNumber() {
        return nomineeLaneNumber;
    }

    public void setNomineeLaneNumber(String nomineeLaneNumber) {
        this.nomineeLaneNumber = nomineeLaneNumber;
    }

    public String getNomineeLaneName() {
        return nomineeLaneName;
    }

    public void setNomineeLaneName(String nomineeLaneName) {
        this.nomineeLaneName = nomineeLaneName;
    }

    public String getNomineeRoadNumber() {
        return nomineeRoadNumber;
    }

    public void setNomineeRoadNumber(String nomineeRoadNumber) {
        this.nomineeRoadNumber = nomineeRoadNumber;
    }

    public String getNomineeRoadName() {
        return nomineeRoadName;
    }

    public void setNomineeRoadName(String nomineeRoadName) {
        this.nomineeRoadName = nomineeRoadName;
    }

    public String getNomineeVillage() {
        return nomineeVillage;
    }

    public void setNomineeVillage(String nomineeVillage) {
        this.nomineeVillage = nomineeVillage;
    }

    public String getNomineePostOffice() {
        return nomineePostOffice;
    }

    public void setNomineePostOffice(String nomineePostOffice) {
        this.nomineePostOffice = nomineePostOffice;
    }

    public String getNomineePostCode() {
        return nomineePostCode;
    }

    public void setNomineePostCode(String nomineePostCode) {
        this.nomineePostCode = nomineePostCode;
    }

    public String getNomineePoliceStation() {
        return nomineePoliceStation;
    }

    public void setNomineePoliceStation(String nomineePoliceStation) {
        this.nomineePoliceStation = nomineePoliceStation;
    }

    public String getNomineeUpozella() {
        return nomineeUpozella;
    }

    public void setNomineeUpozella(String nomineeUpozella) {
        this.nomineeUpozella = nomineeUpozella;
    }

    public String getNomineeDistrict() {
        return nomineeDistrict;
    }

    public void setNomineeDistrict(String nomineeDistrict) {
        this.nomineeDistrict = nomineeDistrict;
    }

    public String getNomineeNearestLandMark() {
        return nomineeNearestLandMark;
    }

    public void setNomineeNearestLandMark(String nomineeNearestLandMark) {
        this.nomineeNearestLandMark = nomineeNearestLandMark;
    }

    public String getNomineeGoogleMap() {
        return nomineeGoogleMap;
    }

    public void setNomineeGoogleMap(String nomineeGoogleMap) {
        this.nomineeGoogleMap = nomineeGoogleMap;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
