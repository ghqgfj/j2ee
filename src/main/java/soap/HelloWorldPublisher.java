package soap;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {
	public static void main(String[] args) {
		rpcWebService();
		documentWebService();
	}
	public static void rpcWebService(){
		Endpoint.publish("http://localhost:9999/ws/helloRpc",
				new HelloWorldRPCImpl());
	}
	public static void documentWebService(){
		Endpoint.publish("http://localhost:9999/ws/helloDocument",
				new HelloWorldDocumentImpl());
	}
}
