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
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.VirtualThreadTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.MultiFile_Processing.entity.VehicleDTO;
import com.batch.MultiFile_Processing.listner.CustomJobExecutionListner;
import com.batch.MultiFile_Processing.listner.MultiResourceThreadSafe;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 8:54:41 am
 */
@Configuration
public class ImportVehicleInvoices {
	
	@Value("${input.folder.vehicles}")
	private Resource[] resources;
	
	@Autowired
	private CustomJobExecutionListner customJobExecutionListner;
	
	private static final Logger log = LoggerFactory.getLogger(ImportVehicleInvoices.class);
	
	@Bean
	public Job importVehicelJob(JobRepository jobRepository, Step importVehiclesStep) {
		return new JobBuilder("importVehicleJob",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(importVehiclesStep)
				.listener(customJobExecutionListner)
				.build();
	}

	public Step importVehiclesStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("importVehicleStep",jobRepository)
				.chunk(100,platformTransactionManager)
//				.reader(multiResourceItemReader())
				.reader(multiResourceThreadSafe())
				.processor(item->vehicleProcessor((VehicleDTO) item))
				.writer(items->log.info("Writing items: {}",items))
				.taskExecutor(taskExecutor())
				.build();
	}
	
	public MultiResourceThreadSafe<VehicleDTO> multiResourceThreadSafe(){
		MultiResourceThreadSafe<VehicleDTO> multiResourceThreadSafe = new MultiResourceThreadSafe<VehicleDTO>(null);
		multiResourceThreadSafe.setResource(resources);
		return multiResourceThreadSafe;
	}
	
	public MultiResourceItemReader<VehicleDTO> multiResourceItemReader(){
		return new MultiResourceItemReaderBuilder<VehicleDTO>()
				.name("vehicle resource reader")
				.resources(resources)
				.delegate(vehicleFileItemReader())
				.build();
	}
	
	public ResourceAwareItemReaderItemStream<VehicleDTO> vehicleFileItemReader(){
		return new FlatFileItemReaderBuilder<VehicleDTO>()
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
	
	@Bean
	public VirtualThreadTaskExecutor taskExecutor() {
		return new VirtualThreadTaskExecutor("Custom-Thread-");
		
	}
	
}
