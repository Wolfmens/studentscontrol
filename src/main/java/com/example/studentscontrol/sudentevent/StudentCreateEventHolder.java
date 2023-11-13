package com.example.studentscontrol.sudentevent;

import com.example.studentscontrol.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentCreateEventHolder extends ApplicationEvent {

    private final Student student;

    public StudentCreateEventHolder(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
