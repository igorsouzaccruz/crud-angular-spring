package com.loiane.crudspring;

import com.loiane.crudspring.enums.Category;
import com.loiane.crudspring.model.Course;
import com.loiane.crudspring.model.Lesson;
import com.loiane.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			
			Course c = new Course();
			c.setName("Angular String");
			c.setCategory(Category.FRONT_END);

			Lesson l = new Lesson();
			l.setName("Introduçao");
			l.setYoutubeUrl("watch?v=3");
			l.setCourse(c);
			c.getLessons().add(l);

			courseRepository.save(c);
		};
	}

}
