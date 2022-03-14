package com.hasan.crowdcarnival.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long projectId;

    private String projectName;
    private String projectSummery;
    private BigInteger projectCost;
    private long numberOfInvestor;
    private BigInteger amountPerInvestor;
    private long perTotalInvestment;
    private int numberOfInvestmentBDT;
    private int numberOfInvestmentPercentage;
    private int unitOfInvestment;


}
