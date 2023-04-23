package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operator;

@Operator("division")
public class Division implements Calculate {

    @Override
    public double result(double a, double b) {
        return a/b;
    }
}
