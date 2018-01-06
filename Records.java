package lab4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * 
 * @author Vishwas
 * The class reads files from a file bank_details
 */
public class Records extends BankRecord {
	public static FileWriter file_write_lab3 = null;

	public Records() {
		try {
			BankRecord bank_records_lab3 = new BankRecord();
			try {
				bank_records_lab3.read();
				bank_records_lab3.process();
			} catch (FileNotFoundException e) {
				System.out.println("File is not located!");
			} catch (IOException e) {
				System.out.println("File is not located!");
			}
			file_write_lab3 = new FileWriter("bankrecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String toString(double value_lab3) {
		return String.format("%.2f", value_lab3 );
	}
/**
 * 
 * @param args : String[]
 * The main method. 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Records records_lab3 = new Records();			
		
		ave_rageCompare_lab3();
		fe_maleCompare_lab3();
		male_Compare_lab3();
		
		String time_stamp_labs = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
		.format(Calendar.getInstance().getTime());
		System.out.println("\nDated on :" + time_stamp_labs+ "\nProgrammed by Student Vishwas\n");
		try{
			file_write_lab3.write(String.format("\n"));
			file_write_lab3.write(String.format("\nDated on :" + time_stamp_labs+ "\nProgrammed by Student Vishwas\n"));
			}catch(IOException e){
			e.printStackTrace();
		}

		
		try {
			file_write_lab3.close(); //Flush Statements to the file 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	/**
	 * 
	 * This method displays and writes into the file bankrecord.txt
	 */
	public static void ave_rageCompare_lab3() {
		Arrays.sort(bankObject_lab, new AverageComparator());
		double city_Max_lab=0;
		double ru_ral_Max_lab =0, town_Max_lab =0, sub_urban_Max_lab=0;
		double city_Sum_lab=0, rural_Sum_lab =0, town_Sum_lab=0, sub_urban_Sum=0;
		int city_Cnt_lab=0, rural_Cnt_lab = 0, town_Cnt_lab = 0, sub_urban_Cnt_lab = 0;
		int inti_lab;
		for (inti_lab = 0; inti_lab < bankObject_lab.length; inti_lab++){
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("INNER_CITY") && bankObject_lab[inti_lab].get_Income_lab4()>city_Max_lab){
				city_Max_lab = bankObject_lab[inti_lab].get_Income_lab4();
				city_Cnt_lab++;
				city_Sum_lab = city_Sum_lab + bankObject_lab[inti_lab].get_Income_lab4();
			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("RURAL") && bankObject_lab[inti_lab].get_Income_lab4()>ru_ral_Max_lab){
				ru_ral_Max_lab = bankObject_lab[inti_lab].get_Income_lab4();
				rural_Cnt_lab++;
				rural_Sum_lab = rural_Sum_lab + bankObject_lab[inti_lab].get_Income_lab4();

			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("TOWN") && bankObject_lab[inti_lab].get_Income_lab4()>town_Max_lab){
				town_Max_lab = bankObject_lab[inti_lab].get_Income_lab4();
				town_Cnt_lab++;
				town_Sum_lab = town_Sum_lab+ bankObject_lab[inti_lab].get_Income_lab4();

			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("SUBURBAN") && bankObject_lab[inti_lab].get_Income_lab4()>sub_urban_Max_lab){
				sub_urban_Max_lab = bankObject_lab[inti_lab].get_Income_lab4();
				sub_urban_Cnt_lab++;
				sub_urban_Sum = sub_urban_Sum + bankObject_lab[inti_lab].get_Income_lab4();

			}
		}

		double city_Min_lab = city_Max_lab, rural_Min_lab = ru_ral_Max_lab, town_Min_lab = town_Max_lab, sub_urban_Min_lab = sub_urban_Max_lab;
		for (inti_lab = 0; inti_lab < bankObject_lab.length; inti_lab++){
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("INNER_CITY") && bankObject_lab[inti_lab].get_Income_lab4()<city_Min_lab){
				city_Min_lab = bankObject_lab[inti_lab].get_Income_lab4();
			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("RURAL") && bankObject_lab[inti_lab].get_Income_lab4()<rural_Min_lab){
				rural_Min_lab = bankObject_lab[inti_lab].get_Income_lab4();
			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("TOWN") && bankObject_lab[inti_lab].get_Income_lab4()<town_Min_lab){
				town_Min_lab = bankObject_lab[inti_lab].get_Income_lab4();
			}
			if(bankObject_lab[inti_lab].getRegion_lab3_Reg().equals("SUBURBAN") && bankObject_lab[inti_lab].get_Income_lab4()<sub_urban_Min_lab){
				sub_urban_Min_lab = bankObject_lab[inti_lab].get_Income_lab4();
			}
		}
		//DecimalFormat cityMax = new DecimalFormat("#.00"); 
		System.out.println("Maximum income in city : "+toString(city_Max_lab));
		
		System.out.println("Maximum income in town : "+toString(town_Max_lab));
		System.out.println("Maximum income in suburban :"+toString(sub_urban_Max_lab));
		System.out.println("Maximum income in rural : "+toString(ru_ral_Max_lab));
		
		System.out.println("\nMinimum income in city : "+toString(city_Min_lab));
		System.out.println("Minimum income in town : "+toString(town_Min_lab));
		System.out.println("Minimum income in suburban : "+toString(sub_urban_Min_lab));
		System.out.println("Minimum income in rural  : "+toString(rural_Min_lab));
		
		double avg_City_lab,avg_town_labs, avg_sub_urban, avg_rural_lab;
		avg_City_lab =city_Sum_lab/city_Cnt_lab;
		avg_town_labs =town_Sum_lab/town_Cnt_lab;
		avg_sub_urban = sub_urban_Sum/sub_urban_Cnt_lab;
		avg_rural_lab = rural_Sum_lab/rural_Cnt_lab;
		
		System.out.println("\nAverage income in city: "+toString(avg_City_lab));
		System.out.println("Average income in town : "+toString(avg_town_labs));
		System.out.println("Average income in suburban :"+toString(avg_sub_urban));
		System.out.println("Average income in rural : "+toString(avg_rural_lab));

		try{
			file_write_lab3.write(String.format("Maximum city income :"+city_Max_lab+"\nMaximum town income :"+town_Max_lab+"\nMaximum suburban income :"+sub_urban_Max_lab+"\nMaximum rural income :"+ru_ral_Max_lab));
			file_write_lab3.write(String.format("\n\nMinimum city income :"+city_Min_lab+"\nMinimum town income :"+town_Min_lab+"\nMinimum suburban income :"+sub_urban_Min_lab+"\nMinimum rural income :"+rural_Min_lab));
			file_write_lab3.write(String.format("\n\nAverage city income :"+city_Min_lab+"\nAverage town income :"+town_Min_lab+"\nAverage suburban income :"+sub_urban_Min_lab+"\nAverage rural income :"+rural_Min_lab+"\n"));
}catch(IOException e){
			e.printStackTrace();
		}		
	}

	/**
	 * 
	 * This method displays and writes into the file bankrecord.txt number of females with both a mortgage and savings account per location
	 */

		public static void fe_maleCompare_lab3() {
		Arrays.sort(bankObject_lab, new FemaleComparator());
		int in_City_Female_Cnt_labs = 0, rural_Female_Cnt_labs = 0, sub_urban_Female_Cnt_labs = 0, town_Fe_male_Cnt_labs = 0;
			
		for (int ab_indi = 0; ab_indi < bankObject_lab.length; ab_indi++) {
			if ((bankObject_lab[ab_indi].getSex_lab3().equals("FEMALE")) && (bankObject_lab[ab_indi].getRegion_lab3_Reg().equals("INNER_CITY")) && (bankObject_lab[ab_indi].getMort_gage_lab3().equals("YES")) && (bankObject_lab[ab_indi].getSave_account_lab3().equals("YES"))) {
				in_City_Female_Cnt_labs++;
			}
			if ((bankObject_lab[ab_indi].getSex_lab3().equals("FEMALE")) && (bankObject_lab[ab_indi].getRegion_lab3_Reg().equals("RURAL")) && (bankObject_lab[ab_indi].getMort_gage_lab3().equals("YES")) && (bankObject_lab[ab_indi].getSave_account_lab3().equals("YES"))){
				rural_Female_Cnt_labs++;
			}
			if ((bankObject_lab[ab_indi].getSex_lab3().equals("FEMALE")) && (bankObject_lab[ab_indi].getRegion_lab3_Reg().equals("SUBURBAN")) && (bankObject_lab[ab_indi].getMort_gage_lab3().equals("YES")) && (bankObject_lab[ab_indi].getSave_account_lab3().equals("YES"))){
				sub_urban_Female_Cnt_labs++;
			}
			if ((bankObject_lab[ab_indi].getSex_lab3().equals("FEMALE")) && (bankObject_lab[ab_indi].getRegion_lab3_Reg().equals("TOWN")) && (bankObject_lab[ab_indi].getMort_gage_lab3().equals("YES")) && (bankObject_lab[ab_indi].getSave_account_lab3().equals("YES"))){
				town_Fe_male_Cnt_labs++;
			}
		}
		System.out.println("\nInnercity region females with mort & savings acct: " + in_City_Female_Cnt_labs);
		System.out.println("Rural region females with mort & savings acct: " + rural_Female_Cnt_labs);
		System.out.println("suburban region females with mort & savings acct: " + sub_urban_Female_Cnt_labs);
		System.out.println("Town region females with mort & savings acct: " + town_Fe_male_Cnt_labs);
		try {
			file_write_lab3.write(String.format("\nInnercity region females with mort & savings acct: " + in_City_Female_Cnt_labs + "\n" +
					"Rural region females with mort & savings acct: " + rural_Female_Cnt_labs+"\n"+
					"suburban region females with mort & savings acct: " + sub_urban_Female_Cnt_labs+"\n"
					+"Town region females with mort & savings acct: " + town_Fe_male_Cnt_labs));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/** 
	 * 
	 * This method displays and writes into the file bankrecord.txt number of males with both a car and 1 child per location
	 */
		public static void male_Compare_lab3() {
			
			Arrays.sort(bankObject_lab, new MaleComparator());
			int in_nerCity_MaleCnt_labs = 0, ru_ralMale_Cnt_labs = 0, sub_urbanMale_Cnt_lab = 0, town_MaleCnt_labs = 0;
			for (int xy_indi = 0; xy_indi < bankObject_lab.length; xy_indi++){
				if(bankObject_lab[xy_indi].getRegion_lab3_Reg().equals("INNER_CITY") && bankObject_lab[xy_indi].getClass().equals("YES") && (bankObject_lab[xy_indi].getChildren_lab3()== 1) && bankObject_lab[xy_indi].getSex_lab3().equals("MALE") )
					in_nerCity_MaleCnt_labs++;
				if(bankObject_lab[xy_indi].getRegion_lab3_Reg().equals("RURAL") && bankObject_lab[xy_indi].getClass().equals("YES") && (bankObject_lab[xy_indi].getChildren_lab3()==1) && bankObject_lab[xy_indi].getSex_lab3().equals("MALE") )
					ru_ralMale_Cnt_labs++;
				if(bankObject_lab[xy_indi].getRegion_lab3_Reg().equals("SUBURBAN") && bankObject_lab[xy_indi].getClass().equals("YES") && (bankObject_lab[xy_indi].getChildren_lab3()==1) && bankObject_lab[xy_indi].getSex_lab3().equals("MALE") )
					sub_urbanMale_Cnt_lab++;
				if(bankObject_lab[xy_indi].getRegion_lab3_Reg().equals("TOWN") && bankObject_lab[xy_indi].getClass().equals("YES") && (bankObject_lab[xy_indi].getChildren_lab3()==1) && bankObject_lab[xy_indi].getSex_lab3().equals("MALE") )
					town_MaleCnt_labs++;
				}
			System.out.println("\nCount of Inner city region males having a child and owning a car :" +in_nerCity_MaleCnt_labs );
			System.out.println("Count of Rural region males having a child and owning a car :" +ru_ralMale_Cnt_labs );
			System.out.println("Count of Suburban city region males having a child and owning a car :" +sub_urbanMale_Cnt_lab );
			System.out.println("Count of Town city region males having a child and owning a car :" +town_MaleCnt_labs );
			try{
				file_write_lab3.write("\n\nCount of Inner city region males having a child and owning a car :" +in_nerCity_MaleCnt_labs+"\nCount of Rural region males having a child and owning a car : "+ru_ralMale_Cnt_labs+"\nCount of Suburban city region males having a child and owning a car :" +sub_urbanMale_Cnt_lab+"\nCount of Town city region males having a child and owning a car :" +town_MaleCnt_labs);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			}
		}