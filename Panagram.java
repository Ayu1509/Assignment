import java.util.Scanner;

public class Panagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your input");
		String st = sc.next();
		boolean rs = checkPanagram(st);
		if (rs)
			System.out.println("Entered Sting is Panagram");
		else
			System.out.println("Not Panagram");
	}

	public static boolean checkPanagram(String st) {
		int[] count = new int[26];
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				count[ch - 65]++;
			}
			if (ch >= 'a' && ch <= 'z') {
				count[ch - 97]++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				return false;
		}
		return true;
	}

}