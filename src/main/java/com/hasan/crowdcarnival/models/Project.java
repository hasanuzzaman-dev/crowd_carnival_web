package com.hasan.crowdcarnival.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long projectId;

    private Timestamp projectCreateDate;

    //A. Name of the project
    @NotBlank(message = "Field is required !!")
    private String projectName;

    @Column(name = "created_user_id")
    private String createdUserId;

    //B. Brief summary of the project in 1200 words. (copy and paste).
    private String projectSummery;

    //Total cost of the project in BDT
    private BigInteger totalCostOfProject;

    //E. Number of investors invited for the project/ total individuals.
    private String numberOfInvestor;

    // @NotBlank(message = "Field is required !!")
    //F. Amount of investment for each investor in BDT.
    private BigInteger amountPerInvestor;

    //@NotBlank(message = "Field is required !!")
    //G. The paid amount of investment which is equal to certain percentage of the total project investment.
    private String paidAmountOfInvestment;

    //H. Pre-sold number of investment in BDT.
    private String preSoldNumberOfInvestmentBDT;

    //I. Pre-sold number of investment in %.
    private String preSoldNumberOfInvestmentPercentage;

    //J. Booking auto termination time in hours.
    private String bookingTerminationTime;

    // K. The units of investment one can do for the project.
    private String unitOfInvestment;

    // L. The medium of communication the investor prefers to use.
    private String mediumOfCommunication;

    //M. How frequently does the investor want to know about the updates of the project?
    private String frequentlyUpdateOfProject;

    //N. Is the investor interested to join any activities of the project? How many every year?
    private String investorInterestedJoinActivities;

    // O. How frequently does the investor want to withdraw the profit? Once a year/ once in every 2 years.
    private String frequentlyWithdrawProfit;

    // C. Unlimited number of doc /xls /PDF /JPG and other files to be attached for the investors’ download purpose
    private String projectFile;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

}
