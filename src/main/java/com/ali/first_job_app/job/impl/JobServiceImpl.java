package com.ali.first_job_app.job.impl;

import com.ali.first_job_app.job.Job;
import com.ali.first_job_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs =  new ArrayList<Job>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void create(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }
}
