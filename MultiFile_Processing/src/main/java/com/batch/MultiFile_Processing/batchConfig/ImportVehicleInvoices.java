package com.batch.MultiFile_Processing.batchConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.MultiFile_Processing.entity.VehicleDTO;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 8:54:41 am
 */
@Configuration
public class ImportVehicleInvoices {
	
	private static final Logger log = LoggerFactory.getLogger(ImportVehicleInvoices.class);
	
	@Bean
	public Job importVehicelJob(JobRepository jobRepository, Step importVehiclesStep) {
		return new JobBuilder("importVehicleJob",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(importVehiclesStep)
				.build();
	}

	public Step importVehiclesStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("importVehicleStep",jobRepository)
				.chunk(100,platformTransactionManager)
				.reader(vehicleFileItemReader())
				.processor(item->vehicleProcessor((VehicleDTO) item))
				.writer(items->log.info("Writing items: {}",items))
				.build();
	}
	
	public FlatFileItemReader<VehicleDTO> vehicleFileItemReader(){
		return new FlatFileItemReaderBuilder<VehicleDTO>()
				.resource(new ClassPathResource("/data/invoice.csv"))
				.name("vehicle item reader")
				.saveState(false)
				.linesToSkip(1)
				.delimited()
				.delimiter(",")
				.names("referenceNumber","model","type","customerFullName")
				.comments("#")
				.targetType(VehicleDTO.class)
				.build();
	}
	
	private static VehicleDTO vehicleProcessor(VehicleDTO item) {
		log.info("Processing the item: {}",item);
		return item;
	}
	
}
