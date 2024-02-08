package gb.hw_3.rest.controller;

import gb.hw_3.rest.domain.User;
import gb.hw_3.rest.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().addUserToList(user);
        return "User added from body";
    }

    @PostMapping("/param")
    public String userAddFromParam(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added from parameters";
    }

}
