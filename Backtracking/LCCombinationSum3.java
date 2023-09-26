class Solution {

    /*
            123
       /     |     \
      1      2      3
     /  \      \           
    2    3      3            
    |                            
    3     

                                                  12345
                            /                 /         \     \     \
                       1                      2          3       4    5
               /     /     \   \          /   |   \     /  \      \   
         2          3       4   5       3     4    5   4    5      5
      /  |  \      / \      |         /  \     \        \  
     3   4   5    4   5     5        4    5     5        5
    / \   \        \                  \
   4   5   5        5                  5
  /
 5
 


    recursive function
    starts at 1 goes to 9
    each time we explore path first 1 then 2 and so on
    if we sum to target, store the path
    else backtrack

    path=[], res=[[]], target=7, k=3
    path=[1], res=[[]], target=6, k=2
    path=[1,2], res=[[]], target=4, k=1
    path=[1,2,3], res=[[]], target=1, k=0 XXX
    backtrack
    path=[1,2,4], res=[[]], target=0, k=0 GOOD
    add path to result
    backtrack
    backtrack
    path=[1], res=[[1,2,4]], target=6, k=2
    path=[1,3], target=3, k=2
    path=[1,3,4], target=-1, k=1
    backtrack
    backtrack

    */

    public List<List<Integer>> combinationSum3(int k, int n) {
        // k numbers that sum up n
        // each number is between 1-9

        //[1,2,3,4,5,6,7,8,9]
        // only use k numbers to sum up to n
        // n=7, k=3

        List<List<Integer>> result = new ArrayList<>();
        recursion(k, n, 1,new ArrayList<Integer>(), result);
        return result;
    }

    public void recursion(int limit, int target, int num, List<Integer> path, List<List<Integer>> result) {
        System.out.printf("limit:%d, target:%d, path:%s, result:%s\n",
         limit, target, list1DToString(path), list2DToString(result));
        if(limit == 0 && target == 0) {
            //solution found
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(limit <= 0 || target <= 0) {
            //bad
            return;
        }
        for(int i = num; i < 10; i++) {
            // choose i
            path.add(i);
            recursion(limit-1, target-i, i+1, path, result);
            // backtrack, remove i
            path.remove(path.size() - 1);
        }
    }

    // PRINT FOR TESTING
    public String list1DToString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if(i<path.size()-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public String list2DToString(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < result.size(); i++) {
            sb.append(list1DToString(result.get(i)));
            if(i<result.size()-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}