public class EmployeeWagesUsingMethod{

	//Constant
        public static final int IS_FULL_TIME=1;
        public static final int IS_PART_TIME=2;
        public static final int EMP_RATE_PER_HOUR=20;
	public static final int NUMBER_OF_WORKINGDAYS=20;

        public static void main(String[] args){
		EmployeeWagesUsingMethod empWagesUsingMethod=new EmployeeWagesUsingMethod();
		empWagesUsingMethod.calculate20DayWage();
        }
	public void calculate20DayWage()
	{
		int emp_Hour;
                int emp_Wages;
		int totalEmpWages=0;
		int maximum_Hours=50;
		int total_Hours=0;
		int total_Working_Days=0;

		while( total_Hours<=maximum_Hours  && total_Working_Days<=NUMBER_OF_WORKINGDAYS )
		{
			total_Working_Days++;
			int randomCheck=(int)(Math.random()*10)%3;
		switch(randomCheck){
                        case IS_FULL_TIME:
                                emp_Hour=8;
                                break;
                        case IS_PART_TIME:
                                emp_Hour=4;
                                break;
                        default:
                                emp_Hour=0;
                }
		total_Hours=total_Hours+emp_Hour;
		}
		totalEmpWages=total_Hours*EMP_RATE_PER_HOUR;
		System.out.println("Total Hours : "+total_Hours);
		System.out.println("Total Wages : " +totalEmpWages);
	}

}

