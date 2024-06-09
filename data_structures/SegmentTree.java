// Definition of a node interval
// [start, end] represents the range of the node interval
// max is the maximum value in the (start, end) interval of the node
// left, right are the left and right node intervals after the current node interval is divided

class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;

    // Constructor to initialize the node with start, end, and max values
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}


public class SegmentTree {

    // Function to build the segment tree from an array
    public SegmentTreeNode build(int[] A) {
        // Start building the segment tree from the full range of the array
        return buildhelper(0, A.length - 1, A);
    }

    // Helper function to build the segment tree
    private SegmentTreeNode buildhelper(int left, int right, int[] A) {
        // If left index is greater than right, return null (invalid range)
        if (left > right) {
            return null;
        }

        // Create a new node with the initial value from the left boundary of the interval
        SegmentTreeNode root = new SegmentTreeNode(left, right, A[left]);

        // If the current range is a single element, return the node
        if (left == right) {
            return root; // The value of this node is already set to A[left]
        }

        // Calculate the mid-point of the current range
        int mid = (left + right) / 2;

        // Recursively build the left and right subtrees
        root.left = buildhelper(left, mid, A);
        root.right = buildhelper(mid + 1, right, A);

        // Set the max value for the current node as the maximum of the left and right subtrees
        root.max = Math.max(root.left.max, root.right.max);

        // Return the constructed node
        return root;
    }

    // Function to query the maximum value in a given range [start, end]
    public int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            // If the query range fully covers the node range, return the node's max value
            return root.max;
        }

        // Calculate the mid-point of the current node's range
        int mid = (root.start + root.end) / 2;

        // Initialize the result to the minimum possible value
        int ans = Integer.MIN_VALUE;

        // If the query range overlaps with the left child, query the left subtree
        if (mid >= start) {
            ans = Math.max(ans, query(root.left, start, end));
        }

        // If the query range overlaps with the right child, query the right subtree
        if (mid + 1 <= end) {
            ans = Math.max(ans, query(root.right, start, end));
        }

        // Return the result
        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A = {1, 4, 2, 3};
        SegmentTree tree = new SegmentTree();
        SegmentTreeNode root = tree.build(A);

        // Query the maximum value in the range [1, 3]
        int result = tree.query(root, 1, 3);
        System.out.println("The maximum value in the range [1, 3] is: " + result);
        
        // You can add additional code here to test other queries, print values, etc.
    }
}

