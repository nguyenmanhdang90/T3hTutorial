package bai02M2.Vd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Vd1 {

	public static void main(String[] args) {
		int[] m = { 1, 5, 3, 2, 4, 5, 6 };
		int tong1 = Arrays.stream(m).limit(3).sum();
		System.out.print("tong1 = " + tong1);

		System.out.println();
		List<String> ds = Arrays.asList("mai", "lan", "cuc", "truc");
		ds.stream().forEach(s -> System.out.print(s + " "));

		System.out.println();
		Stream<Double> l2 = Stream.of(1.5, 3.2, 4.6, 9.3, 7.1);
		int sopt = (int) l2.count();
		System.out.println("So phan tu luong l2 =" + sopt);
	}
}
