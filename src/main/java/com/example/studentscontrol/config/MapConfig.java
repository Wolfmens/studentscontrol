package com.example.studentscontrol.config;

import com.example.studentscontrol.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MapConfig {

    @Bean
    public Map<Integer, Student> studentMap() {
        return new HashMap<>();
    }
}
