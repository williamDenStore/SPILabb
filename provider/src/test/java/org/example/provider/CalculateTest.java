package org.example.provider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    @Test
    public void additionTest() {
        Addition addition = new Addition();
        double result = addition.result(2.0, 3.0);
        assertEquals(5.0, result, 0.0001);
    }
    @Test
    public void multiplicationTest(){
        Multiplication multiplication = new Multiplication();
        double result = multiplication.result(2.0,3.0);
        assertEquals(6,result,0.0001);
    }
    @Test
    public void subtraction(){
        Subtraction subtraction = new Subtraction();
        double result = subtraction.result(2.0,3.0);
        assertEquals(-1,result,0.0001);
    }
    @Test
    public void division(){
        Division division = new Division();
        double result = division.result(6.0,3.0);
        assertEquals(2,result,0.0001);
    }
}