public class EmpWageObject
{
      //CONSTANTS
    public static final int IS_FULL_TIME=1;
    public static final int IS_PART_TIME=2;

    //variable
	public final String company;
	public final int empRatePerHour;
	public final int numbOfWorkingDays;
	public final int maxHours;

	public EmpWageObject(String company,int empRatePerHour,int numbOfWorkingDays,int maxHours)
	{
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numbOfWorkingDays=numbOfWorkingDays;
		this.maxHours=maxHours;
	}
        public static void main(String[] args)
        {
		EmpWageObject Airtel=new EmpWageObject("Airtel",20,2,5);
		EmpWageObject Jio=new EmpWageObject("Jio",20,4,7);

                Airtel.calculateWage();
                Jio.calculateWage();

        }
        public void calculateWage()
        {

                int empHrs=0;
                int empWage;
                //int totalEmpWage=0;
                int totalMaxEmpHrs=12;
                int totalHrs=0;
                int totalWorkingDays=0;
                while(totalHrs<maxHours && totalWorkingDays<=numbOfWorkingDays)
                {
                        totalWorkingDays++;
                        int randomCheck=(int)((Math.random()*10)%3);

                switch(randomCheck)
                {
                        case IS_PART_TIME:
                                empHrs=4;
                                break;

                        case IS_FULL_TIME:
                                empHrs=8;
                                break;

                        default:
                                empHrs=0;

                }
                totalHrs=totalHrs+empHrs;
                System.out.println("empHrs:"+empHrs);
                }
                int totalEmpWage=totalHrs*empRatePerHour;
                System.out.println("totalHrs:" +totalHrs);

                System.out.println("TotalWage for:"+company+" "+totalEmpWage);
        }
}
