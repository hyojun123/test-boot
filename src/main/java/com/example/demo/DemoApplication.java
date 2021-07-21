package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public Integer cnt = 0;

    @GetMapping
    public String www() {
        cnt ++;

        if(cnt > 5) {
            System.exit(-1);
        }

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://192.168.30.100/user-service/", User.class).toString();
    }

}

class User {
    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "v1 == name : " + name + "& age : " + age;
    }
}
