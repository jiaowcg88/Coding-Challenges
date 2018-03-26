// description: Write a method to replace all spaces in a string with '%20'. 
//You may assume that the string has sufficient space at the end to hold the additional characters, 
//and that you are given the "true" length of the string. (Note: if implementing in Java, 
//please use a character array so that you can perform this operation in place.) 
//EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"

// Solution one to start the end of the string, if the current character is space, we add %20, else we replace it with the current character
// then keep it until the start the string, but final we should only take substring starts with j+1;
public class URLify {
	public static String replaceWithSt(String s, int length) {
		char[] ca = s.toCharArray();
		int j = s.length() - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (ca[i] == ' ') {
				ca[j] = '0';     //  4
				ca[--j] = '2';   //3
				ca[--j] = '%';   //2
			} else {
				ca[j] = ca[i];
			}
			j--;
		}
		return new String(ca).substring(j+1);
	}
	public static void main(String[] args) {
		String input =" Mr John Smith            ";
		int length = 14;
		System.out.println(replaceWithSt(input, length));
	}
}

// Solution 2 using same idea, the different is that first we should count the real spaces of the string except the end part of spaces
//then we start the end of the string, the idea is same as above
public class URLify {

	public static String replaceWithSt(String s, int length) {
		char[] ca = s.toCharArray();
		int count = 0;
		for (int i = 0; i<length; i++) {
			if (ca[i] == ' ') {
				count++;
			}
		}
		int index = length + count*2 - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (ca[i] == ' ') {
				ca[index] = '0';     //  4
				ca[--index] = '2';   //3
				ca[--index] = '%';   //2
			} else {
				ca[index] = ca[i];
			}
			index--;
		}
		return new String(ca);
	}
	public static void main(String[] args) {
		String input ="Mr John Smith            ";
		int length = 13;
		System.out.println(replaceWithSt(input, length));
	}
}