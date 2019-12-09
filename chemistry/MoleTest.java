package chemistry;

public class MoleTest {
	public static void main(String[] args) throws Exception {
		MoleMass test1 = new MoleMass();
		double test = test1.totalMass("Au");
		System.out.println(test);
	}
}
