package com.tri.jobms.Repository;

import com.tri.jobms.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long> {
}
