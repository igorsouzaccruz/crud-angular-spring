package com.loiane.crudspring;

import com.loiane.crudspring.enums.Category;
import com.loiane.crudspring.model.Course;
import com.loiane.crudspring.model.Lesson;
import com.loiane.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			for(int i=0; i< 20; i++) {

				Course c = new Course();
				c.setName("Angular String " + i);
				c.setCategory(Category.FRONT_END);

				Lesson l1 = new Lesson();
				l1.setName("Introduçao");
				l1.setYoutubeUrl("watch?v=11");
				l1.setCourse(c);

				Lesson l2 = new Lesson();
				l2.setName("Angular");
				l2.setYoutubeUrl("watch?v=21");
				l2.setCourse(c);

				c.getLessons().add(l1);
				c.getLessons().add(l2);

				courseRepository.save(c);
			}
		};
	}
}
