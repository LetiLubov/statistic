package com.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A service that displays information about developers in the world.
 * The main focus of the service to calculate data with statistics on the developers.
 * @author lyubov
 * created on 2018/09/01
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}