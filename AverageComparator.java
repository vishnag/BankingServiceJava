package lab4;

import java.util.Comparator;
/**
 * 
 * @author Vishwas
 *based on income sorts the records in the file bank-details.
 */
public class AverageComparator implements Comparator<BankRecord>  {

	@Override
	public int compare(BankRecord obj1_lab3, BankRecord obj2_lab3) {
		Double Income1 = new Double(obj1_lab3.get_Income_lab4());
		Double Income2 = new Double(obj2_lab3.get_Income_lab4());		
		int res_lab3 =Income1.compareTo(Income2);
		return res_lab3;
	}

}
