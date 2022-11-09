package sapronov.atm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class MainController {
    @GetMapping("/home")
    public String home(){
        return "Home";
    }
}
