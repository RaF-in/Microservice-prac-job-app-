package com.tri.jobms.DTO;

import com.tri.jobms.External.Company;
import com.tri.jobms.External.Review;
import com.tri.jobms.Models.Job;

import java.util.List;

public class JobResponseDTO extends Job {
    private List<Review> reviews;
    private Company company;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
