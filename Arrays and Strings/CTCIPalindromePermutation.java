class CTCIPalindromePermutation {


	/**
	 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of 
	 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A 
	 * permutation is a rearrangement of letters. The palindrome does not need to be limited to 
	 * just dictionary words.
	 * 
	 */ 

	/**
	 * Solution 1: count the number of characters in the string, ensure only 1 character occurs only once
	 * while all others occur an even amount
	 * 
	 * time: O(N)
	 * space: O(1)
	 * 
	 * Note: there are some tweaks and there are other solutions but this one is simple and has essentially 
	 * the best time and space complexity anyways
	 */ 
	public boolean palindromePermutation(String str) {
		int[] letterCount = new int[128]; //assumption about breadth of chars

		for(char c : str.toCharArray()) {
			letterCount[c]++;
		}


		// palidromes can only no more than 1 character occur only once
		// e.g. racecar -- the 'e' occurs only once yet this is a palindrome
		// e.g. runner -- the 'u' and 'e' occur only once but this is not a palindrome
		int oddCount = 0;
		for(int i = 0; i < letterCount.length; i++) {
			if(letterCount[i] % 2 > 0) {
				oddCount++;
			}
			if(oddCount > 1) {
				return false;
			}
		}
		return true;
	}
}