package com.example.studentscontrol.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConditionalOnProperty("app.event-create-list.enabled")
@ConfigurationProperties(prefix = "students-settings")
public class ListSettingsStart {

    private List<String> names;
    private List<String> surnames;
}
