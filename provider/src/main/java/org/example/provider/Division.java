package org.example.provider;

import org.example.service.Calculate;
import org.example.service.annotation.Operator;

@Operator("division")
public class Division implements Calculate {

    @Override
    public int result(int a, int b) {
        return a/b;
    }
}
