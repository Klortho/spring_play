import org.chrismaloney.service.CustomerService;
import org.chrismaloney.service.CustomerServiceImpl;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService service = new CustomerServiceImpl();
		
		System.out.println(service.findAll().get(0).getGivenName());
	}

}
