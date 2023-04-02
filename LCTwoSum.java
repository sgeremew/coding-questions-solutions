class LCTwoSum {

    /**
     * Two Sum: Given an array of integers nums and an integer target, return indices of the two 
     * numbers such that they add up to target. 
     * You may assume that each input would have exactly one solution, and you may not use the 
     * same element twice. 
     * You can return the answer in any order.
     */

    /**
        nums[a] + nums[b] = target
        target - nums[a] = nums[b]
        target - nums[a] = complement

        [3,2,4] target = 6
        key: complement, value: a
        {   
            t-a=b
            6-3=3: 0,
            6-2=4: 1,
            6-4=2: 2
        }

        check for complement first,
            exists? get result
            none? store key,value as complement,a

        time: O(N)
        space: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(complementMap.containsKey(nums[i])) {
                return new int[]{complementMap.get(nums[i]), i};
            }
            complementMap.put(target - nums[i], i);
        }

        return null;   
    }
}