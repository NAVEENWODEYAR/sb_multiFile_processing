package com.batch.MultiFile_Processing.listner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
/**
 * @author NaveenWodeyar
 * @date 10-Sept-2024
 * @time 12:18:07 am
 */
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.stereotype.Component;

@Component
public class CustomJobExecutionListner implements JobExecutionListener{

	private static final Logger log = LoggerFactory.getLogger(CustomJobExecutionListner.class);
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		JobExecutionListener.super.beforeJob(jobExecution);
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		jobExecution.getStepExecutions()
					.stream()
					.findFirst()
					.ifPresent(stepExecution->{
						log.info("\nJOB\n");
						log.info(String.format( "Job has written %s lines",stepExecution.getWriteCount() ));
					});
	}

}
