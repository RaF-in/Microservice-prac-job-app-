package com.tri.reviewms.Controller;

import com.tri.reviewms.Models.Review;
import com.tri.reviewms.Service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/getReview/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(reviewService.getReview(id), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        try {
            return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @PutMapping("/updateReview")
    public ResponseEntity<Review> updateReview(@RequestBody Review Review) {
        try {
            return new ResponseEntity<>(reviewService.updateReview(Review), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @GetMapping("/getAllReviewsByCompany")
    public ResponseEntity<List<Review>> getAllReviewsByCompany(@RequestParam Long companyId) {
        try {
            return new ResponseEntity<>(reviewService.getAllReviewsByCompany(companyId), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }
}
