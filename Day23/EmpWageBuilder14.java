import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

//declare methods()
interface EmpWageBulidercmp
{
   public void addCompany( String name, final int empRate, final int numOfWorkingDays,  int maxHrsInMonth);
   public void  computeEmpWage();
   int getTotalWageByCompanyName(final String name);
}


public class EmpWageBuilder14 implements EmpWageBulidercmp
{
	
	 
	private List<Company> companies;    //List of comapny
	private Map<String,Integer> companyWages;   //MAptable

	public EmpWageBuilder14() {
		companies = new ArrayList<Company>();         //declare Array
		companyWages = new HashMap<String,Integer>();  //decalre Hashmap
	}

	public static void main(String[] args) {
	
		final EmpWageBuilder14 empBuilder = new EmpWageBuilder14();
		empBuilder.addCompany("AIRTEL", 20, 20, 100);
		empBuilder.addCompany("JIO", 20, 18, 80);
		empBuilder.addCompany("IDEA", 20, 18, 110);
		empBuilder.addCompany("BSNL", 10, 18, 40);

		empBuilder.computeEmpWage();

		//Query
		final int totalWage = empBuilder.getTotalWageByCompanyName("JIO");
		System.out.println("Total emp wages for JIO" +totalWage); 

		
	}

	public int getTotalWageByCompanyName(final String name)
	{
		final int totalWage = companyWages.get(name);
		return totalWage;
	}

	public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth)
	{
		System.out.println("Called add company function with name : "+ name);
		companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
		
	}


	public void computeEmpWage(){

		System.out.println("Called computeEmpWage --->");
		for(int i = 0; i< companies.size(); i++)
		{
			final Company company  =companies.get(i);
			final int totalWage = computeEmpWage(company);
			company.setTotalEmpWage(totalWage);
		    companyWages.put(company.getName(),totalWage);
		}

		System.out.println("Stored Values in Map" +companyWages.toString()); 

	}
	/**
	 * calculate total employee wages
	 * return total employee wages.
	 */
	private int computeEmpWage(final Company company) {
		System.out.println("Calculating company wage for company : " + company.getName());
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
			totalWorkingDays++;

			final int empHrs = getEmpHrs();
			final int empWage = empHrs*company.getEmpRate();
			totalEmpHrs+=empHrs;
			totalWage+=empWage;
			//System.out.println("Emp DAY : "+totalWorkingDays+" wages : "+empWage);
		}
		return totalWage;
	}

	/**
	 * Get employee hours. 
	 * @return employee hrs
	 */
	public int getEmpHrs() {

		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

		//get random value
		final double randomValue = Math.floor(Math.random()*10)%3;

		switch((int)randomValue) {

			case isFullTime:
				empHrs = 8;
				//System.out.println("Emp is present for full time.");
				break;
			case isPartTime:
				empHrs = 4;
				//System.out.println("Emp is present for part time.");
				break;
			default:
				empHrs=0;
				//System.out.println("Emp is absent");
				break;
		}
		return empHrs;
	}

	
}

/**
 * CompanyEmpWage 
 */
class Company {

	//variables
	private String name;
	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;

	public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth)
	{
		this.name = name;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	} //parameterized Constuctor

	public String getName(){
		return this.name;
	}

	public int getEmpRate(){
		return this.empRate;
	}

	public int getNumOfWorkingDays(){
		return this.numOfWorkingDays;
	}

	public int getMaxHrsInMonth(){
		return this.maxHrsInMonth;
	}

	public void setTotalEmpWage(final int totalEmpWage){
		this.totalEmpWage=totalEmpWage;
	}

	@Override
	public String toString(){
		return "Total emp wage for company: "+name+" is "+ totalEmpWage;
	}

}
