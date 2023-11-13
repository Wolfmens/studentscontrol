package com.example.studentscontrol;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    @Override
    public String toString() {
        return "Id student " + id + " with firstname " + firstName + ", lastname " + lastName + ", and age " + age;
    }
}
