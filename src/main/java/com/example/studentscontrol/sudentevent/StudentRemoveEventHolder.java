package com.example.studentscontrol.sudentevent;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentRemoveEventHolder extends ApplicationEvent {

    private final int id;

    public StudentRemoveEventHolder(Object source, int id) {
        super(source);
        this.id = id;
    }
}
