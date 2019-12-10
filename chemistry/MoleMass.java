package chemistry;

import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class MoleMass {
	//Splits apart a full Molecule and uses moleMass to find the Molecular Mass
	public MoleMass() {
		
	}
	public double totalMass (String in) throws Exception {
		ArrayList<Integer> arr = new ArrayList<>();
		Pattern p = Pattern.compile("\\d+");
		for (int x = 1; x < in.length(); x++) {
			if (Character.isUpperCase(in.charAt(x))) {
				in = in.substring(0, x) + " " + in.substring(x);
				x++;
			}
		}
		
		String[] elem = in.split(" ");
		for (int x = 0; x < elem.length; x++) {
			if (elem[x].length() == 1) {
				elem[x] = elem[x] + " ";
			}
		}
		Matcher m;
		int index;
		for (int k = 0; k < elem.length; k++) {
			m = p.matcher(elem[k]);
			if (m.find()) {
				arr.add(Integer.parseInt(m.group()));
				index = elem[k].indexOf(arr.get(k).toString());
				elem[k] = elem[k].substring(0, index) + elem[k].substring(arr.get(k).toString().length() + index);
			}
			else 
				arr.add(1);
		}
		for (int x = 0; x < elem.length; x++) {
			if (elem[x].length() <= 1) {
				elem[x] += " ";
			}
		}
		double[] mole = new double[elem.length];
		for (int x = 0; x < elem.length; x++) {
			mole[x] = moleMass(elem[x]);
		}
		double total = 0;
		for (int k = 0; k < mole.length; k++) {
			mole[k] *= arr.get(k);
			total += mole[k];
		}
		return total;
	}	
	//Finds the molecular mass for that specific molecule
	public double moleMass(String m) throws Exception {
		RandomAccessFile ram = new RandomAccessFile("ChemistryElement.txt", "r");
		String line = ram.readLine();
		String lineTwo = line.substring(0, 2);
		String lineThree = line.substring(3);
		double result = 0;
			for (int k = 0; !line.isBlank(); k++) {
				if (lineTwo.equals(m)) {
					result = Double.parseDouble(lineThree.strip());
					break;
				}
					line = ram.readLine();
					lineTwo = line.substring(0, 2);
					lineThree = line.substring(3);
			}
			ram.seek(0);
			line = ram.readLine();
			lineTwo = line.substring(0, 2);
			lineThree = line.substring(3);
		ram.close();
		return result;
	}
	
}
