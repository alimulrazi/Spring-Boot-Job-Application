package com.ali.first_job_app.job.impl;

import com.ali.first_job_app.job.Job;
import com.ali.first_job_app.job.JobRepository;
import com.ali.first_job_app.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void create(Job job) {
       jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findAllById(id).orElse(null);
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findAllById(id);

        if(jobOptional.isPresent()) {
            Job job = jobOptional.get();

            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
