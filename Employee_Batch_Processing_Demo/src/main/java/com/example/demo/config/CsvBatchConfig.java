//package com.example.demo.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilder;
//import org.springframework.batch.core.configuration.annotation.StepBuilder;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.data.RepositoryItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.example.demo.entity.EmployeeData;
//import com.example.demo.processor.EmployeeProcessor;
//import com.example.demo.repository.EmployeeDataRepo;
//
//@Configuration
//@EnableBatchProcessing
//public class CsvBatchConfig {
//
//    @Autowired
//    private EmployeeDataRepo employeeDataRepo;
//
//    @Autowired
//    private JobBuilder jobBuilder;
//
//    @Autowired
//    private StepBuilder stepBuilder;
//
//    @Bean
//    public FlatFileItemReader<EmployeeData> flatFileItemReader() {
//        FlatFileItemReader<EmployeeData> fileItemReader = new FlatFileItemReader<>();
//        fileItemReader.setResource(new ClassPathResource("data/EMPLOYEE.csv"));
//        fileItemReader.setName("csv-reader");
//        fileItemReader.setLinesToSkip(1); // Skips header line if present
//        fileItemReader.setLineMapper(lineMapper());
//
//        return fileItemReader;
//    }
//
//    private LineMapper<EmployeeData> lineMapper() {
//        DefaultLineMapper<EmployeeData> defaultLineMapper = new DefaultLineMapper<>();
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames("id", "first_name", "last_name", "email", "gender", "contactNo", "country", "dob");
//
//        BeanWrapperFieldSetMapper<EmployeeData> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        beanWrapperFieldSetMapper.setTargetType(EmployeeData.class);
//
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//        return defaultLineMapper;
//    }
//
//    @Bean
//    public EmployeeProcessor employeeProcessor() {
//        return new EmployeeProcessor();
//    }
//
//    @Bean
//    public RepositoryItemWriter<EmployeeData> repositoryItemWriter() {
//        RepositoryItemWriter<EmployeeData> repositoryItemWriter = new RepositoryItemWriter<>();
//        repositoryItemWriter.setRepository(employeeDataRepo);
//        repositoryItemWriter.setMethodName("save");
//
//        return repositoryItemWriter;
//    }
//
//    @Bean
//    public Step step() {
//        return stepBuilder.get("step-1")
//                .<EmployeeData, EmployeeData>chunk(100)
//                .reader(flatFileItemReader())
//                .processor(employeeProcessor())
//                .writer(repositoryItemWriter())
//                .build();
//    }
//
//    @Bean
//    public Job job() {
//        return jobBuilder.get("employee-job")
//                .start(step())
//                .build();
//    }
//}
