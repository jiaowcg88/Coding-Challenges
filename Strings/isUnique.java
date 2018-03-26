// check whether the characters of string are unique
// have a boolean array with size 128, initilized the array with false, if we visited the character, we mark as true
// if we found it true, then meaning that it occur twice, return false
public class IsUnique {
	public static boolean isUnique(String s) {
		if (s.length() > 128) return false;
		boolean[] map = new boolean[128];
		for (char a : s.toCharArray()) {
			if (map[(int)a]) return false;
			map[(int)a] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] input = {"abcd", "adbb", "adcef","efff","--ab"};
		for (String st : input) {
			System.out.println(st + "\t " + isUnique(st));
		}
	}
}

// the second solution is to have a int array store the frequence of the characters occuring the array
// the initialize of each uniquc character should be 0, if it is not 0, then meaning it occurs before.
public class IsUnique {
	public static boolean isUnique(String s) {
		if (s.length() > 128) return false;
		int[] map = new int[128];
		for (char a : s.toCharArray()) {
			if (map[(int)a] != 0) return false;
			map[(int)a]++;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] input = {"abcd", "adbb", "adcef","efff","--ab"};
		for (String st : input) {
			System.out.println(st + "\t " + isUnique(st));
		}
	}
}