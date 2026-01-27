package com.hellospring.algorithm.programmers.level2.queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();
        int numOfProg = progresses.length;
        int firstIdx = 0;
        while(firstIdx < numOfProg)
        {
            for (int i=firstIdx; i<numOfProg; i++)
                progresses[i] += speeds[i];

            int completeNum = 0;
            while (firstIdx < numOfProg && progresses[firstIdx] >= 100)
            {
                firstIdx++;
                completeNum++;
            }
            if (completeNum > 0)
                result.add(completeNum);

        }

        answer = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        FunctionDevelopment f = new FunctionDevelopment();

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = f.solution(progresses, speeds);
        System.out.println("result = " + Arrays.toString(result));
    }
}
