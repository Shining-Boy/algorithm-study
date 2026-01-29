package com.hellospring.algorithm.programmers.level2.coding2018;
import java.util.*;

// 방문길이 코딩테스트
public class DoorLength_ver2 {
    static class Line {
        int x1, x2, y1, y2;

        Line(int ax, int bx, int ay, int by) {
            if (ax < bx || (ax == bx && ay < by))
            {
                this.x1 = ax;
                this.x2 = bx;
                this.y1 = ay;
                this.y2 = by;
            }
            else
            {
                this.x1 = bx;
                this.x2 = ax;
                this.y1 = by;
                this.y2 = ay;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Line)) return false;
            Line p = (Line) o;
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

        Set<Line> set = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            int prevX = curX;
            int prevY = curY;

            switch (c) {
                case 'U': if (curY < 5) curY++; break;
                case 'D': if (curY > -5) curY--; break;
                case 'R': if (curX < 5) curX++; break;
                case 'L': if (curX > -5) curX--; break;
            }

            if (prevX == curX && prevY == curY) continue;

            Line path = new Line(prevX, curX, prevY, curY);

            if (set.contains(path)) continue;

            answer++;
            set.add(path);
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
