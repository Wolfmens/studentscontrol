package com.example.studentscontrol;

import java.util.Random;

public class GeneratedSettingsStudent {

    private final static Random random = new Random();

    private final static int START_NUMBER = 11111;
    private final static int FINISH_NUMBER = 99999;

    private final static int START_AGE = 10;
    private final static int FINISH_AGE = 65;


    public static int generateID() {
        return random.nextInt(START_NUMBER,FINISH_NUMBER);
    }

    public static int generateAge() {
        return random.nextInt(START_AGE,FINISH_AGE);
    }

    public static int generateNamesOrFamilyStudents() {
        return random.nextInt(9);
    }

    public static int generateCountStudents() {
        return random.nextInt(1,8);
    }

}
