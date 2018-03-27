//One Away: There are three types of edits that can be performed on strings: 
//insert a character, remove a character, or replace a character. Given two strings, 
//write a function to check if they are one edit (or zero edits) away. 
//EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true pale, bae -> false 
//Solution to check three cases, 
//case 1, if the length of two strings are same, then we going to see whether there are more than one character different. if yes, then return false
//case 2, the s1's length less than s2's length, then we should know , s2 must contain s1
// case 3, the s1's length greater than s2's length, then we should know that s1 must contain s2 

public class OneAway {
	public static boolean isOneAway(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) >= 2) return false;
		int count = 0;
		if (s1.length() < s2.length()) {
			for (char c : s1.toCharArray()) {
				if (!s2.contains(c+"")) {
					return false;
				}
			}
		} else if (s1.length() > s2.length()) {
			for (char c : s2.toCharArray()) {
				if (!s1.contains(c + "")) {
					return false;
				}
			}
		} else {
			for (char c : s1.toCharArray()){
				if (!s2.contains(c + "")) {
					count++;
				}
			}
		}
		return count == 1 || count == 0;
	}

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "ple";
		String s3 = "pale";
		String s4 = "bae";
		String s5 = "pale";
		String s6 = "bale";
		String s7 = "bae";
		String s8 = "bale";
		System.out.println(isOneAway(s1,s2));
		System.out.println(isOneAway(s3,s4));
		System.out.println(isOneAway(s5,s6));
		System.out.println(isOneAway(s7,s8));

	}
}