package bai06M2.Vd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vd2 {
	
	public static void main(String[] args) {
		String s = "mai,lan;cuc:truc";
		String[] m = s.split(",|;|:");
		for(String ss:m) {
			System.out.println(ss);
		}
		
		String input = "meo me meo con cung keu meo meo";
		String regEx = "meo";
		
		Pattern pt = Pattern.compile(regEx);
		Matcher mc = pt.matcher(input);
		
		String s2 = mc.replaceAll("cho");
		System.out.println(s2);
	}

}
