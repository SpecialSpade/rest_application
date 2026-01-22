package specialspade.rest_application.Students;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Useful when you dont want to use a db

@Repository
public class StudentRepositoryArrayList {

    private List<Student> students = new ArrayList<>();

    public List<Student> findAll(){
        return students;
    }

    public Student findById(Integer id){
        Optional<Student> student = students.stream().filter(e -> e.getId().equals(id)).findAny();
        return student.orElse(null);
    }


    @PostConstruct
    private void init(){
        students.add(new Student(1, "Brown", "Marvin", 15, "First"));
        students.add(new Student(2, "Smith", "Lisa", 12, "Third"));
        students.add(new Student(3, "Reese", "Brett", 13, "First"));
        students.add(new Student(4, "Jameson", "Daniel", 10, "Second"));
    }

    public void save(Student student){

        students.add(student);
    }

    public void edit(Student student) throws StudentNotFoundException{
        int index = students.indexOf(student);
        if(index == -1)
            throw new StudentNotFoundException("StudentID not found");
        students.set(index, student);
    }

    public void delete(Student student) throws StudentNotFoundException{
        boolean removed = students.remove(student);
        if (!removed)
            throw new StudentNotFoundException("StudentID not found");
    }




}
