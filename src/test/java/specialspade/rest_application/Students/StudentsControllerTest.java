package specialspade.rest_application.Students;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class StudentsControllerTest{

    @Test
    void createStudent(){
        Student testStudent = new Student(1, "Harden", "James", 15, "First");
    }

}