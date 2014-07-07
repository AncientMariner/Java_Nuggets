package org.xander;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomsExample {
    public static void main(String[] args) {
        double rnd = Math.random();
        Random r = new Random();
        double tlr = ThreadLocalRandom.current().nextDouble();
        System.out.println("math                " + rnd
                + "\nrandom              " + Double.valueOf(r.nextDouble())
                + "\nthread local random " + tlr);
    }
}
