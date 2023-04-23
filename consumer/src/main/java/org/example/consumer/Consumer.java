package org.example.consumer;

import org.example.service.annotation.Operator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Consumer {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Set<Class> classes = findAllClasses("org.example.provider");
        Class[] classesArray = classes.toArray(new Class[0]);
        chooseMethod(classesArray);
    }

    private static void chooseMethod(Class[] classesArray) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        int choice=-2;
        while(choice!=-1) {
            printOptions(classesArray);
            choice = s.nextInt();
            var methods = classesArray[choice].getMethods();
            var instance = classesArray[choice].getConstructor().newInstance();
            if (methods[0].getReturnType().equals(double.class) && methods[0].getParameterCount() == 2) {
                System.out.println("write 2 numbers");
                double a = s.nextDouble();
                double b = s.nextDouble();
                var result = methods[0].invoke(instance, a, b);
                System.out.println(result);
            }
        }
    }

    private static void printOptions(Class[] classesArray) {
        System.out.println("choose one option");
        for (int i = 0; i < classesArray.length; i++){
            var annotation = (Operator) classesArray[i].getAnnotation(Operator.class);
            if(annotation!= null){
                var methods = classesArray[i].getMethods();
                for (var method : methods) {
                    if (method.getReturnType().equals(double.class) && method.getParameterCount() == 2) {
                        System.out.println(i + ": " + annotation.value());
                    }
                }
            }

        }
        System.out.println("-1: exit application");
    }

    private static Set<Class> findAllClasses(String packageName) throws IOException {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
