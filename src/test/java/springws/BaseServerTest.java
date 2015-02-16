package springws;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseServerTest {
	public static final int PORT = 9000;
    public static final String SERVER_URL = "http://localhost:" + PORT;

    private static Server server;

    @BeforeClass
    public static void startServersAndLoadDefaultData() throws Exception {
        server = new Server(PORT);
        WebAppContext webContext = new WebAppContext("src/main/webapp", "");
        server.setHandler(webContext);
        server.setStopAtShutdown(true);
        server.start();
    }

    @AfterClass
    public static void stopServers() throws Exception {
        server.stop();
    }
}
