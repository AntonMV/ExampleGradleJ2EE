package ru.mikhaylov.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void testToString() {
        Assertions.assertEquals("Worker",new Worker().toString());
    }
}