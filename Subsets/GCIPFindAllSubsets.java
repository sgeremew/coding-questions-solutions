import java.util.*;

class FindSubsets {

	/*

	nums =  3 6 9

	3  6  9


	*/
	public static List<List<Integer>> findAllSubsets(int[] nums) {

		List<List<Integer>> setsList = new ArrayList<>();


		List<Integer> subset = new ArrayList<>();
		setsList.add(subset); // the empty set

		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {

			}
		}


		return setsList;
	}
}