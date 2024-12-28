package com.tri.companyms.Controllers;

import com.tri.companyms.Models.Company;
import com.tri.companyms.Service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/company")
public class CompanyController {
    private static final Logger log = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @GetMapping("/getCompany/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(companyService.getCompany(id), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        try {
            return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        try {
            return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header(ex.getMessage())
                    .build();
        }
    }
}
