package org.example.examples;


import java.lang.reflect.*;
import java.util.Arrays;

public class InvokeMain {

    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[]{int.class, int.class};
            Method add = c.getDeclaredMethod("add", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            add.invoke(null, Integer.parseInt(mainArgs[0]), Integer.parseInt(mainArgs[1]));
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
