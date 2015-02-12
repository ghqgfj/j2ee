package soap;

import javax.jws.WebService;

@WebService(endpointInterface = "soap.HelloWorldRPC")
public class HelloWorldRPCImpl implements HelloWorldRPC{

	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS:"+name;
	}

}
