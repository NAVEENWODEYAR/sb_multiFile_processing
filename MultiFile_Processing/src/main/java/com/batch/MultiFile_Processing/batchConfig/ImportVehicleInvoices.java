package com.batch.MultiFile_Processing.batchConfig;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Configuration;

import com.batch.MultiFile_Processing.entity.VehicleDTO;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 8:54:41 am
 */
@Configuration
public class ImportVehicleInvoices {

	public FlatFileItemReader<VehicleDTO> veFileItemReader(){
		
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
}
