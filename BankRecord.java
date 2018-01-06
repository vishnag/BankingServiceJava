package lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Vishwas
 *  This class utilizes the abstract methods declared in the abstract class client and generates client record from the csv file.
 */
public class BankRecord extends Client {
	static BankRecord[] bankObject_lab = new BankRecord[600];
	
	// creating a array list doing a list inside a list
	protected static List<List<String>> arr_ay_lab3 = new ArrayList<>();
	// instance variables
	private String id_lab3;
	private int age_lab3;
	private String sex_lab3;
	private String region_lab3;
	private double income_lab3;
	private String married_lab3;
	private int children_lab3;
	private String car_lab3;
	private String save_act_lab3;
	private String current_act_lab3;
	private String mortgage_lab3;
	private String pep_lab3;
	
	public String getMarried_lab3() {
		return married_lab3;
	}

	public void setMarried_lab3(String married) {
		this.married_lab3 = married;
	}

	public int getChildren_lab3() {
		return children_lab3;
	}

	public void setChildren_lab3(int children) {
		this.children_lab3 = children;
	}

	public String getCar_dat_lab() {
		return car_lab3;
	}

	public void setCar_dat_lab(String cars_lab3) {
		this.car_lab3 = cars_lab3;
	}

	public String getSave_account_lab3() {
		return save_act_lab3;
	}

	public void setSave_account_lab3(String save_acccount_lab3) {
		this.save_act_lab3 = save_acccount_lab3;
	}

	public String getCurrent_account_lab() {
		return current_act_lab3;
	}

	public void setCurrent_account_lab3(String current_act) {
		this.current_act_lab3 = current_act;
	}

	public String getMort_gage_lab3() {
		return mortgage_lab3;
	}

	public void setMort_gage_lab3(String mort_gage_lab3) {
		this.mortgage_lab3 = mort_gage_lab3;
	}

	public String getPep_lab3() {
		return pep_lab3;
	}

	public void set_Pep_lab3(String pep_lab3) {
		this.pep_lab3 = pep_lab3;
	}
	

	/** 
	 * Get method for ID
	 * @return : String
	 */
	public String getId_lab3() {
		return id_lab3;
	}
	
	/**
	 * Set Method for ID
	 * @param : id
	 */

	public void setId(String id) {
		this.id_lab3 = id;
	}
/**
 * Get method for age
 * @return : int
 */
public int getAge_lab3() {
		return age_lab3;
	}
/**
 * Set method for age
 * @param: age
 */
	public void setAge(int age) {
		this.age_lab3 = age;
	}
/**
 * Get method for sex
 * @return : string
 */

	public String getSex_lab3() {
		return sex_lab3;
	}

	
/**
 * Set method for sex
 * @param : sex
 */

	public void setSex(String sex) {
		this.sex_lab3 = sex;
	}
/**
 * Get message for region
 * @return : String
*/ 
	public String getRegion_lab3_Reg() {
		return region_lab3;
	}
/**
 * set message for region
 * @param : region
 */
	public void setRegion(String region) {
		this.region_lab3 = region;
	}
/**
 * get method for Income
 * @return : Double
 */
	public double get_Income_lab4() {
		return income_lab3;
	}
/**
 * Set method for income
 * @param : income
 */
	public void setIncome(double income) {
		this.income_lab3 = income;
	}
	
	public static BankRecord[] getBrObj() {
		return bankObject_lab;
	}

	public static List<List<String>> getArray() {
		return arr_ay_lab3;
	}

	/**
	 * This is the main method. 
	 * @param args : string[]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRecord Bank_Record_lab = new BankRecord();
		
		try {
			Bank_Record_lab.read();
			Bank_Record_lab.process();
			//br.print();
		} catch (FileNotFoundException e) {
			System.out.println("File is not located!");
		} catch (IOException e) {
			System.out.println("File is not located!");
		}
		String time_stamp_lab3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		System.out.println("Dated on :" + time_stamp_lab3
				+ "\nProgrammed by Student Vishwas\n");
	}

	/**
	 * The read method reads the data from the csv file and stores it in a array list
	 */
	@Override
	
	public void read() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub - processing data
		String line = "";
		BufferedReader BufferRead_lab = new BufferedReader(new FileReader("bank-Detail.csv"));
		while ((line = BufferRead_lab.readLine()) != null) {
			arr_ay_lab3.add(Arrays.asList(line.split(",")));
		}
	}
/**
 * The print method displays the first 25 records and displays data along with the header
 */
	@Override
	void print() {
		// TODO Auto-generated method stub
		int ind_ex_lab;
		System.out.printf("%-10s%-5s%-10s%-15s%-15s%-15s", "ID", "AGE","SEX", "REGION", "INCOME", "MORTGAGE");
		System.out.println();

		for (ind_ex_lab = 0; ind_ex_lab < 25; ind_ex_lab++) {
			System.out.printf("%-10s", bankObject_lab[ind_ex_lab].getId_lab3());
			System.out.printf("%-5s", bankObject_lab[ind_ex_lab].getAge_lab3());
			System.out.printf("%-10s", bankObject_lab[ind_ex_lab].getSex_lab3());
			System.out.printf("%-15s", bankObject_lab[ind_ex_lab].getRegion_lab3_Reg());
			System.out.printf("%-15s", bankObject_lab[ind_ex_lab].get_Income_lab4());
			System.out.printf("%-15s", bankObject_lab[ind_ex_lab].getMort_gage_lab3());
			System.out.println();
		}
	}
/**
 * The process method reads the array list and adds the data to the instance field using the setter of each instance variable
 */
	@Override
	public void process() {
		// TODO Auto-generated method stub
		// add data values from array list to array
		int index_lab = 0;
		for (List<String> row_dat_lab : arr_ay_lab3) {
			bankObject_lab[index_lab] = new BankRecord(); // instancing the object
			bankObject_lab[index_lab].setId(row_dat_lab.get(0));
			bankObject_lab[index_lab].setAge(Integer.parseInt(row_dat_lab.get(1)));
			bankObject_lab[index_lab].setSex(row_dat_lab.get(2));
			bankObject_lab[index_lab].setRegion(row_dat_lab.get(3));
			bankObject_lab[index_lab].setIncome(Double.parseDouble(row_dat_lab.get(4)));
			bankObject_lab[index_lab].setMarried_lab3(row_dat_lab.get(5));
			bankObject_lab[index_lab].setChildren_lab3(Integer.parseInt(row_dat_lab.get(6)));
			bankObject_lab[index_lab].setCar_dat_lab(row_dat_lab.get(7));
			bankObject_lab[index_lab].setSave_account_lab3(row_dat_lab.get(8));
			bankObject_lab[index_lab].setCurrent_account_lab3(row_dat_lab.get(9));
			bankObject_lab[index_lab].setMort_gage_lab3(row_dat_lab.get(10));
			bankObject_lab[index_lab].set_Pep_lab3(row_dat_lab.get(11));
			index_lab += 1;
		}
	}
}







