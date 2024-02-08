package gb.hw_3.rest.services;

import gb.hw_3.rest.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification (String s) {
        System.out.println(s);
    }
}
