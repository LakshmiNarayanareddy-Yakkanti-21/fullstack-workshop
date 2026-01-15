package oop_advanced.registration;

import java.util.*;

public class UserService {

    private static Set<String> emails = new HashSet<>();

    public void register(User user) throws ValidationException {

        if (user.name.length() < 2)
            throw new ValidationException("Name too short");

        if (!user.email.contains("@"))
            throw new ValidationException("Invalid email");

        if (emails.contains(user.email))
            throw new DuplicateUserException("Email already registered");

        if (user.age < 13)
            throw new ValidationException("Must be 13+");

        emails.add(user.email);
    }
}
