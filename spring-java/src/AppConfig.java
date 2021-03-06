import org.chrismaloney.repository.CustomerRepository;
import org.chrismaloney.repository.HibernateCustomerRepositoryImpl;
import org.chrismaloney.service.CustomerService;
import org.chrismaloney.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

// In a Java configured project, this class, with its annotations, takes the place
// of applicationContext.xml.


// @Configuration is a class-level annotation, that 
@Configuration

// Use this for autowiring:
@ComponentScan({"org.chrismaloney"})

// Import properties
@PropertySource("app.properties")

public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// This identifies the following as the method to use to get a particular bean
	// Note that the name of the *method* doesn't matter.  But it's a nice idea to
	// use the same conventions as with annotation-based configurations
	
	@Bean(name = "customerService")
	@Scope("prototype")
    public CustomerService getCustomerService() {
		
		// This is setter injection:
		//CustomerServiceImpl customerService = new CustomerServiceImpl();
		//customerService.setCustomerRepository(getCustomerRepository());
		
		// This is constructor injection:
		//CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());
		
		// For auto-wired:
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		
		return customerService;
    }
	
	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
	}
}
