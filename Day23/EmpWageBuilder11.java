interface EmpWageBulidercmp
{
   public void addCompany( String name, final int empRate, final int numOfWorkingDays,  int maxHrsInMonth);
   public void  computeEmpWage();
}
//interface method

public class EmpWageBuilder11 implements EmpWageBulidercmp //implement class
{
	
	private int noOfCompany = 0;
	private Company [] companies;

	public EmpWageBuilder11() 
	{
		companies = new Company[4];
	}                                 //decalre array

	public static void main(String[] args) 
	{
	
		final EmpWageBuilder11 empBuilder = new EmpWageBuilder11();  //object creation
		empBuilder.addCompany("AIRTEL", 20, 20, 100);
		empBuilder.addCompany("JIO", 20, 18, 80);
		empBuilder.addCompany("IDEA", 20, 18, 110);
		empBuilder.addCompany("BSNL", 10, 18, 40);


		empBuilder.computeEmpWage();
	}

	public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth)
	{
		System.out.println("Called add company function with name : "+ name);
		companies[noOfCompany] = new Company(name, empRate, numOfWorkingDays, maxHrsInMonth);
		noOfCompany++;
	}


	public void computeEmpWage(){

		System.out.println("Called computeEmpWage --->");
		for(int i = 0; i< noOfCompany; i++){
			final int totalWage = computeEmpWage(companies[i]);
			companies[i].setTotalEmpWage(totalWage);
			System.out.println(companies[i]);
		}

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
	}                                          //parameterizedConstuctor

	public String getName()            //using get() access direct name
	{
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
	public String toString()
	{
		return "Total emp wage for company: "+name+" is "+ totalEmpWage;
	}

}
