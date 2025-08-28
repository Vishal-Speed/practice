package com.example.records;

import java.util.Collections;
import java.util.List;

public record Student(int studentId, String name, Integer age, String mobile, List<String> hobbies) {
    public Student {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        /*if (mobile.length() != 10) {
            throw new IllegalArgumentException("Mobile number must be of 10 digits");
        }*/
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        hobbies = List.copyOf(hobbies);
    }
}
