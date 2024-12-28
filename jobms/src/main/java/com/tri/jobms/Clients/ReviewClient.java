package com.tri.jobms.Clients;
import com.tri.jobms.External.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="review-svc", url = "${review-service.url}")
public interface ReviewClient {
    @GetMapping("/review/getAllReviewsByCompany")
    List<Review> getAllReviewsByCompany(@RequestParam Long companyId);
}
