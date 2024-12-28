package com.tri.companyms.Repositories;

import com.tri.companyms.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}
