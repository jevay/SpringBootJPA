package com.starter.demo;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJPAApplicationTests {
	@Autowired
	DataSourceProperties datasourceProperties;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void contextLoads() {
		DataSource datasource = applicationContext.getBean(DataSource.class);
		System.out.println("Data soruce is: " + datasource);
		System.out.println(datasource.getClass().getName());
		System.out.println(datasourceProperties);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		List<?> resultList = jdbcTemplate.queryForList("select * from user_info");
		System.out.println("===>>>>>>>>" + JSON.toJSONString(resultList));
	}

}
