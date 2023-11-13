package com.example.studentscontrol.sudentevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentRemoveEventListener {

    @EventListener
    public void listen(StudentRemoveEventHolder holder) {
        System.out.println("Student by ID " + holder.getId() + " was removed");
    }

}
