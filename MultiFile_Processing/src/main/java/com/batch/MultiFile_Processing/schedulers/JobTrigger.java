package com.batch.MultiFile_Processing.schedulers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NaveenWodeyar
 * @date 08-Sept-2024
 * @time 8:06:09 pm
 */
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobTrigger {
	
	private final JobLauncher jobLauncher;
	
	private final Job job;
	
	private final static Logger log = LoggerFactory.getLogger(JobTrigger.class);
	public JobTrigger(JobLauncher jobLauncher, Job job) {
		super();
		this.jobLauncher = jobLauncher;
		this.job = job;
	}


	@Scheduled(cron = "0/30 * * ? * *")
	void launchJobPeriodically() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		log.info("!@#$$%^&*()==>LAUNCHING JOB");
		JobParametersBuilder jobParameters = new JobParametersBuilder();
		jobParameters.addDate("uniqueness", new Date());
		JobExecution run = this.jobLauncher.run(job, jobParameters.toJobParameters());
		log.info("JOB finished with the status: {}",run.getExitStatus());
		
	}

}
