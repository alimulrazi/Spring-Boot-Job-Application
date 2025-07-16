package com.ali.first_job_app.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void create(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
