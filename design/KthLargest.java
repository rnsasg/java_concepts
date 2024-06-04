package design;

import java.util.*;

class KthLargest {
    int k = 0;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for( int i : nums){
            pq.add(i);
        }
    }
    
    public int add(int val) {
        
        pq.add(val);

        if( pq.size() > this.k ){
            pq.remove();
        }

        return pq.peek();
    }

    public static void main(String args[]){

        KthLargest k = new KthLargest(3, new int[]{1, 2, 3, 4, 5});
        System.out.println(k.add(19));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */