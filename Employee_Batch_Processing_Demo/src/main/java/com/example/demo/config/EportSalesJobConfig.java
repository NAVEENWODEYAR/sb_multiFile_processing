package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.dto.SalesDTO;
import com.example.demo.listners.SalesWriterListners;
import com.example.demo.processor.SaleProcessor;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 10:35:17 am
 */
@Configuration
@EnableBatchProcessing
public class EportSalesJobConfig {
	
	private final DataSource dataSource;

	public EportSalesJobConfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	
	@Autowired
	private SaleProcessor saleprocessor;
	
	@Autowired
	private SalesWriterListners salesWriterListners;
	
	@Bean
	public JdbcCursorItemReader<SalesDTO> salesJdbcCursorItemReader(){
		String sql = "SELECT sale_id, product_id, customer_id, sale_date, sale_amount, store_location, country FROM sales WHERE processed=false";
		return new JdbcCursorItemReaderBuilder<SalesDTO>()
				.name("sales reader")
				.dataSource(dataSource)
				.sql(sql)
				.fetchSize(50)
				.rowMapper(new DataClassRowMapper<SalesDTO>())
				.build();
	
	}
	
	@Bean
	@StepScope
	public FlatFileItemWriter<SalesDTO> flatFileItemWriter(@Value("#{jobParameters['output.file.name']}")String outPutFile){
		return new FlatFileItemWriterBuilder<SalesDTO>()
				.name("sales file writer")
				.resource(new FileSystemResource(outPutFile))
				.headerCallback(writer->writer.append("Header of File"))
				.delimited()
				.delimiter(",")
				.sourceType(SalesDTO.class)
				.names("product_id", "customer_id", "sale_date", "sale_amount", "store_location", "country")
				.shouldDeleteIfEmpty(true)
				.shouldDeleteIfExists(true)
				.append(true)
				.build();
	}
	
	@Bean
	public Step step(FlatFileItemWriter<SalesDTO> flatFileItemWriter) {
		return new StepBuilder("from DB to File",jobRepository)
				.<SalesDTO,SalesDTO>chunk(10,platformTransactionManager)
				.reader(salesJdbcCursorItemReader())
				.processor(saleprocessor)
				.writer(flatFileItemWriter)
				.listener(salesWriterListners)
				.build();
				
	}
	
	@Bean
	public Job job(Step step) {
		return new JobBuilder("dbToFileJob",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}

}
