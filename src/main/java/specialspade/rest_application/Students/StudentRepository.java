package specialspade.rest_application.Students;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends ListCrudRepository<Student, Integer> {

   @Query("""
        
            INSERT INTO students (id, lastname, firstname, age, school)
        VALUES (:id, :lastname, :firstname, :age, :school)
        """)
    void insert(@Param("id") Integer id, @Param("lastname") String lastname, @Param("firstname") String firstname,
                @Param("school") String school, @Param("age") Integer age);
}
