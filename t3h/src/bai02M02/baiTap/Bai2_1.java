package bai02M02.baiTap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bai2_1 {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Dang", "Nguyen", "", "aaa", "ngay", "t", "3", "h", "nguyen manh dang",
				"hom nay la thu 2", "happy","","     ","\n\r","ba la cay nen vang");
		long numberOfEmptyString = list1.stream()
				.filter(String::isEmpty)
				.count();
		System.out.println("numberOfEmptyString: "+numberOfEmptyString);
		long numberOfStrLongerThan5 = list1.stream()
				.filter(str -> str.length()>=5)
				.count();
		System.out.println("numberOfStrLongerThan5: "+numberOfStrLongerThan5);
		long numberOfStrStartWithA = list1.stream()
				.filter(str -> str.startsWith("a"))
				.count();
		System.out.println("numberOfStrStartWithA: "+numberOfStrStartWithA);
		long numberOfStrHappy = list1.stream()
				.filter("happy"::equalsIgnoreCase)
				.count();
		System.out.println("numberOfStrHappy: "+numberOfStrHappy);
		List<String> list2 = list1.stream()
				.filter(str -> !str.isEmpty())
				.collect(Collectors.toList());
		System.out.println(String.join(",", list2));
		List<String> list3 = list1.stream()
				.filter(str -> 3 <= str.length() && str.length() <= 6)
				.collect(Collectors.toList());
		System.out.println(String.join(",", list3));
		List<String> list4 = list1.stream()
				.map(str -> "happy"+ str)
				.collect(Collectors.toList());
		System.out.println(String.join(",", list4));
	}
}
