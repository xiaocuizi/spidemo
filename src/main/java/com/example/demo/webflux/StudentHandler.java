package com.example.demo.webflux;

import org.springframework.beans.BeanUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * StudentHandler
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 18:03
 * @since 1.0.0
 */
public class StudentHandler {
    public static Mono<ServerResponse> selectStudent(ServerRequest request) {
        Student studentBody = new Student();
        request.bodyToMono(Student.class).subscribe(student -> BeanUtils.copyProperties(student, studentBody));
        return ok().contentType(APPLICATION_JSON_UTF8).body(fromObject(studentBody));
    }

    public static Mono<ServerResponse> insertStudent(ServerRequest request){
        return ok().contentType(TEXT_PLAIN).body(fromObject("success"));

    }
    private static class Student {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
