package com.example.demo.listners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dto.SalesDTO;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 11:50:15 am
 */
@Component
public class SalesWriterListners implements ItemWriteListener<SalesDTO> {
	
	private static final Logger log = LoggerFactory.getLogger(SalesWriterListners.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void afterWrite(Chunk<? extends SalesDTO> items) {

		List<Long> list = items.getItems()
		.stream()
		.map(sale->sale.getSale_id())
		.toList();
		
		String sql = "UPDATE sales SET processed = true WHERE sale_id IN (:idS)";

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("idS",list);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		int update = namedParameterJdbcTemplate.update(sql,mapSqlParameterSource);
		
		log.info("Total rows exported {}",update);
	
	}

	
}
