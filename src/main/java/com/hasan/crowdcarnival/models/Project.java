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

@Entity
@Table(name = "projects")
@Setter
@Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long projectId;

    private Timestamp projectCreateDate;

    @NotBlank(message = "Field is required !!")
    private String projectName;
    @Column(name = "created_user_id")
    private String createdUserId;

    private String projectSummery;
    private BigInteger totalCostOfProject;
    private long numberOfInvestor;

    // @NotBlank(message = "Field is required !!")
    private BigInteger amountPerInvestor;

    //@NotBlank(message = "Field is required !!")
    private long paidAmountOfInvestment;

    private int preSoldNumberOfInvestmentBDT;
    private int preSoldNumberOfInvestmentPercentage;
    private double bookingTerminationTime;
    private int unitOfInvestment;
    private String mediumOfCommunication;
    private String frequentlyUpdateOfProject;
    private Boolean isInvestorJoinActivities;
    private String frequentlyWithdrawProfit;

    private String projectFile;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

}
