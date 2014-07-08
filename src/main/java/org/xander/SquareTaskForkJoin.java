package org.xander;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SquareTaskForkJoin extends RecursiveAction {
    private List<Double> numbers;

    SquareTaskForkJoin(List<Double> numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();

        int size = 300;
        for (int i = 1; i <= size; i++) {
            numbers.add((double)i);
        }
        SquareTaskForkJoin taskForkJoin = new SquareTaskForkJoin(numbers);
        long before = System.nanoTime();

//        taskForkJoin.compute();
        new ForkJoinPool().execute(taskForkJoin);
        taskForkJoin.join();

        long after = System.nanoTime();
        System.out.println("fork join execution time of " + size + " elements is " + (after - before));

        System.out.println(taskForkJoin);
    }

    @Override
    protected void compute() {
        if (numbers.size() < 300) {
            for (int i = 0; i < numbers.size(); i++) {
                numbers.set(i, Math.pow(numbers.get(i), 2));
            }
            return;
        }

        int middle = numbers.size() / 2;

        SquareTaskForkJoin left = new SquareTaskForkJoin(numbers.subList(0, middle));
        SquareTaskForkJoin right = new SquareTaskForkJoin(numbers.subList(middle, numbers.size()));

        invokeAll((RecursiveAction)left, (RecursiveAction)right);
    }
}