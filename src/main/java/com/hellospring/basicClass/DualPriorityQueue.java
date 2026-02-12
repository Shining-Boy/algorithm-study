package com.hellospring.basicClass;

public class DualPriorityQueue {

    private static class IntHeap {
        private int[] heap;
        private int size;
        private final boolean isMinHeap;

        public IntHeap(boolean isMinHeap)
        {
            this.isMinHeap = isMinHeap;
            this.heap = new int[16]; // 초기사이즈. 가변적으로 확장 가능
            this.size = 0;
        }
    }

}
