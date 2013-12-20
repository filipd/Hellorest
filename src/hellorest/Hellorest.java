package hello;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

public class Hellorest {

    public static void main(String[] args) throws Exception {
        Server server = new Server(Protocol.HTTP, 8182, new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                response.setEntity("hello, world2", MediaType.APPLICATION_JSON);
            }
        });
        server.start();
        new ClientResource("http://localhost:8182/ab").get().
                write(System.out);
        server.stop();
    }
}
