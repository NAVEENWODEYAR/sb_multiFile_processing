package com.example.demo.processor;

import org.slf4j.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SalesDTO;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 10:48:58 am
 */
@Component
public class SaleProcessor implements ItemProcessor<SalesDTO, SalesDTO> {

	private static Logger log = LoggerFactory.getLogger(SaleProcessor.class);

//	public SaleProcessor(Logger logger) {
//		this.log = logger;
//	}

	@Override
	public SalesDTO process(SalesDTO item) throws Exception {
		log.info("Processing the item {}",item);
		return item;
	}
	
	
}
