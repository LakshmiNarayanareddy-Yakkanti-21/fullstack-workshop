package oop_advanced.registration;

public class RegistrationTest {

    public static void main(String[] args) {

        UserController controller = new UserController();

        Result r1 = controller.register("J", "bad", "123", 10);
        System.out.println(r1.errors);

        Result r2 = controller.register("Alice", "alice@email.com", "Secure123", 30);
        System.out.println(r2.message);
    }
}
