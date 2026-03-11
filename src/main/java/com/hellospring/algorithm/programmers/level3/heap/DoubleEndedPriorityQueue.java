package com.hellospring.algorithm.programmers.level3.heap;

import com.hellospring.basicClass.DualPriorityQueue;

import java.util.Arrays;

public class DoubleEndedPriorityQueue {
    public int[] solution(String[] operations) {
        DualPriorityQueue dualPriorityQueue = new DualPriorityQueue();
        int minValue = 0;
        int maxValue = 0;

        for (int i=0; i<operations.length; i++)
        {
            String[] list = operations[i].split(" ");
            String firstValue = list[0];
            int secondValue =  Integer.parseInt(list[1]);
            if (firstValue.equals("I")) {
                dualPriorityQueue.insert(secondValue);
            }
            else {
                if(secondValue == 1) {
                    dualPriorityQueue.deleteMax();
                }
                else {
                    dualPriorityQueue.deleteMin();
                }
            }
        }

        if (!dualPriorityQueue.isEmpty()) {
            maxValue = dualPriorityQueue.getMax();
            minValue = dualPriorityQueue.getMin();
        }


        return new int[]{maxValue, minValue};
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue f = new DoubleEndedPriorityQueue();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = f.solution(operations);
        System.out.println("result = " + Arrays.toString(result));
    }
}
