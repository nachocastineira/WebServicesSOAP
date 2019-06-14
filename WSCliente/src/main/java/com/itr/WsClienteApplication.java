 package com.itr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itr.client.CountryClient;
import com.itr.wsdl.GetCountryResponse;

@SpringBootApplication
public class WsClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsClienteApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			
			System.err.println("Pais: " + response.getCountry().getName());
			System.err.println("Capital: " + response.getCountry().getCapital());
			System.err.println("Moneda: " + response.getCountry().getCurrency());
			System.err.println("Poblacion: " + response.getCountry().getPopulation());

		};
	}

}
