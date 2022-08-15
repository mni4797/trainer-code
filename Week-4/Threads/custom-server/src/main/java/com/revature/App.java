package com.revature;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // in this line of code we're establishing a server that
        // listens to http requests at port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(9080), 0);
        // create context maps a path to a certain action
        // set handler sets the action to be executed when a request is sent
        // to the path create context establishes
        // you pass an HttpExchange object to the handler interface, this object
        // contains
        // information about the request, like the request body, method, Uri, ETC
        server.createContext("/hello").setHandler((exchange) -> sendResponse(exchange, "Hello!", 200));
        // HttpServer allows you to set a thread pool size with the Executors
        server.setExecutor(Executors.newFixedThreadPool(4));
        server.start();

    }

    // this is a helper method for packing our response and sending it out
    private static void sendResponse(HttpExchange exchange, String response, int status) throws IOException {
        // set the http response headers here
        // status code
        // length of body
        exchange.sendResponseHeaders(status, response.getBytes().length);
        // getting outputstream to write our response
        OutputStream os = exchange.getResponseBody();
        // where we actually write out the response we're sending
        // converting the response to bytes first
        // serializing the data we're sending across systems
        os.write(response.getBytes());
        // closing the output stream, resource clean up
        os.close();

    }
}
