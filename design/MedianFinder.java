package design;
import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private boolean even;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<Integer>();
        even = true;
    }
    
    public void addNum(int num) {
        if (even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even)
            return (minHeap.peek() + maxHeap.peek())/2.0;
        else 
            return  minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */