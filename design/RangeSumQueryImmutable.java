package design;


public class RangeSumQueryImmutable {

    int []prefix;
    int []suffix;
    int []array;

    public RangeSumQueryImmutable(int[] nums) {

        this.prefix = nums.clone();
        this.suffix = nums.clone();
        this.array = nums.clone();
        
        for (int i=1;i<nums.length;i++) {
            this.prefix[i] += this.prefix[i-1];
        }

        for (int i=nums.length-2;i>=0;i--) {
            this.suffix[i] += this.suffix[i+1];
        }
    }
    
    public int sumRange(int left, int right) {
        return this.suffix[right] - this.prefix[left];
    }
}

