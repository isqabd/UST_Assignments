package com.ust.trainerjobnotifications.controller;

import com.ust.trainerjobnotifications.model.JobNotification;
import com.ust.trainerjobnotifications.service.JobNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobNotificationController {

    @Autowired
    private JobNotificationService jobNotificationService;


    @PostMapping
    public JobNotification addJob(@RequestBody JobNotification jobNotification) {
        return jobNotificationService.addJob(jobNotification);
    }


    @GetMapping
    public List<JobNotification> getAllJobs() {
        return jobNotificationService.getAllJobs();
    }


    @GetMapping("/{id}")
    public ResponseEntity<JobNotification> getJobById(@PathVariable Long id) {
        Optional<JobNotification> jobNotification = jobNotificationService.getJobById(id);
        return jobNotification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updatejobnotification/{id}")
    public JobNotification updateJobNotification(@PathVariable Long id, @RequestBody JobNotification jobNotification) {
        JobNotificationController service = null;
        return service.updateJobNotification(id, jobNotification);
    }


    @DeleteMapping("/deletejobnotification/{id}")
    public String deleteJobNotification(@PathVariable Long id) {
        JobNotificationController service = null;
        return service.deleteJobNotification(id);
    }

}
