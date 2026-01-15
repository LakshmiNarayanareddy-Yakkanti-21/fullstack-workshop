package oop_advanced.registration;

import java.util.List;

public class Result {
    boolean success;
    String message;
    List<String> errors;

    public Result(boolean success, String message, List<String> errors) {
        this.success = success;
        this.message = message;
        this.errors = errors;
    }
}
