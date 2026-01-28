package com.hellospring.algorithm.programmers.level2.coding2018;
import java.util.*;

// 방문길이 코딩테스트
public class DoorLength {
    static class Pair {
        int x1, x2, y1, y2;

        Pair(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return x1 == p.x1 &&
                    x2 == p.x2 &&
                    y1 == p.y1 &&
                    y2 == p.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, x2, y1, y2);
        }
    }

    public int solution(String dirs) {
        int answer = 0;

        int curX = 0;
        int curY = 0;

        Set<Pair> set = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            int prevX = curX;
            int prevY = curY;

            switch (c) {
                case 'U': if (curY < 5) curY++; break;
                case 'D': if (curY > -5) curY--; break;
                case 'R': if (curX < 5) curX++; break;
                case 'L': if (curX > -5) curX--; break;
            }

            if (prevX == curX && prevY == curY) continue;

            Pair path = new Pair(prevX, curX, prevY, curY);

            if (set.contains(path)) continue;

            answer++;
            set.add(path);
            set.add(new Pair(curX, prevX, curY, prevY));
        }

        return answer;
    }

    public static void main(String[] args) {
        DoorLength f = new DoorLength();

        String dirs = "ULURRDLLU";

        int result = f.solution(dirs);
        System.out.println("result = " + result);
    }
}
