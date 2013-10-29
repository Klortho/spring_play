import org.chrismaloney.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Get one service, and print it out to see it's in-memory address
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service);
		
		// Get another one.  Whether or not it's a new instance will depend on the scope
		// annotation:  singleton or prototype.
		CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service2);

		System.out.println(service.findAll().get(0).getGivenName());
	}

}
