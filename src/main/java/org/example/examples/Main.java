package org.example.examples;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c  = Class.forName("org.example.examples.Student");
        Field[] fields = c.getFields();
        printMembers(fields, "Campos");
        Constructor[] constructors = c.getConstructors();
        printMembers(constructors, "Constructores");
        printMembers(fields, "Campos");
        Method[] methods = c.getMethods();
        printMembers(methods, "Métodos");
    }

    private static void printMembers(Member[] mbrs, String s) {
        out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field) {
                out.format(" %s%n", ((Field) mbr).toGenericString());
            }else if (mbr instanceof Constructor) {
                out.format(" %s%n", ((Constructor) mbr).toGenericString());
            }else if (mbr instanceof Method) {
                out.format(" %s%n", ((Method) mbr).toGenericString());
            }
        }
        if (mbrs.length == 0) {
            out.format(" -- No %s --%n", s);
        }
        out.format("%n");
    }

    public static void add(int a, int b){
        System.out.println("a+b: " + (a+b));
    }

}