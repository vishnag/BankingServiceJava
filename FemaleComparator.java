package lab4;

import java.util.*;
/**
 * 
 * @author Vishwas
 *This class sorts the records in the file bank-details based on the sex 
 */

public class FemaleComparator implements Comparator<BankRecord> {

	@Override
	public int compare(BankRecord arg_zero, BankRecord arg_one) {
		// TODO Auto-generated method stub
		
		int re_sult =arg_zero.getSex_lab3().compareTo(arg_one.getSex_lab3());
		return re_sult;
	}
	
}
