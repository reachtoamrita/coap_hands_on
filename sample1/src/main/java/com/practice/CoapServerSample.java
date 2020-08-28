package com.practice;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoapServerSample {
    public static void main(String[] args) {
        CoapServer server = new CoapServer();
        server.add(new HelloResource());
        server.start();
    }

    public static class HelloResource extends CoapResource {
        public HelloResource() {
            // resource identifier
            super("SampleRequests");
            // set display name
            getAttributes().setTitle("Hello-World Resource");
        }

        @Override
        public void handleGET(CoapExchange exchange) {
            System.out.println(exchange.getRequestText());
            exchange.respond("You got the get request working");
        }

        @Override
        public void handlePOST(CoapExchange exchange){
            System.out.println(exchange.getRequestText());
            exchange.respond("You got the post request working");
        }

    }
}
