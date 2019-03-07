package dmacc.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dmacc.beans.Address;
import dmacc.beans.Contact;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Contact contact() {
		Contact bean = new Contact("Eric Carle");
		//bean.setName("Dr. Seuss");
		//bean.setPhoneNumber("555-555-5555");
		//bean.setRelationship("friend");
		bean.setAddress(address());
		return bean;
	}

	@Bean
	public Address address() {
		Address bean = new Address("123 Main Street", "Des Moines", "IA");
		return bean;
	}


}
