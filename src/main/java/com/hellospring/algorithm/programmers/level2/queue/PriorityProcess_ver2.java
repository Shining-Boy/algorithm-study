package com.hellospring.algorithm.programmers.level2.queue;

public class PriorityProcess_ver2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int firstIdx = 0;
        int pLen = priorities.length;

        int currentMax = 9;

        int[] NumberOfPriority = new int[10];
        for (int v : priorities) {
            NumberOfPriority[v]++;
        }
        for (int i=9; i>=0; i--)
        {
            if (NumberOfPriority[i] > 0)
            {
                currentMax = i;
                break;
            }
        }

        while(true)
        {
            if (priorities[firstIdx] < 0)
            {
                firstIdx = (firstIdx + 1) % pLen;
                continue;
            }

            int curPriority = priorities[firstIdx];
            if (curPriority >= currentMax)
            {
                answer++;

                if (location == firstIdx)
                    break;

                priorities[firstIdx] = -1;
                NumberOfPriority[curPriority]--;
                while (currentMax > 0 && NumberOfPriority[currentMax] == 0) {
                    currentMax--;
                }

            }
            firstIdx = (firstIdx + 1) % pLen;
        }

        return answer;
    }

    public static void main(String[] args) {
        PriorityProcess p = new PriorityProcess();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int result = p.solution(priorities, location);
        System.out.println("result = " + result);
    }
}
