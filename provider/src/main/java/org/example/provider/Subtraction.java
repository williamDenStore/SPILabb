package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operator;

@Operator("subtraction")
public class Subtraction implements Calculate{
    public int result(int a, int b) {
        return a-b;
    }
}
