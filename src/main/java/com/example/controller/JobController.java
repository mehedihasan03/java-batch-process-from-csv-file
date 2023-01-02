package com.example.controller;

import com.example.service.CustomerService;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    @Autowired
    private CustomerService service;

    @PostMapping("/importCustomers")
    public void importCsvToDBJob(){
        try {
            service.importCsvToDB();
        } catch (JobInstanceAlreadyCompleteException | JobRestartException | JobParametersInvalidException |
                 JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        }
    }

}
