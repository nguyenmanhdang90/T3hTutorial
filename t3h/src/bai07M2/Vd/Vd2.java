package bai07M2.Vd;

class Singleton {
	private static Singleton singlton = new Singleton();

	private Singleton() {
	}

	public static Singleton getSinglton() {
		return singlton;
	}
}

public class Vd2 {
	public static void main(String[] args) {
		Singleton sgt1 = Singleton.getSinglton();
		Singleton sgt2 = Singleton.getSinglton();
		System.out.println(sgt1.equals(sgt2));
		
	}
}
