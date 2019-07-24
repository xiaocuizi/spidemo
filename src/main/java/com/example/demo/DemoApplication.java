package com.example.demo;

import com.example.demo.webflux.StudentHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.ipc.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

@SpringBootApplication
@EnableWebFlux
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		/*HttpHandler httpHandler = toHttpHandler(
				route(GET("/selectStudent").and(accept(MediaType.APPLICATION_JSON_UTF8)), StudentHandler::selectStudent).
						and(route(GET("/saveStudent"), StudentHandler::insertStudent)));
		ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer.create("localhost", 8080).newHandler(httpHandlerAdapter).block();
		System.in.read();*/
		SpringApplication.run(DemoApplication.class, args);
	}

}
