package bai06M2.Vd;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Vd3 {

	public static void main(String[] args) {
		double so=12345.67;
		System.out.println("So Java: "+so);
		
		Locale lcVN = new Locale("vi","VN");
		Locale lcUS = new Locale("en","US");
		
		NumberFormat nfVN = NumberFormat.getInstance(lcVN);
		System.out.println("So VN: "+nfVN.format(so));

		NumberFormat nfUS = NumberFormat.getInstance(lcUS);
		System.out.println("So US: "+nfUS.format(so));
		
		Date homNay = new Date();
		System.out.println("Ngay Java: "+homNay);
		
		DateFormat dfVN = DateFormat.getDateInstance(DateFormat.SHORT,lcVN);
		System.out.println("Ngay VN: "+ dfVN.format(homNay));

		DateFormat dfUS = DateFormat.getDateInstance(DateFormat.SHORT,lcUS);
		System.out.println("Ngay US: "+ dfUS.format(homNay));
		
		NumberFormat cfVN = NumberFormat.getCurrencyInstance(lcVN);
		System.out.println("So tien VN: "+cfVN.format(so));
		
		NumberFormat cfUS = NumberFormat.getCurrencyInstance(lcUS);
		System.out.println("So tien US: "+cfUS.format(so));
		
	}

}
