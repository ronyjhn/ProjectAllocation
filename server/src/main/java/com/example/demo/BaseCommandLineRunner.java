package com.example.demo;

import com.example.demo.models.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class BaseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Java", "Python", "Golang", "Perl", "Lisp", "Erlang").forEach(name -> projectRepository.save(new Project(name)));

        System.out.println("Added Projects ");
        projectRepository.findAll().forEach(System.out::println);

    }
}
