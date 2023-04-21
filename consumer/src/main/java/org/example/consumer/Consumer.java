package org.example.consumer;

import org.example.service.Calculate;

import java.util.ServiceLoader;

public class Consumer {
    public static void main(String[] args) {
        ServiceLoader<Calculate> calculates = ServiceLoader.load(Calculate.class);

        for (var calculate : calculates){
            System.out.println(calculate.result(3,2));
        }
    }
}
