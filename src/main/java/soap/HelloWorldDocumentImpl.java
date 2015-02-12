package soap;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.HelloWorldDocument")
public class HelloWorldDocumentImpl implements HelloWorldDocument{

	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS:"+name;
	}

}
