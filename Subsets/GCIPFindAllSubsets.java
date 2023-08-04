import java.util.*;

class FindSubsets {

	/*

	nums =  3 6 9

	3    6    9

	               [] 
	          /          \
	        [3]          [6] 
	       /   \         /       
   	    [3,6]  [3,9]  [6,9] 
	   /
 	 [3,6,9] 

 	 * at each recursive step we add the current set
 	   and increment the position 'i'
 	   and recurse again
 	 * stop when i == nums.length

@backtrack
 setsList: [];
 set: [];
 currIndex: 0;
======
@backtrack
 setsList: [ [], ];
 set: [1, ];
 currIndex: 1;
======
@backtrack
 setsList: [ [],  [1, ], ];
 set: [1, 2, ];
 currIndex: 2;
======
@backtrack
 setsList: [ [],  [1, ],  [1, 2, ], ];
 set: [2, ];
 currIndex: 2;
======

	*/


	public static List<List<Integer>> findAllSubsets(int[] nums) {
		List<List<Integer>> setsList = new ArrayList<>();
		backtrack(setsList, new ArrayList<Integer>(), nums, 0);
		return setsList;
	}

	public static void backtrack(
		List<List<Integer>> setsList, List<Integer> set, int[] nums, int currIndex) {
			System.out.println("@backtrack");
			System.out.printf(" setsList: %s;\n set: %s;\n currIndex: %d;\n======\n", listofSetsToString(setsList), listToString(set), currIndex);

		setsList.add(new ArrayList<>(set));

		for(int i = currIndex; i < nums.length; i++) {
			set.add(nums[i]);
			backtrack(setsList, new ArrayList<>(set), nums, i + 1);
			set.remove(set.size() - 1);
		}
	}

	/** print a list */
	public static String listToString(List<Integer> list) {
		StringBuilder listStr = new StringBuilder();
		listStr.append("[");

		for(Integer num : list) {
			listStr.append(num);
			listStr.append(", ");
		}
		listStr.append("]");

		return listStr.toString();
	}

	/** print a list of lists */
	public static String listofSetsToString(List<List<Integer>> setsList) {
		StringBuilder listOfSets = new StringBuilder();
		listOfSets.append("[");

		for(List<Integer> list : setsList) {
			listOfSets.append(" [");
			for(Integer num : list) {
				listOfSets.append(num);
				listOfSets.append(", ");
			}
			listOfSets.append("], ");
		}
		listOfSets.append("]");

		return listOfSets.toString();
	}
}