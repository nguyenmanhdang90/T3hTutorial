package bai02M02.baiTap;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bai2_3 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Nguyen", "Manh", 10, 10, 8.8));
		students.add(new Student("Nguyen", "Dang", 11, 9, 7.7));
		students.add(new Student("Pham", "Manh", 12, 7, 5.3));
		students.add(new Student("Hong", "Dieu", 13, 6.5, 1.4));
		students.add(new Student("Dieu", "Dang", 14, 5.5, 9.5));
		students.add(new Student("Linh", "Dan", 15, 7.5, 6.6));
		students.add(new Student("Hoang", "Duc", 16, 4.5, 8.3));
		students.add(new Student("Duc", "Dang", 17, 3.5, 9.1));
		students.add(new Student("Dang", "Dan", 18, 2.5, 4.87));
		students.add(new Student("Dieu", "Duc", 19, 0, 10));
		students.stream().map(Student::toString).forEach(System.out::println);
		long studentOlderThan18 = students.stream()
				.map(Student::getAge)
				.filter(age -> age >= 18)
				.count();
		System.out.println("studentOlderThan18=" + studentOlderThan18);
		long studentFirstNameH = students.stream()
				.map(Student::getFirstName)
				.filter(Objects::nonNull)
				.filter(str -> str.startsWith("H"))
				.count();
		System.out.println("studentFirstNameH=" + studentFirstNameH);
		System.out.println(students.stream()
				.filter(stu -> stu.getFirstName().startsWith("H"))
				.map(Student::toString)
				.findFirst()
				.orElse("Khong tim thay"));
		DoubleSummaryStatistics statistic = students.stream()
				.mapToDouble(Student::diemTB)
				.summaryStatistics();
		System.out.println("dtb lon nhat="+ statistic.getMax());
		System.out.println("dtb nho nhat="+ statistic.getMin());
		System.out.println("Tb diem trung binh="+ statistic.getAverage());
		List<Student> excellentOne = students.stream()
				.filter(stu -> stu.diemTB() >=8)
				.collect(Collectors.toList());
		excellentOne.stream().map(Student::toString).forEach(System.out::println);
	}

}
