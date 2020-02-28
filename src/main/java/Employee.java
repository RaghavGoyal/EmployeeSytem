import java.util.Scanner;

public class Employee {

   private String firstName;
   private String lastName;
   private int noOfCertifications;
   private double experience;
   private double workHours;
   private double wagePerHour;
   private double salary;
   private EmployeeType type;
   private double mediclaim;

    Employee(String firstName, String lastName, double experience){

        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.type = EmployeeType.PERMANENT_PM;
        this.salary = getSalary(this);
        this.mediclaim = getMediclaim(this);

        System.out.println("Employee "+firstName+" created successfully.");

    }

    Employee(String firstName, String lastName, double experience, int noOfCertifications){

        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.noOfCertifications = noOfCertifications;
        this.type = EmployeeType.PERMANENT_TA;
        this.salary = getSalary(this);
        this.mediclaim = getMediclaim(this);

        System.out.println("Employee "+firstName+" created successfully.");

    }

    Employee(String firstName, String lastName, double experience, double workHours, double wagePerHour){

        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        this.workHours = workHours;
        this.wagePerHour = wagePerHour;
        this.type = EmployeeType.CONTRACT_TA;
        this.salary = getSalary(this);
        this.mediclaim = getMediclaim(this);

        System.out.println("Employee "+firstName+" created successfully.");

    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + firstName + " " + lastName + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                ", mediclaim=" + mediclaim +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public static int typeSelection(){
        char type;
        System.out.println("Enter 1 if you want to enter the Permanent Employee");
        System.out.println("Enter 2 if you want to enter the Contract Employee");
        Scanner sc = new Scanner(System.in);
        type = sc.next().charAt(0);
        if(type=='1'){
            char subType;
            System.out.println("Enter 1 if you want to enter Project Manager");
            System.out.println("Enter 2 if you want to enter Technical Associate");

            subType = sc.next().charAt(0);

            switch(subType){
                case '1':
                    return 1;
                case '2':
                    return 2;
                default:
                    System.out.println("ERROR: wrong choice Entered...!");
                    System.exit(0);
            }
        }
        if(type=='2'){
            return 3;
        }
        else{
            System.out.println("ERROR: wrong choice Entered...!");
            System.exit(0);
        }
        return 0;
    }

    public double getSalary(Employee emp){

       switch(emp.type){
            case PERMANENT_PM:
                return 10000 * emp.experience ;
            case PERMANENT_TA:
                return ( (5000 * emp.experience) + (1000 * noOfCertifications) );
            case CONTRACT_TA:
                if(emp.workHours <= 40)
                    return emp.wagePerHour * emp.workHours;
                else
                    return 40 * emp.wagePerHour + (emp.workHours - 40) * emp.wagePerHour * 2;
        }
        return 0.0;
    }

    public double getMediclaim(Employee emp){
        switch(emp.type){
            case PERMANENT_PM:
                return 12 * getSalary(emp);
            case PERMANENT_TA:
                return 24 * getSalary(emp);
            default:
                return 0.0;
        }
    }
}