package com.sky.exception;

public class LessonPlanNotFoundException extends RuntimeException{
    public LessonPlanNotFoundException(String message) {
            super(message);
    }

}
