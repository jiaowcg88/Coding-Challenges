// String Compression: Implement a method to perform basic string compression using the counts of repeated characters. 
//For example, the string aabcccccaaa would become a2blc5a3. 
//If the "compressed" string would not become smaller than the original string, 
//your method should return the original string. You can assume the string has only uppercase and lowercase letters (a -z)

public class StringCompress {
	public static String stringCompress(String s) {
		if (s == null || s.length() == 0) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<s.length()-1; i++) {
			int count = 1;
			while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
				count++;
				i++;
			}
			sb.append(s.charAt(i));
			sb.append(String.valueOf(count));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"aabcccccaaa", "bbeffeeegggd"};
		for (String word : words) {
			System.out.println(stringCompress(word));
		}
	}
}