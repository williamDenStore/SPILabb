package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operator;

@Operator("multiplication")
public class Multiplication implements Calculate {


    @Override
    public int result(int a, int b) {
        return a*b;
    }
}
