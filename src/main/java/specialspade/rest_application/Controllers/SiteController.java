package specialspade.rest_application.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteController {


    @GetMapping("/pictures")
    public String pictures(){
        return "pictures";
    }
}
