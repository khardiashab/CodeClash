package com.cody.codeclash;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cody.codeclash.entities.Problem;
import com.cody.codeclash.entities.Tag;
import com.cody.codeclash.repositories.DescriptionRepository;
import com.cody.codeclash.repositories.ProblemRepository;
import com.cody.codeclash.repositories.TagRepository;
import com.google.gson.Gson;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class CodeclashApplication implements CommandLineRunner {

	@Autowired
	ProblemRepository repository;

	@Autowired
	DescriptionRepository descriptionRepository;

	@Autowired
	TagRepository tagRepository;

	private static final Gson gson = new Gson();

	public static void main(String[] args) {
		SpringApplication.run(CodeclashApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// saveData(repository, tagRepository, descriptionRepository);
		System.out.println("Applcation is running ...");

		tagRepository.findAll().forEach(t -> {

			displayTag(t);
		});
		repository.findAll().forEach(p -> {

			displayProblem(p);

		});

	}

	private static void saveData(ProblemRepository repository, TagRepository tagRepository2,
			DescriptionRepository descriptionRepository2) {
		Tag tag = new Tag();
		tag.setName("Java");

		Tag tag2 = new Tag();
		tag2.setName("C++");

		tagRepository2.save(tag);
		tagRepository2.save(tag2);

		Problem problem = new Problem();
		problem.setTitle("Sample Problem");
		problem.setTags(Set.of(tag, tag2));

		repository.save(problem);
	}

	private static void displayTag(Tag tag) {
		System.out.println(tag.getId() + " " + tag.getName());
	}

	private static void displayProblem(Problem problem) {
		System.out.println(
				problem.getId() + " " +
						problem.getTitle() + " ");
		problem.getTags().forEach(
				t -> displayTag(t));
	}

}
