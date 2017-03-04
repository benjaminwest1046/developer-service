package com.myAssortment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class WhosWithWhoApiApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(WhosWithWhoApiApplication.class, args);
		DataBaseConnector.testConnection();
	}
}
