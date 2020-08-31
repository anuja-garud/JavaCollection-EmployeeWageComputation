public class EmpWageBuliderIns{

	private  int empRate;
	private  int numofWorkingDays;
	private  int maxHrsInMonth;

	public EmpWageBuliderIns(final int empRate, final int numofWorkingDays, final int maxHrsInMonth)
	{
		this.empRate= empRate;
		this.numofWorkingDays= numofWorkingDays;
		this.maxHrsInMonth= maxHrsInMonth;
	}

	public static void main(String[] args)
	{
		EmpWageBuliderIns obj1 = new EmpWageBuliderIns(20,20,100);
		obj1.calDailyEmpwage();

	}
    /**
    * Calculate Daily Empwage
    */

    public void calDailyEmpwage()
    {
    	int totalWage = 0;
    	int totalEmpHrs =0;
    	int totalWorkingDays= 0;

    	while (totalEmpHrs < maxHrsInMonth  && totalWorkingDays < numofWorkingDays )
    	{
    		totalWorkingDays++;

    		final int empHrs = getEmpHrs();

    		totalEmpHrs=totalEmpHrs+empHrs; 
    		
    		final int empwage= empHrs * empRate;

    		totalWage=totalWage+empwage;

    		System.out.println("Employee Working Days :" +totalWorkingDays);
    		System.out.println("Employee wages :" +empwage);

    	}

        System.out.println("Total Employee Wags :" +totalWage);
	}

	public int getEmpHrs()
	{
		final int isFUllTime=1;
		final int isPartTime=2;
		int empHrs=0;

		final double randomvalue = Math.floor(Math.random()*10)%3;

		switch((int)randomvalue)
		{
			case isFUllTime:
				empHrs=8;
				System.out.println("Emp for full time");
				break;

			case isPartTime:
				empHrs=4;
				System.out.println("Emp for Part time");
				break;

		    default:
		    	empHrs=0;
		    	System.out.println("Emp is Absent");
		    	break;
		}
		return empHrs;
	}
}

  
