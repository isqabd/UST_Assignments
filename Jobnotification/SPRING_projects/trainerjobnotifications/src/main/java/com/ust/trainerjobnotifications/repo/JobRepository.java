package com.ust.trainerjobnotifications.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ust.trainerjobnotifications.model.JobNotification;

@Repository
public interface JobRepository extends JpaRepository<JobNotification,Long> {
}
