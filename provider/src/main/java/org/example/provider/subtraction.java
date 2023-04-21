package org.example.provider;

import org.example.service.Calculate;

public class subtraction implements Calculate {
    @Override
    public int sum(int a, int b) {
        return a-b;
    }
}
