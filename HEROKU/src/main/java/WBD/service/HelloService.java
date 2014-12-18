package WBD.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chamerling
 * 
 */
@WebService
public interface HelloService {

	@WebMethod
	String sayHi(String input);
}
