package lab4;

import java.util.Comparator;
/**
 * 
 * @author Vishwas
 *records are sorted based on the sex
 */
public class MaleComparator implements Comparator<BankRecord> {

	@Override
	public int compare(BankRecord obj_onw, BankRecord obj_two) {
		// TODO Auto-generated method stub
		int result =obj_onw.getSex_lab3().compareTo(obj_two.getSex_lab3());
		return result;
	}

}
