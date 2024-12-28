
package com.tri.companyms.Service;

import com.tri.companyms.DTO.ReviewDTO;
import com.tri.companyms.Models.Company;
import com.tri.companyms.Repositories.CompanyRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;
    public Company getCompany(Long id) {
        return companyRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + id));
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company updateCompany(Company company) {
        return companyRepo.save(company);
    }

    public void updateCompanyRating(ReviewDTO reviewMessage) {
        Company company = companyRepo.findById(reviewMessage.getCompanyId()).get();
        Long newRating = (reviewMessage.getRating() + company.getRating() + 1) / 2;
        company.setRating(newRating);
        companyRepo.save(company);
    }
}
