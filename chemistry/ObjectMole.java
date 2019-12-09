package chemistry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ObjectMole {
	
	double mole;
	double gram;
	double molecule;
	int round;
	final long num = (long) 6.02e23;
	
	public ObjectMole() {
		mole = 0;
		gram = 0;
		molecule = 0;
		round = 0;
	}
	public double MoleToGram (double mole, double gram) {
		gram /= mole;
		return gram;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
