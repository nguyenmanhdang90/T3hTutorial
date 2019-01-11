package bai02M02.Vd;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Vd2 {
	
	public static void main(String[] args) {
		int[] m = {1,5,3,2,4,5,3,2};
		Arrays.stream(m)
				.filter(n -> n%2 == 0)
				.boxed()
				.collect(Collectors.toList())
				.forEach(System.out::print);
		IntSummaryStatistics statistic = Arrays.stream(m).summaryStatistics();
		System.out.println();
		System.out.println(statistic.getMin());
		for(int so:m)
			System.out.print(so+ " ");
		
		System.out.println();
		
		Arrays.stream(m).forEach(so->System.out.print(so+ " "));
		
		System.out.println("\nGia tri binh phuong tung phan tu mang");
		Arrays.stream(m).distinct().skip(3).map(i->i*i).forEach(so->System.out.print(so+ " "));
		
		System.out.println("\nCac phan tu so le cua mang m trong 5 phan tu dau tien");
		Arrays.stream(m).limit(5).filter(so->so%2!=0).sorted().forEach(so->System.out.print(so+ ", "));
		
		List<String> ds1 = Arrays.asList("class","abstract","interface","private","virtual","extends");
		
		System.out.println("\nTao danh sach ds2 chua cac chuoi co chieu dai >7 ky tu");
		List<String> ds2 = ds1.stream().filter(s->s.length()>7).collect(Collectors.toList());
		ds2.forEach(s->System.out.println(s));
	}


}
