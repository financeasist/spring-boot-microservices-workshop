package com.rhrup.ratingsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingsDataServiceApplication {

//	private static final Logger log = LoggerFactory.getLogger(RatingsDataServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RatingsDataServiceApplication.class);
    }

//	@Bean
//	public CommandLineRunner demo(RatingRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Rating(1, "Jack", "1234", 4));
//			repository.save(new Rating(2, "Chloe", "5678", 3));
//			repository.save(new Rating(3, "Chloe", "91011", 5));
//			repository.save(new Rating(4, "Jack", "121314", 5));
//			repository.save(new Rating(5, "Jack", "151617", 6));
//
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Rating customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//		};
//	}
}
