package bai06M2.Vd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Vd1 {
	
	public static void main(String[] args) {
		
//		String input = "abccccc";
//		String regEx = "abc{5}";

//		String input = "abcbcbcbcbc";
//		String regEx = "a(bc){5}";

//		String input = "abcgxA";
//		String regEx = "abc...";
		
/*		String input = "bF5";
		String regEx = "[a-e][F-L][0-9]";*/
		String regex = "abc[";
		String str = "abc";
		try {
			Pattern pt = Pattern.compile(regex);
			Matcher match = pt.matcher(str);
			if(match.matches()) {
				System.out.println("hop le");
			} else {
				System.out.println("khong hop le");
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
