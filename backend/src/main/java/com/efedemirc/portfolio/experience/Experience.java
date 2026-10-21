package com.efedemirc.portfolio.experience;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience { 

    @Id 
    @Generated(value = "org.hibernate.id.UUIDGenerator")
    private Long id;

    @Column(name = "company", nullable = false)
    private String companyName;

    @Column(name = "role", nullable = false)
    private String jobTitle;    

    @Column (name = "location")
    private String location;

    @Column (name = "description", nullable = false, columnDefinition = "text")
    private String jobDescription;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    protected Experience() {
        // required by JPA
    }

    public Long getId() {
        return id;
    }   

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


}

