package com.hellospring.algorithm.programmers.level2.queue;

public class PriorityProcess {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int firstIdx = 0;
        int lastIdx = priorities.length - 1;
        int pLen = priorities.length;


        while(true)
        {
            if (priorities[firstIdx] < 0)
            {
                firstIdx = (firstIdx + 1) % pLen;
                continue;
            }

            int curPriority = priorities[firstIdx];
            if (checkMax(priorities, firstIdx, lastIdx, curPriority))
            {
                answer++;

                if (location == firstIdx)
                    break;

                priorities[firstIdx] = -1;
            }
            else
            {
                lastIdx = firstIdx;
            }
            firstIdx = (firstIdx + 1) % pLen;
        }

        return answer;
    }

    public boolean checkMax(int[] priorities, int firstIdx, int lastIdx, int priority)
    {
        int curIdx = firstIdx;
        while(curIdx!=lastIdx)
        {
            if(priorities[curIdx] > priority)
                return false;

            curIdx = (curIdx + 1) % priorities.length;
        }
        return true;
    }

    public static void main(String[] args) {
        PriorityProcess p = new PriorityProcess();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int result = p.solution(priorities, location);
        System.out.println("result = " + result);
    }
}