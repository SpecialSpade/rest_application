package specialspade.rest_application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import specialspade.rest_application.Students.Student;
import specialspade.rest_application.Students.StudentRepository;

@SpringBootApplication()
@EnableJdbcRepositories(basePackages = "specialspade.rest_application.Students")

public class RestApplication {

	@GetMapping("")
	public String index() {
		return "index.html";
	}

	@GetMapping("/test")
	public String test() {
		return "pictures.html";
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student student = new Student(1, "Brown", "Marvin", 15, "First");
			studentRepository.save(student);
			studentRepository.save(new Student(null, "Smith", "Lisa", 12, "Third"));
			studentRepository.save(new Student(null, "Reese", "Brett", 13, "First"));
		};
	}
	*/

}

