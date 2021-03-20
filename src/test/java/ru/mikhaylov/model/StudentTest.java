package ru.mikhaylov.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testToString() {
        Assertions.assertEquals("Student",new Student().toString());
    }
}