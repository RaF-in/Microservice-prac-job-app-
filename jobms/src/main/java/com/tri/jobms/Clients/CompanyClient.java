package com.tri.jobms.Clients;

import com.tri.jobms.External.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="company-svc", url = "${company-service.url}")
public interface CompanyClient {
    @GetMapping("/company/getCompany/{id}")
    public Company getCompany(@PathVariable Long id);
}
