package org.xander;

public class SwitchEnhancement {
    public static void main(String[] args) {
        String name = "Jack";

        switch (name) {
            case "Marshall" : System.out.println("Name is Marshall");
            case "Hue" : System.out.println("Name is Hue");
//            case null : System.out.println("Compilation error");
            default: System.out.println("Name is Jack");
        }
    }
}
