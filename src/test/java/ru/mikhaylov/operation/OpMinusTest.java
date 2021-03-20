package ru.mikhaylov.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpMinusTest {

    @Test
    void opMinusXY() {
        Assertions.assertEquals(4, OpMinus.opMinusXY(8,4));
    }
}