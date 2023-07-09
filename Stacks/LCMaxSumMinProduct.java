class Solution {

/*

min_prod = min_val * array_sum

exampe: [3,2,5]
minProd = 2 * (3+2+5)
        = 2 * 10
        = 20

find the maximum min-product of any non-empty subbarray of nums
result can be large so return answer modulo 10^9 + 7 == 10000000007

note: min-product should be maximized before doing % operation for accuracy

[1,2,3,2]

1 2 3 2
1       = 1
1 2     = 3
1 2 3   = 6 
1 2 3 2 = 8
  2     = 4
  2 3   = 10
  2 3 2 = 14 // ans
    3   = 9
    3 2 = 10
      2 = 4

calculate suffix sums - sum of values after me

suffixsum = [7, 5, 2, 0]

monotonic increasing stack order
consider if this val is the min value in the subarray - how large can we make this
 subarray so that we can optimize this calculation!


*/


    public int maxSumMinProduct(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length + 1];

        // bulid prefix sums
        // note: suffix sums would seem good but doesn't help because
        //        when we pop intermeidate subarrays we need to know
        //        the sum of the values before the current one
        prefix[0] = 0;
        for(int i = 0; i < length; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
        // for(int i = 0; i < prefix.length; i++) {
        //     System.out.println(prefix[i]);
        // }
        //nums   = [1,2,3,2]
        //prefix = [0,1,3,6,8]


        // element = [start, minVal]
        Stack<int[]> monoStack = new Stack<>();
        int max = Integer.MIN_VALUE;

        // processes all subarrays and computes maximum minimum-products
        for(int i = 0; i < length; i++) {
            int newStart = i;
            // while stack is not empty and new element is in decreasing order
            //  assume this elements value is the minimum
            //  compute the subarray's minimum-product and store the result
            while(!monoStack.isEmpty() && monoStack.peek()[1] > nums[i]) {
                int[] element = monoStack.pop();
                int start = element[0];
                int minVal = element[1];

                // subarray sum from start to end
                // end is next element we were considering --> num[i] 
                // start is stored in the element we popped
                int subArraySum = prefix[i] - prefix[start];
                max = Math.max(max, minVal * subArraySum);
                System.out.println("max: " + max);
                newStart = start;
            }

            // stack is empty or new element is in increasing order
            monoStack.push(new int[]{newStart, nums[i]});
            // for(int[] element : monoStack) {
            //     System.out.println("[" + element[0] + ", " + element[1] + "]");
            // }
            // System.out.println("----");
        }

        for(int[] element : monoStack) {
            int start = element[0];
            int minVal = element[1];
            int subArraySum = prefix[length] - prefix[start];
            max = Math.max(max, minVal * subArraySum);
        }

        return max % (1000000007);
    }
}