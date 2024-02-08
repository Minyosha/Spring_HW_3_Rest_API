package gb.hw_3.rest.services;

import gb.hw_3.rest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public User processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotification("User added: " + newUser.getName());

        return newUser;
    }


}