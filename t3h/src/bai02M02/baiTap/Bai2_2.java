package bai02M02.baiTap;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Bai2_2 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,0,11,12,13,14,15);
		List<Integer> list2 = list1.stream()
				.map(n->n*n)
				.collect(Collectors.toList());
		IntSummaryStatistics statistic = list2.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("max: "+ statistic.getMax());
		System.out.println("min: "+ statistic.getMin());
		System.out.println("sum: "+ statistic.getSum());
		System.out.println("average: "+ statistic.getAverage());
		List<Integer> list3 = list1.stream()
				.filter(Bai2_2::isPrimeNumber)
				.collect(Collectors.toList());
		System.out.println(String.join(",", list3.stream().map(n -> n.toString()).collect(Collectors.toList())));
		
		List<Integer> list4 = list1.stream()
				.filter(Bai2_2::isSquareNumber)
				.collect(Collectors.toList());
		System.out.println(String.join(",", list4.stream().map(n -> n.toString()).collect(Collectors.toList())));
	}
	
	public static boolean isSquareNumber(int n) {
		int a = (int) Math.sqrt(n);
		return a*a==n;
	}
	
	public static boolean isNotPrimeNumber(int n) {
		return !isPrimeNumber(n);
	}
	
	public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
