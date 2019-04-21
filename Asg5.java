/*
Bradley Poleski
2018February07
CIS 117 Java Programming I
CIS117.2476.W18
Chapter 5 Assignment
Phone Number Dissector
This program breaks down a phone number that was entered by the user and outputs the different parts.
 */

import java.util.*;


public class Asg5 {
    public static void main(String[] args) {

        //This is needed to take input from user
        Scanner stdIn = new Scanner(System.in);

        //Input string variable to start loop

        //Start loop
        boolean runLoop = true;
        while (runLoop){


        //Request user phone number
        System.out.println("" +
                "Please enter a phone number in the form cc-area-local, " +
                "where cc = country code, area = area code and local = local digits;" +
                " Press q to quit.");
        String userInput = stdIn.nextLine();

            //Split phone number
            String splitPhoneNumber[] = userInput.split("-");

            //First format (Three sets of digits with two dashes)
            if (splitPhoneNumber.length > 2){
                //Output dissected phone number
                    System.out.printf("" +
                            "Country Code = %s\n" +
                            "Area Code =    %s\n" +
                            "Local Number = %s\n\n", splitPhoneNumber[0], splitPhoneNumber[1], splitPhoneNumber[2]);

            }
            //Second format (Area code and local digit group
            else if (splitPhoneNumber.length > 1){
                //Output dissected phone number
                System.out.printf("" +
                        "Country Code = ?\n" +
                        "Area Code =    %s\n" +
                        "Local Number = %s\n\n", splitPhoneNumber[0], splitPhoneNumber[1]);

            }
            //Third format (local digit group only)*/
            else if (!userInput.equals ("q")){
                //Output dissected phone number
                System.out.printf("" +
                        "Country Code = ?\n" +
                        "Area Code =    ?\n" +
                        "Local Number = %s\n\n", splitPhoneNumber[0]);

            }


        //Create "q" option to opt out of loop
        if (userInput.equals ("q")){
            runLoop = false;
            System.out.println("Thank you for using the Phone Number Dissector!");
        }
        }
    }
}