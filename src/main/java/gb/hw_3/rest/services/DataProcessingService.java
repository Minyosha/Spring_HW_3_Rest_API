package gb.hw_3.rest.services;

import gb.hw_3.rest.domain.User;
import gb.hw_3.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    private UserRepository repository;
    private NotificationService notificationService;

    public UserRepository getRepository() {
        return repository;
    }

    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }

    public double calculateAverageAge(List<User> users) {
        notificationService.sendNotification("Calculate average age");
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        notificationService.sendNotification("Filter by age: older than " + age);
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<User> sortUsersByAge(List<User> users) {
        notificationService.sendNotification("Sorting by age");
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public DataProcessingService(UserRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }


}
