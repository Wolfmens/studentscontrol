package com.example.studentscontrol.repository;

import com.example.studentscontrol.GeneratedSettingsStudent;
import com.example.studentscontrol.Student;
import com.example.studentscontrol.sudentevent.StudentCreateEventHolder;
import com.example.studentscontrol.sudentevent.StudentRemoveEventHolder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class RepositoryImpl implements Repository {

    private final Map<Integer, Student> studentMap;

    private final Random random = new Random();

    private final ApplicationEventPublisher publisher;

    public RepositoryImpl(ApplicationEventPublisher publisher, Map<Integer,Student> studentMap) {
        this.publisher = publisher;
        this.studentMap = studentMap;
    }


    @Override
    public void showStudentsFromList() {
        if (studentMap.isEmpty()) {
            System.out.println("Students list is empty");
        } else {
            System.out.println("Students list: ");
            for (Student student : studentMap.values()) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void addStudentToList(String firstName, String lastName, int age) {
        int studentId = GeneratedSettingsStudent.generateID();
        Student student = Student.builder().id(studentId).firstName(firstName).lastName(lastName).age(age).build();
        studentMap.put(studentId,student);
        publisher.publishEvent(new StudentCreateEventHolder(this,student));
    }

    @Override
    public void deleteStudentFromList(int id) {
        studentMap.remove(id);
        publisher.publishEvent(new StudentRemoveEventHolder(this,id));
    }


    @Override
    public void clearStudentsList() {
        studentMap.clear();
        System.out.println("Student list has been cleared");
    }
}
