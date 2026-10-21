package com.efedemirc.portfolio.experience;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "experiences")
public class Experience {
    @Id 
    private Long id;

    @Column(name = "company", nullable = false)
    private String companyName;

    @Column(name = "role", nullable = false)
    private String jobTitle;    

    @Column (name = "location", nullable = false)
    private String location;

    @Column (nullable = false, columnDefinition = "text")
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

