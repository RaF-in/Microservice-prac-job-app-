package com.tri.reviewms.Service;

import com.tri.reviewms.Clients.CompanyClient;
import com.tri.reviewms.External.Company;
import com.tri.reviewms.Models.Review;
import com.tri.reviewms.Repository.ReviewRepo;
import com.tri.reviewms.messaging.RabbitMqProducer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private CompanyClient companyClient;
    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    public Review getReview(Long id) {
        return reviewRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + id));
    }

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review updateReview(Review review) {
        rabbitMqProducer.sendMessage(review);
        return reviewRepo.save(review);
    }

    public List<Review> getAllReviewsByCompany(Long companyId) {
        return reviewRepo.findByCompanyId(companyId);
    }
}
