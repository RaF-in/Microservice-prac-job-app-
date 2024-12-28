package com.tri.jobms.Controller;

import com.tri.jobms.DTO.JobResponseDTO;
import com.tri.jobms.Models.Job;
import com.tri.jobms.Service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private static final Logger log = LoggerFactory.getLogger(JobController.class);
    @Autowired
    private JobService jobService;
    @GetMapping("/getJob/{id}")
    public ResponseEntity<JobResponseDTO> getJob(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        try {
            return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @PutMapping("/updateJob")
    public ResponseEntity<Job> updateJob(@RequestBody Job Job) {
        try {
            return new ResponseEntity<>(jobService.updateJob(Job), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }
}
