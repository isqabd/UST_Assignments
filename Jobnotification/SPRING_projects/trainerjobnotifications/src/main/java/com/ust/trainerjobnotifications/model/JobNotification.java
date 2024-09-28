package com.ust.trainerjobnotifications.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data


public class JobNotification {

    @Id
    private Long jobId;
    private String company_name;
    private String jobTitle;
    private String description;
    private String location;
    private double salary;

    public JobNotification(Long jobId, String company_name, String jobTitle, String description, String location, double salary) {
        this.jobId = jobId;
        this.company_name = company_name;
        this.jobTitle = jobTitle;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
