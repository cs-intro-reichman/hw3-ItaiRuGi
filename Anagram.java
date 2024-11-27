/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("null", "lolun"));//false
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
	
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String base = preProcess(str1);
		String check = preProcess(str2);
		if(base.length() != check.length()){
			return false;
		}
		for(int i = 0; i < base.length(); i++){
			if(charof(base.charAt(i), check) == -1){
				return false;
			}else{
				check = removefirstChar(base.charAt(i), check);
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String chng = "";
		for(int i = 0; i < str.length(); i ++){
			if((char)(str.charAt(i)) >= 65 && (char)(str.charAt(i)) <= 90){
				chng += (char)(str.charAt(i) + 32);
			}else if((char)(str.charAt(i)) >= 97 && (char)(str.charAt(i)) <= 122){
				chng += (char)(str.charAt(i));
			}
		}
		return chng;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newAnagram = "";
		String sideString = str;
		for(int i = 0; i < str.length(); i ++){
			if(sideString.length() == 1){
				newAnagram += sideString.charAt(0);
				return newAnagram;
			}else{
			int idx = (int)(Math.random()*(sideString.length()));
			newAnagram += sideString.charAt(idx);
			String spare = "";
			for(int j = 0; j < sideString.length(); j ++){
				if(j != idx){
					spare += sideString.charAt(j);
				}
			}
			sideString = spare;
			}
		}
		return "";
	}
	public static int charof(char let, String somet){ // returns the index of a given char in a string, or -1 if not in the string
		for(int i = 0; i < somet.length(); i ++){
			if(somet.charAt(i) == let){
				return i;
			}
		}
		return -1;
	}
	public static String removefirstChar(char rem, String inp){
		boolean removed = false;
		String ret = "";
		for(int i = 0; i < inp.length(); i ++){
			if(inp.charAt(i) != rem || (inp.charAt(i) == rem && removed == true)){
				ret += inp.charAt(i);
			}else if(inp.charAt(i) == rem && removed == false){
				removed = true;
			}
		}
		return ret;
	}
}

	