package com.cody.codeclash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cody.codeclash.repositories.ProblemRepository;

@SpringBootApplication
public class CodeclashApplication implements CommandLineRunner {

	@Autowired
	ProblemRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CodeclashApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Applcation is running ...");

		System.out.println("Problem count: " + repository.findAllWithDescription().size());
		repository.findAllWithDescription().forEach(System.out::println);

		System.out.println("Problem count: " + repository.count());
	}

	private static void displayProbems(ProblemRepository repository) {
		repository.findAllWithDescription().forEach(problem -> 
		System.out.print(problem.getId());
		)

		for (Problem problem : repository.findAllWithDescription()) {
			System.out.println(problem.getId());
			System.out.println(problem.getTitle());
			sout
			
		}
	};

}
