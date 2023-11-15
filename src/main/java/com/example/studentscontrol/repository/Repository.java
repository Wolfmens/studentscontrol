package com.example.studentscontrol.repository;

import org.springframework.shell.standard.ShellOption;

public interface Repository {

    void showStudentsFromList();
    void addStudentToList(String firstName, String lastName, int age);
    void deleteStudentFromList(int id);
    void clearStudentsList();

}
