import java.util.*;
public class Main{
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(setOfIntegers, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    public static void backtrack(List<Integer> setOfIntegers, int targetSum,
     int currIndex, List<List<Integer>> result, List<Integer> currList) {

        if(targetSum == 0) {
            //add this combo to the set
            result.add(new ArrayList<>(currList));
            return;
        }

        if(targetSum < 0) return;

        for(int i = currIndex; i < setOfIntegers.size(); i++) {
            currList.add(setOfIntegers.get(i));
            backtrack(setOfIntegers, targetSum - setOfIntegers.get(i), currIndex + 1, result, currList);
            currList.remove(currList.size() - 1);
        }

    }


/*
one thought is to sort the array in decsending order so we can exclude any number larger than target
sum immediately

goals
time: O(2^n)
space: O(1)

1  3  5  21  19  7  2
k=10


1
    3
        5
            21X
        5
            19X
        ...
    3
        21X
    ...
    ...
    7
        2 == 10 >> add this list to results [1,3,2] (use arraylist and when backtracking remove last element)
use for loop to go through array        


*/



}