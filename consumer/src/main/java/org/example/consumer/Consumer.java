package org.example.consumer;

import org.example.service.Calculate;
import org.example.service.annotation.Operator;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Consumer {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        run();
    }

    public static void run() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ServiceLoader<Calculate> loader = ServiceLoader.load(Calculate.class);
        List<Calculate> calculateList = new ArrayList<>();
        for(var a : loader){
            calculateList.add(a);
        }
        chooseMethod(calculateList.toArray());
    }

    private static void chooseMethod(Object[] classesArray) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        int choice;
        while(true) {
            printOptions(classesArray);
            choice =s.nextInt();
            if (choice==-1)
                break;
            var methods = classesArray[choice].getClass().getMethods();
            var instance = classesArray[choice].getClass().getConstructor().newInstance();
            if (methods[0].getReturnType().equals(double.class) && methods[0].getParameterCount() == 2) {
                System.out.println("write 2 numbers");
                double a = s.nextDouble();
                double b = s.nextDouble();
                var result = methods[0].invoke(instance, a, b);
                System.out.println(result);
            }
        }
    }

    private static void printOptions(Object[] classesArray) {
        System.out.println("choose one option");
        for (int i = 0; i < classesArray.length; i++){
            var annotation = (Operator) classesArray[i].getClass().getAnnotation(Operator.class);
            if(annotation!= null){
                var methods = classesArray[i].getClass().getMethods();
                for (var method : methods) {
                    if (method.getReturnType().equals(double.class) && method.getParameterCount() == 2) {
                        System.out.println(i + ": " + annotation.value());
                    }
                }
            }

        }
        System.out.println("-1: exit application");
    }
}
