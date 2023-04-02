class CTCIArray {


/**
 * Check Permutation:
 * Given two strings, write a method to decide if one is a permutation of the other.
 */ 
  public boolean perm(String str1, String str2) {
  	Map<String, Integer> permCheck = new HashMap<>();

  	for(int i = 0; i < str1.length(); i++) {
  		permCheck.put(str1.charAt(i), permCheck.getOrDefault(str1.charAt(i), 0) + 1);
  	}

  	for(i = 0; i < str2.length(); i++) {
  		if(permCheck.has(str2.charAt(i))) {
  			permCheck.put(str2.charAt(i), permCheck.get(str2.charAt(i)) - 1);
  		} else {
  			return false;
  		}

  		if(permCheck.get(str2.charAt(i)) == 0) {
  			permCheck.remove(str2.charAt(i));
  		}
  	}

  	return permCheck.size() == 0;
  }

  public boolean permV2(String str1, String str2) {
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




