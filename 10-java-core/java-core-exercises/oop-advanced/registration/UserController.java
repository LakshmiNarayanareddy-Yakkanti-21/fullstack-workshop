package oop_advanced.registration;

import java.util.*;

public class UserController {

    private UserService service = new UserService();

    public Result register(String name, String email, String password, int age) {
        List<String> errors = new ArrayList<>();

        try {
            User u = new User();
            u.name = name;
            u.email = email;
            u.password = password;
            u.age = age;

            service.register(u);
            return new Result(true, "User registered successfully", null);

        } catch (ValidationException | DuplicateUserException e) {
            errors.add(e.getMessage());
            return new Result(false, null, errors);
        }
    }
}
