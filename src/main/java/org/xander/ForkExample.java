package org.xander;

import java.util.ArrayList;
import java.util.List;

public class ForkExample {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();

        int size = 300;
        for (int i = 1; i <= size; i++) {
            numbers.add((double)i);
        }
        long before = System.nanoTime();
        square(numbers);
        long after = System.nanoTime();
        System.out.println("recursion execution time of " + size + " elements is " + (after - before));

        System.out.println(numbers);
    }

    private static void square(List<Double> numbers) {
        if (numbers.size() < 2) {
            for (int i = 0; i < numbers.size(); i++) {
                numbers.set(i, Math.pow(numbers.get(i), 2));
            }
            return;
        }
        int middle = numbers.size() / 2;

        square(numbers.subList(0, middle));
        square(numbers.subList(middle, numbers.size()));
    }
}
