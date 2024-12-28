package com.tri.reviewms.Clients;

import com.tri.reviewms.External.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="COMPANYMS", url = "${company-service.url}")
public interface CompanyClient {
    @GetMapping("/company/getCompany/{id}")
    public Company getCompany(@PathVariable Long id);

    @PutMapping("/company/updateCompany")
    public Company updateCompany(@RequestBody Company company);
}
