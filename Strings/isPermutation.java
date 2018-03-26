// check permutation: Give two strings, write a method to decide if one is a permutation of the other
//
// 1st solution: since permutation meaning that characters in two string are same, but order is different
// therefore, we think we can sort characters in two strings, to see whether they are same or not
import java.util.Arrays;

public class IsPermutation {
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		char[] ca1 = s1.toCharArray();
		char[] ca2 = s2.toCharArray();
		Arrays.sort(ca1);
		Arrays.sort(ca2);
		return new String(ca1).equals(new String(ca2));	
	}
	public static void main(String[] args) {
		String s1 = "acded";
		String s2 = "ddeca";
		System.out.println(isPermutation(s1,s2));
	}
}

//2nd solution : time complexity: O(N)
// first check the length of two strings, if different, then return false
// else we visit the first character to the last of character, for the first string, we increase the frequence of each character
// then last step we again traverse the entire of the second string and decrease the counts, if the count is less than 0, then it means that it never occur in the first string
public class IsPermutation {
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int[] map = new int[128];
		for (int i = 0; i<s1.length(); i++) {
			map[(int)s1.charAt(i)]++;
		}
		for (char a : s2.toCharArray()) {
			if (--map[(int)a] < 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s1 = "acded";
		String s2 = "ddeca";
		System.out.println(isPermutation(s1,s2));
	}
}