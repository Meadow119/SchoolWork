import java.util.*;

public class Ch6Asg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Welcome user
        System.out.println("Welcome to the Employee Wage Calculator!");

        //Ask for employee name
        System.out.println("Please enter an employee name.");
        String inputName = input.nextLine();

        //Ask for employee number
        System.out.println("Please enter an employee number.");
        String inputNumber = input.nextLine();

        //Ask for hourly pay rate
        System.out.println("Please enter the hourly pay rate.");
        double inputHourlyPayRate = input.nextDouble();

        // Ask for percentage for overtime
        System.out.println("Please enter the overtime pay rate in a whole number. (Not decimal form)");
        double inputOvetimePayRate = input.nextDouble();
        inputOvetimePayRate = (1+(inputOvetimePayRate/100));


        //Create new employee object
        Employee e1 = new Employee();

//Create loop for requested variables
do {
    //Pay Rate
    System.out.println("Please enter the hourly pay rate.");


//Calculate wage method


    //Ask if user would like to continue
    System.out.printf("Would you like to continue? Press q to quit.");
    String loopentry = input.nextLine();
    if (loopentry.equals("q")){
        boolean endloop = true;
    }
    else{
        boolean endloop = false;
    }
}while (!endloop);

    }


    //Create Employee class
    class Employee {

        //Fields
        String employeeName;
        String employeeNumber;
        double hourlyPayRate;
        int overtimeRate;

        //Setters
        public void setEmployeeName(String desiredEmployeeName) {
            employeeName = desiredEmployeeName;
        }

        public void setEmployeeNumber(String desiredEmployeeNumber) {
            employeeNumber = desiredEmployeeNumber;
        }

        public void setHourlyPayRate(double desiredHourlyPayRate) {
            if (desiredHourlyPayRate > 0) {
                hourlyPayRate = desiredHourlyPayRate;
            } else {
                hourlyPayRate = 0;
            }
        }

        public void setOvertimeRate(int desiredOvertimeRate) {
            if (desiredOvertimeRate >= 0) {
                overtimeRate = desiredOvertimeRate;
            } else {
                overtimeRate = 0;
            }
        }

        //Getters
        public String getEmployeeName() {
            return employeeName;
        }

        public String getEmployeeNumber() {
            return employeeNumber;
        }

        public double getHourlyPayRate() {
            return hourlyPayRate;
        }

        public double getOvertimeRate() {
            return overtimeRate;
        }

        //Constructors
        public Employee() {
        }

        public Employee(String employeeName) {
            setEmployeeName(employeeName);
        }

        public Employee(String employeeName, String employeeNumber) {
            setEmployeeName(employeeName);
            setEmployeeNumber(employeeNumber);
        }

        public Employee(String employeeName, String employeeNumber, double hourlyPayRate) {
            setEmployeeName(employeeName);
            setEmployeeNumber(employeeNumber);
            setHourlyPayRate(hourlyPayRate);
        }

        public Employee(String employeeName, String employeeNumber, double hourlyPayRate, int overtimeRate) {
            setEmployeeName(employeeName);
            setEmployeeNumber(employeeNumber);
            setHourlyPayRate(hourlyPayRate);
            setOvertimeRate(overtimeRate);
        }

        //Methods
        public void CalculateWage(double hoursWorked, int shiftNumber) {

            //1st and 2nd shift
            //Calculate overtime
            if ((shiftNumber >= 1) && (shiftNumber <= 2)) {
                if (hoursWorked >= 40) {
                    double overtimeHours = hoursWorked - 40;
                    double overtimePay = overtimeHours * overtimeRate;
                    double totalPay = (overtimePay + (40 * hourlyPayRate));


                    //Display employee name, number, hourly pay rate, overtime rate, hours worked and pay, shift, and overtime hours and pay
                    System.out.printf("--------------------------------" +
                            "Employee Name: %17s" +
                            "Employee Number : %14s" +
                            "Hourly Pay: %20.2f" +
                            "Hours Worked: %18f" +
                            "Shift: %24d" +
                            "Overtime Hours : %14.2f" +
                            "--------------------------------" +
                            "Total Pay: %.2f", employeeName, employeeNumber, hourlyPayRate, hoursWorked, shiftNumber, overtimeHours, totalPay);
                } else {
                    double totalPay = hourlyPayRate * hoursWorked;


                    //Display employee name, number, hourly pay rate, overtime rate, hours worked and pay, shift, and overtime hours and pay
                    System.out.printf("--------------------------------" +
                            "Employee Name: %17s" +
                            "Employee Number : %14s" +
                            "Hourly Pay: %20.2f" +
                            "Hours Worked: %18f" +
                            "Shift: %24d" +
                            "Overtime Hours :               0" +
                            "--------------------------------" +
                            "Total Pay: %.2f", employeeName, employeeNumber, hourlyPayRate, hoursWorked, shiftNumber, totalPay);
                }
            }

            //Calculate overtime wage for 3rd shift (+10%)
            else if (shiftNumber == 3) {
                if (hoursWorked >= 40) {
                    double overtimeHours = hoursWorked - 40;
                    double overtimePay = overtimeHours * overtimeRate;
                    double totalPay = (overtimePay + (40 * hourlyPayRate));
                    totalPay = totalPay * 1.1;
                    //Display employee name, number, hourly pay rate, overtime rate, hours worked and pay, shift, and overtime hours and pay
                    System.out.printf("--------------------------------" +
                            "Employee Name: %17s" +
                            "Employee Number : %14s" +
                            "Hourly Pay: %20.2f" +
                            "Hours Worked: %18f" +
                            "Shift: %24d" +
                            "Overtime Hours : %14.2f" +
                            "--------------------------------" +
                            "Total Pay: %.2f", employeeName, employeeNumber, hourlyPayRate, hoursWorked, shiftNumber, overtimeHours, totalPay);

                }
                //Calculate normal wage for 3rd shift (+10%)
                else {
                    double totalPay = hourlyPayRate * hoursWorked;
                    totalPay = totalPay * 1.1;


                    //Display employee name, number, hourly pay rate, overtime rate, hours worked and pay, shift, and overtime hours and pay
                    System.out.printf("--------------------------------" +
                            "Employee Name: %17s" +
                            "Employee Number : %14s" +
                            "Hourly Pay: %20.2f" +
                            "Hours Worked: %18f" +
                            "Shift: %24d" +
                            "Overtime Hours :               0" +
                            "--------------------------------" +
                            "Total Pay: %.2f", employeeName, employeeNumber, hourlyPayRate, hoursWorked, shiftNumber, totalPay);
                }
            }
            else {
            }
        }
    }
}
