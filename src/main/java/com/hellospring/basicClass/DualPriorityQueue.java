package com.hellospring.basicClass;

import java.util.HashMap;
import java.util.Map;

public class DualPriorityQueue {
    private final IntHeap minHeap;
    private final IntHeap maxHeap;
    private final Map<Integer, Integer> countMap;
    private int validSize;

    public DualPriorityQueue() {
        this.minHeap = new IntHeap(true);
        this.maxHeap = new IntHeap(false);
        this.countMap = new HashMap<>();
        this.validSize = 0;
    }

    public void insert(int x) {
        minHeap.push(x);
        maxHeap.push(x);
        int cnt = countMap.containsKey(x) ? countMap.get(x) + 1 : 1;
        countMap.put(x, cnt);
        validSize++;
    }

    public void deleteMin() {
        if (validSize == 0) return;

        removeValid(minHeap);
        validSize--;
    }

    public void deleteMax() {
        if (validSize == 0) return;

        removeValid(maxHeap);
        validSize--;
    }

    public Integer getMin() {
        if (validSize == 0) return null;

        cleanTop(minHeap);

        return minHeap.peek();
    }

    public Integer getMax() {
        if (validSize == 0) return null;

        cleanTop(maxHeap);

        return maxHeap.peek();
    }

    public int size() {
        return validSize;
    }

    public boolean isEmpty(){
        return validSize == 0;
    }

    private void removeValid(IntHeap heap)
    {
        cleanTop(heap);

        int val = heap.pop();
        int cnt = countMap.get(val);
        if (cnt == 0) countMap.remove(val);
        else countMap.put(val, cnt - 1);
    }

    private void cleanTop(IntHeap heap)
    {
        while(!heap.isEmpty())
        {
            int val = heap.peek();
            if (countMap.containsKey(val)) return;
            heap.pop();
        }
    }

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
