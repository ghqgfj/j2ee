package soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {
		//rpcClient();
		documentClient();
	}
	public static void rpcClient() throws MalformedURLException{
		URL url = new URL("http://localhost:9999/ws/helloRpc?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap/",
				"HelloWorldRPCImplService");

		Service service = Service.create(url, qname);
		HelloWorldRPC hello = service.getPort(HelloWorldRPC.class);
		System.out.println(hello.getHelloWorldAsString("qianjin call rpc style web service"));
	}
	public static void documentClient() throws MalformedURLException{
		URL url = new URL("http://localhost:8888/ws/helloDocument?wsdl");
		QName qname = new QName("http://soap/",
				"HelloWorldDocumentImplService");

		Service service = Service.create(url, qname);
		HelloWorldDocument hello = service.getPort(HelloWorldDocument.class);
		System.out.println(hello.getHelloWorldAsString("qianjin call documnet style web service"));
	}
}
