package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.entity.EmployeeData;
import com.example.demo.processor.EmployeeProcessor;
import com.example.demo.repository.EmployeeDataRepo;

/**
 * Batch job configuration for reading from CSV and writing to the repository.
 * 
 * @author Naveen Wodeyar
 * @date 11-Sept-2024
 * @time 11:42:03 PM
 */
@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {

    @Autowired
    private EmployeeDataRepo employeeDataRepo;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    // Create Reader
    @Bean
    public FlatFileItemReader<EmployeeData> flatFileItemReader() {
        FlatFileItemReader<EmployeeData> fileItemReader = new FlatFileItemReader<>();
        fileItemReader.setResource(new ClassPathResource("data/EMPLOYEE.csv")); // Adjust path as needed
        fileItemReader.setName("csv-reader");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setLineMapper(lineMapper());

        return fileItemReader;
    }

    private LineMapper<EmployeeData> lineMapper() {
        DefaultLineMapper<EmployeeData> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "first_name", "last_name", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<EmployeeData> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(EmployeeData.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
        return defaultLineMapper;
    }

    // Create Processor
    @Bean
    public EmployeeProcessor employeeProcessor() {
        return new EmployeeProcessor();
    }

    // Create Writer
    @Bean
    public RepositoryItemWriter<EmployeeData> repositoryItemWriter() {
        RepositoryItemWriter<EmployeeData> repositoryItemWriter = new RepositoryItemWriter<>();
        repositoryItemWriter.setRepository(employeeDataRepo);
        repositoryItemWriter.setMethodName("save");

        return repositoryItemWriter;
    }

    // Create Step
    @Bean
    public Step step() {
        return stepBuilderFactory.get("step-1")
                .<EmployeeData, EmployeeData>chunk(100)
                .reader(flatFileItemReader())
                .processor(employeeProcessor())
                .writer(repositoryItemWriter())
                .build();
    }

    // Create Job
    @Bean
    public Job job() {
        return jobBuilderFactory.get("employee-job")
                .flow(step())
                .end()
                .build();
    }
}
