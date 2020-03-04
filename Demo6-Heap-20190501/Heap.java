package com.company;

public class Heap {
    private int size;
    private int[] heap;

    public Heap(int length) {
        size = 0;
        heap = new int[length];
    }

    private void siftDown(int k) {
        int tmp = heap[k];
        int child;

        // While child nodes are still accessible
        while (2*k <= size) {
            child = 2*k;

            if(child != size && heap[child] > heap[child + 1]) {
                child++;
            }

            if(tmp > heap[child]) {
                heap[k] = heap[child];
            }
            else {
                break;
            }

            k = child;
        }

        heap[k] = tmp;
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int min = heap[1];
        heap[1] = heap[size--];

        siftDown(1);

        return min;
    }

    public void insert(int x) {
        if(size == heap.length - 1) {
            doubleSize();
        }

        //Insert new item at the end of the array
        size += 1;
        int pos = size;

        // Shift up until heap property is restored
        while(pos > 1 && x < heap[pos/2]) {
            heap[pos] = heap[pos / 2];
            pos = pos/2;
        }

        heap[pos] = x;
    }

    private void doubleSize() {
        int[] old = heap;
        heap = new int[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }

    public void print() {
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
