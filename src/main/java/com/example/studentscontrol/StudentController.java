package com.example.studentscontrol;

import com.example.studentscontrol.repository.RepositoryImpl;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class StudentController {

    private RepositoryImpl repository;

    public StudentController(RepositoryImpl repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void start() {
        System.out.println("Select an action : " + "\n" +
                "show ->  show students list" + "\n" +
                "add ->  add student to list" + "\n" +
                "del ->  remove student from list by id" + "\n" +
                "clr ->  clear students list");
    }

    @ShellMethod(key = "show")
    public void showStudents() {
        repository.showStudentsFromList();
    }

    @ShellMethod(key = "add")
    public void addStudentToList(@ShellOption(value = "FN") String firstName,
                                 @ShellOption(value = "LN") String lastName,
                                 @ShellOption(value = "AG") int age) {
       repository.addStudentToList(firstName,lastName,age);
    }

    @ShellMethod(key = "del")
    public void deleteStudentFromList(int id) {
      repository.deleteStudentFromList(id);
    }

    @ShellMethod(key = "clr")
    public void clearStudentsList() {
       repository.clearStudentsList();
    }
}
