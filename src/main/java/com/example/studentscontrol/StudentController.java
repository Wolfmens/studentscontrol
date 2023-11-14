package com.example.studentscontrol;

import com.example.studentscontrol.sudentevent.StudentCreateEventHolder;
import com.example.studentscontrol.sudentevent.StudentRemoveEventHolder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Map;
import java.util.Random;

@ShellComponent
public class StudentController {

    private final Map<Integer,Student> studentMap;

    private final Random random = new Random();

    private final ApplicationEventPublisher publisher;

    public StudentController(ApplicationEventPublisher publisher, Map<Integer,Student> studentMap) {
        this.publisher = publisher;
        this.studentMap = studentMap;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        System.out.println("Select an action : " + "\n" +
                "show ->  show students list" + "\n" +
                "add ->  add student to list" + "\n" +
                "del ->  remove student from list by id" + "\n" +
                "clr ->  clear students list");
    }

    @ShellMethod(key = "show")
    public void showStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("Students list is empty");
        } else {
            System.out.println("Students list: ");
            for (Student student : studentMap.values()) {
                System.out.println(student);
            }
        }
    }

    @ShellMethod(key = "add")
    public void addStudentToList(@ShellOption(value = "FN") String firstName,
                                 @ShellOption(value = "LN") String lastName,
                                 @ShellOption(value = "AG") int age) {
        int studentId = GeneratedSettingsStudent.generateID();
        Student student = Student.builder().id(studentId).firstName(firstName).lastName(lastName).age(age).build();
        studentMap.put(studentId,student);
        publisher.publishEvent(new StudentCreateEventHolder(this,student));
    }

    @ShellMethod(key = "del")
    public void deleteStudentFromList(int id) {
        studentMap.remove(id);
        publisher.publishEvent(new StudentRemoveEventHolder(this,id));
    }

    @ShellMethod(key = "clr")
    public void clearStudentsList() {
        studentMap.clear();
        System.out.println("Student list has been cleared");
    }
}
