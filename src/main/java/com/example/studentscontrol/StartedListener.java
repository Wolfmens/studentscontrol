package com.example.studentscontrol;

import com.example.studentscontrol.config.ListSettingsStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConditionalOnProperty("app.event-create-list.enabled")
public class StartedListener {

    @Autowired
    private Map<Integer, Student> studentMap;

    @Autowired
    private ListSettingsStart listSettingsStart;

    @EventListener(ApplicationStartedEvent.class)
    public void createStartListStudents() {
        for (int i = 0; i < GeneratedSettingsStudent.generateCountStudents(); i++) {
            int id = GeneratedSettingsStudent.generateID();
            Student student = Student.builder()
                    .id(id).firstName(listSettingsStart.getNames().get(GeneratedSettingsStudent.generateNamesOrFamilyStudents()))
                    .lastName(listSettingsStart.getSurnames().get(GeneratedSettingsStudent.generateNamesOrFamilyStudents()))
                    .age(GeneratedSettingsStudent.generateAge())
                    .build();
            studentMap.put(id, student);
        }
    }
}
