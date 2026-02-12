package com.hellospring.algorithm.programmers.level3.heap;

import com.hellospring.algorithm.programmers.level2.queue.FunctionDevelopment;

import java.util.Arrays;

public class DoubleEndedPriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        DoubleEndedPriorityQueue f = new DoubleEndedPriorityQueue();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = f.solution(operations);
        System.out.println("result = " + Arrays.toString(result));
    }
}
