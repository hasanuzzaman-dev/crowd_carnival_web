package com.hasan.crowdcarnival.models.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SMSResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("totalValidNumber")
    @Expose
    private Integer totalValidNumber;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("smsCount")
    @Expose
    private Integer smsCount;
    @SerializedName("apiMessageId")
    @Expose
    private Long apiMessageId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalValidNumber() {
        return totalValidNumber;
    }

    public void setTotalValidNumber(Integer totalValidNumber) {
        this.totalValidNumber = totalValidNumber;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public Long getApiMessageId() {
        return apiMessageId;
    }

    public void setApiMessageId(Long apiMessageId) {
        this.apiMessageId = apiMessageId;
    }

}