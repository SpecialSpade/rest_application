package specialspade.rest_application.Students;

public class StudentNotFoundException extends IllegalArgumentException{

    public StudentNotFoundException(String e){
        super(e);
    }

}
