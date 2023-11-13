package com.example.studentscontrol.sudentevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentCreateEventListener {

    @EventListener
    public void listen(StudentCreateEventHolder holder) {
        System.out.println("Created and added to list student " + holder.getStudent());
    }

}
