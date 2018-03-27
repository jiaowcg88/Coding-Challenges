// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. 
// A palindrome is a word or phrase  that is the same forwards and backwards. A permutation is a rearrangement of letters. 
// The palindrome does not need to be limited to just dictionary words. 
// EXAMPLE Input: Tact Coa Output: True (permutations: "taco  cat'; "atco eta·; etc.)

// Solution: use a int array to store the counts of each character, 
//palindrome meansing that all character should be even count expect at most of one character with odd count
public class PalindromePermutation {
	public static boolean PalindromePermutation(String s) {
		int[] map = new int[128];
		char[] ca = s.toLowerCase().toCharArray();
		for (char c : ca) {
			if (!Character.isLetter(c)) continue;
			map[(int)c]++;
		}
		int oddCount = 0;
		for (char c: ca) {
			if (!Character.isLetter(c)) continue;
			if (map[(int)c]%2 != 0) oddCount++;
		} 
		return oddCount <= 1;
	}

	public static void main(String[] args) {
		String[] words = {"Tact -coa", "Tacbc ba","abc"};
		for (String word : words) {
			System.out.println(PalindromePermutation(word));
		}
	}
}