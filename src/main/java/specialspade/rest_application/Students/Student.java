package specialspade.rest_application.Students;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("students")
public class Student {

    @Id
    @Column("id")
    private Integer id;
    @Column("lastname")
    private String lastName;
    @Column("firstname")
    private String firstName;
    @Column("school")
    private String school;
    @Column("age")
    private Integer age;

    public Student(Integer id, String lastName, String firstName, Integer age, String school) {

        this.school = school;
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSchool() {
        return school;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString(){
        return id + " " + lastName + " " + firstName + " " + age + " " + school;
    }



}
