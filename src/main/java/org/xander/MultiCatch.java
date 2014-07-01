package org.xander;

import java.io.File;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            File f = new File("some path");
            System.out.println(new String("new string"));
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try {
            File f = new File("some path");
            System.out.println(new String("new string"));
        } catch (ArithmeticException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }
}
