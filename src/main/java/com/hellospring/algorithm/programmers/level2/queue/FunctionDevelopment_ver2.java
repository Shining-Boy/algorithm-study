package com.hellospring.algorithm.programmers.level2.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment_ver2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();
        int pLen = progresses.length;
        int prevNeedDays = 0;

        int deployCnt = 0;
        for (int i=0; i<pLen; i++)
        {
            int needDays = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (needDays > prevNeedDays)
            {
                if (deployCnt>0)
                    result.add(deployCnt);

                prevNeedDays = needDays;
                deployCnt = 1;
            }
            else
                deployCnt++;
        }
        result.add(deployCnt);

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
