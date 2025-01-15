package com.pedych.naimar.ui;

import com.pedych.naimar.service.NaimarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CLI implements CommandLineRunner {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${input.file}")
    private String input;

    private final NaimarService naimarService;

    public CLI(NaimarService naimarService) {
        this.naimarService = naimarService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(appName + " begin");

        Path path = Paths.get(input);
        naimarService.parseCsvToList(path)
                .forEach(System.out::println);

        System.out.println(appName + " end");
    }

}