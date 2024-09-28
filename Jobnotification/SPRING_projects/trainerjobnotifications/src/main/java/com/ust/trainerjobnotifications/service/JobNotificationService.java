package com.ust.trainerjobnotifications.service;

import com.ust.trainerjobnotifications.model.JobNotification;
import com.ust.trainerjobnotifications.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobNotificationService {
    @Autowired
    private JobRepository jobRepository;

    // Add a new job notification
    public JobNotification addJob(JobNotification jobNotification) {
        return jobRepository.save(jobNotification);
    }

    // Retrieve all job notifications
    public List<JobNotification> getAllJobs() {
        return jobRepository.findAll();
    }

    // Retrieve a specific job by jobId
    public Optional<JobNotification> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }
}
