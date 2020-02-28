import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        welcomeMsg();

        char choice ='Y';

        while(choice == 'y' || choice == 'Y'){

            String empFirstName;
            String empLastName;
            double empExperience;

            int empType = Employee.typeSelection();

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the details of Employee:");
            System.out.println("Employee First Name: ");
            empFirstName = sc.nextLine();
            System.out.println("Employee Last Name: ");
            empLastName = sc.nextLine();
            System.out.println("Employee Experience: ");
            empExperience = sc.nextDouble();

            switch (empType){
                case 1:
                    System.out.println ( new Employee(empFirstName, empLastName, empExperience ));
                    break;
                case 2:
                    System.out.println ("Enter the number of Technical Certifications completed: ");
                    int empCertifications = sc.nextInt();
                    System.out.println  (new Employee(empFirstName, empLastName, empExperience, empCertifications));
                    break;
                case 3:
                    System.out.println("enter the wages/hour: ");
                    double wagePerHour = sc.nextDouble();
                    System.out.println("enter the hours worked: ");
                    double hours = sc.nextDouble();
                    System.out.println ( new Employee(empFirstName, empLastName, empExperience, hours, wagePerHour));
                    break;
            }

            System.out.println("Do you want to enter other employee details? y/n");
            choice = sc.next().charAt(0);
        }
    }

    static void welcomeMsg(){
        System.out.println("Welcome to SNTPS Employee System !");
    }
}
