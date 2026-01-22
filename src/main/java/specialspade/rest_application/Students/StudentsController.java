package specialspade.rest_application.Students;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentsController {

    Logger logger = LoggerFactory.getLogger(StudentsController.class);
   private final StudentRepository repository;

   @Autowired
  public StudentsController(StudentRepository studentRepository) {this.repository = studentRepository;}


    @GetMapping("/students")
    public List<Student> students() {
        return  repository.findAll();
    }

    @GetMapping("/{id}")
    public Student student(@PathVariable Integer id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Student student) {
       if(student.getId() == null)
           repository.save(student);
       repository.insert(student.getId(), student.getLastName(), student.getFirstName(), student.getSchool(), student.getAge());
    }

    @PutMapping("")
    public void editStudent(@Valid @RequestBody Student student) {
        try {
            repository.save(student);
        } catch (StudentNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentID not found");
        }
    }

    @DeleteMapping("")
    public void delete(@Valid @RequestBody Student student) {
        try {
            repository.delete(student);
        } catch (StudentNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentID not found");
        }
    }
}
