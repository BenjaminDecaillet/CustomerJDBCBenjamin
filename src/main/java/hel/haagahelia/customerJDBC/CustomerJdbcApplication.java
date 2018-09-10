package hel.haagahelia.customerJDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class CustomerJdbcApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerJdbcApplication.class, args);
	}
	   
	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
	        jdbcTemplate.update("insert into customer(first_name, last_name) values (?, ?)", "John", "West");
	        jdbcTemplate.update("insert into customer(first_name, last_name) values (?, ?)", "Mike", "Mars");
	        jdbcTemplate.update("insert into customer(first_name, last_name) values (?, ?)", "Kate", "Johnson");
		};
	}	
}
