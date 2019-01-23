package bai08M2.Vd;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vd1 {
	private static void printFrom1to50() {
		String value = IntStream.range(1, 50).boxed().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(value);
	}
	
	private static void printFrom51to100() {
		String value = IntStream.range(50, 100).boxed().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		printFrom1to50();
		printFrom51to100();
	}

}
