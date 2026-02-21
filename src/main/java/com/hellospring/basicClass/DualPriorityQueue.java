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

        public boolean isEmpty()
        {
            return size == 0;
        }

        public int size()
        {
            return size;
        }

        public void push(int x)
        {
            ensureCapacity(size+1);
            heap[size] = x;
            siftUp(size);
            size++;
        }

        public int pop()
        {
            if (size == 0) throw new IllegalStateException("Heap is empty");

            int result = heap[0];
            heap[0] = heap[size-1];
            size--;
            if(size > 1) siftDown(0);

            return result;
        }

        public int peek()
        {
            if (size == 0) throw new IllegalStateException("Heap is empty");
            return heap[0];
        }

        private boolean better(int a, int b)
        {
            if(isMinHeap)
            {
                return a < b;
            }
            return a > b;
        }

        private void swap(int idx1, int idx2)
        {
            int temp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = temp;
        }

        private void ensureCapacity(int newSize)
        {
            if (newSize <= heap.length) return;

            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }

        private void siftUp(int idx)
        {
            if (idx <= 0) return;

            int parentIdx = (idx-1)/2;
            if (better(heap[idx], heap[parentIdx]))
            {
                swap(idx, parentIdx);
                siftUp(parentIdx);
            }
        }

        private void siftDown(int idx)
        {
            int leftIdx = idx * 2 + 1;
            int rightIdx = idx * 2 + 2;

            if (leftIdx >= size) return;
            int betterChildIdx = leftIdx;
            if (rightIdx < size && better(heap[rightIdx], heap[leftIdx]))
                betterChildIdx = rightIdx;

            if (better(heap[idx], heap[betterChildIdx])) return;
            swap(idx, betterChildIdx);
            siftDown(betterChildIdx);
        }
    }

}
