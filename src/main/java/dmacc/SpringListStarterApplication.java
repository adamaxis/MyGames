package dmacc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import dmacc.beans.Contact;
import dmacc.controller.BeanConfiguration;
import dmacc.beans.Address;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class SpringListStarterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringListStarterApplication.class, args);
		
	}
	
	@Autowired
	ContactRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Contact c = appContext.getBean("contact", Contact.class);
		c.setRelationship("best friend");
		repo.save(c);
		
		
		Contact d = new Contact("Sandra Boynton", "555-555-5557", "friend");
		Address a = new Address("123 Main Street", "Des Moines", "IA");
		d.setAddress(a);
		repo.save(d);
		
		List<Contact> allMyContacts = repo.findAll();
		for(Contact people: allMyContacts) {
			System.out.println(people.toString());
		}
		
		((AnnotationConfigApplicationContext) appContext).close();
	}
}
