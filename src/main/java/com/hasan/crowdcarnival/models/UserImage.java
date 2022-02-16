package com.hasan.crowdcarnival.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user_image")
public class UserImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imageId;

    private String userPhotoUrl;
    private String userNidFrontUrl;
    private String userNidBackUrl;

    private Timestamp actionDate;
    private String actionIpAddress;

    @OneToOne
    @JsonIgnore
    private User user;

    public UserImage() {
    }

    public UserImage(long imageId, String userPhotoUrl, String userNidFrontUrl, String userNidBackUrl, Timestamp actionDate, String actionIpAddress) {
        this.imageId = imageId;
        this.userPhotoUrl = userPhotoUrl;
        this.userNidFrontUrl = userNidFrontUrl;
        this.userNidBackUrl = userNidBackUrl;
        this.actionDate = actionDate;
        this.actionIpAddress = actionIpAddress;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public String getUserNidFrontUrl() {
        return userNidFrontUrl;
    }

    public void setUserNidFrontUrl(String userNidFrontUrl) {
        this.userNidFrontUrl = userNidFrontUrl;
    }

    public String getUserNidBackUrl() {
        return userNidBackUrl;
    }

    public void setUserNidBackUrl(String userNidBackUrl) {
        this.userNidBackUrl = userNidBackUrl;
    }

    public Timestamp getActionDate() {
        return actionDate;
    }

    public void setActionDate(Timestamp actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionIpAddress() {
        return actionIpAddress;
    }

    public void setActionIpAddress(String actionIpAddress) {
        this.actionIpAddress = actionIpAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
