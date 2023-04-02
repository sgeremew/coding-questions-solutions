class CTCIArrayPermutation {


/**
 * Check Permutation:
 * Given two strings, write a method to decide if one is a permutation of the other.
 */

  /** 
   * version 1: compare sorted strings 
   * 
   * time: O(NlogN)
   * space: O(N)
   * */
	public boolean permutationSort(String str1, String str2) {
		return sort(str1).equals(sort(str2));
	}

  /** sort the chars in string and return the new sorted string */
  public String sort(String s) {
  	char[] letters = s.toCharArray();
  	java.util.Arrays.sort(letters);
  	return new String(letters);
  }


  /** 
   * version 2: use char hash array to count the chars in each string and check if they match
   * 
   * time: O(N)
   * space: O(1)
   * */
  public boolean permutationHash(String str1, String str2) {
  	if(str1.length() != str2.length()) return false;

  	int [] letterCount = new int[128]; // assumption about the breadth of possible characters

  	for(char c : str1.toCharArray()) {
  		letterCount[c]++;
  	}

  	for(int i = 0; i < str2.length(); i++) {
  		char c = str2.charAt(i);
  		letterCount[c]--;

  		if(letterCount[c] < 0) {
  			return false;
  		}
  	}

  	return true;
  }

}




