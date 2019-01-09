package bai02M02.baiTap;

public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private double mark1;
	private double mark2;

	public Student(String firstName, String lastName, int age, double mark1, double mark2) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}

	public double diemTB() {
		return (this.mark1 + this.mark2) / 2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMark1() {
		return mark1;
	}

	public void setMark1(double mark1) {
		this.mark1 = mark1;
	}

	public double getMark2() {
		return mark2;
	}

	public void setMark2(double mark2) {
		this.mark2 = mark2;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", mark1=" + mark1
				+ ", mark2=" + mark2 + ", DTB=" + diemTB() + "]";
	}

}
