package com.tri.jobms.Service;

import com.tri.jobms.Clients.CompanyClient;
import com.tri.jobms.Clients.ReviewClient;
import com.tri.jobms.DTO.JobResponseDTO;
import com.tri.jobms.External.Company;
import com.tri.jobms.External.Review;
import com.tri.jobms.Models.Job;
import com.tri.jobms.Repository.JobRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private ReviewClient reviewClient;

    int retry = 1;

    //@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "myFallbackMethod")
    @Retry(name = "myRetry", fallbackMethod = "myFallbackMethod")
    public JobResponseDTO getJob(Long id) {
        System.out.println("retry=" + retry++);
        Job job = jobRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job not found with id: " + id));
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getAllReviewsByCompany(job.getCompanyId());
        JobResponseDTO response = new JobResponseDTO();
        BeanUtils.copyProperties(job, response);
        response.setReviews(reviews);
        response.setCompany(company);
        return response;
    }

    public JobResponseDTO myFallbackMethod(Exception ex) {
        return new JobResponseDTO();
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Job updateJob(Job job) {
        return jobRepo.save(job);
    }
}
