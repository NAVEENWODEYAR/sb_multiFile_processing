package com.example.demo.job;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 11:09:32 am
 */

@Component
public class JobScheduler {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Scheduled(cron = "*/5 * * * * *")
	void triggerJob() {
		String fileName = LocalDate.now().toString().concat("_sales.csv");
		JobParameters jobParametersBuilder = new JobParametersBuilder()
								.addString("output.file.name", fileName)
								.addDate("processed", new Date())
								.toJobParameters();
		try {
			this.jobLauncher.run(job, jobParametersBuilder);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {

			e.printStackTrace();
		}
	}
}
