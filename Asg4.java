/*
Bradley Poleski
2018Feb09
CIS 117 Java Programming I
CIS117.2476.W18
Chapter 4 Assignment
Greenville County Idol
This program calculates the turnout and revenue earned from Greenville County Idol.
 */

import java.util.Scanner;

public class Asg4 {
    public static void main(String[] args)
    {
        //Needed for Scanner Utility
        Scanner stdIn= new Scanner(System.in);

        //Welcome user and display motto
        System.out.println("Welcome to the Greenville County Idol Competition!\n" +
                "**********The stars shine in Greenville!**********\n");


        //Ask how many users entered last years competition (Between 0 and 30 with error otherwise)
        System.out.println("Please enter the number of contestants that entered last year. (Between 1 and 30)");
        int  contestantsLastYear = stdIn.nextInt();

        //Create if loop for improper value entered
        if ((contestantsLastYear <= 0) || (contestantsLastYear > 30)) {
            System.out.println("You have entered an invalid number. Please try again.");
            System.exit(0);
        }
        else;

        //Ask user for number of contestants this year. Same requirements as above
        System.out.println("Please enter the number of contestants entering this year.(Between 1 and 30)");
        int  contestantsThisYear = stdIn.nextInt();

        //Create if loop for improper value entered
        if ((contestantsThisYear <= 0) || (contestantsLastYear > 30)) {
            System.out.println("You have entered an invalid number. Please try again.");
            System.exit(0);
        }
        else;

        //If 2x last years contestants put "The competition is bigger than ever!"
        if (contestantsThisYear/contestantsLastYear > 1){
            System.out.println("The competition is bigger than ever!");
        }

        //If less, put "A tighter race this year! Come out and cast your vote!"
        else if (contestantsThisYear < contestantsLastYear){
            System.out.println("A tighter race this year! Come out and cast your vote!");
        }

        //Display number of contestants and revenue for both years
        //Calculate last year's profits
        int lastYearRevenue = (contestantsLastYear*25);

        //Calculate this year's profits
        int thisYearRevenue = (contestantsThisYear*25);

        //Output results
        System.out.printf("" +
                "_________________________________\n"+
                "Contestants last year:    %d\n" +
                "Last year's revenue:      $%d\n" +
                "This year's contestants:  %d\n" +
                "This year's revenue:      $%d\n" +
                "_________________________________\n\n",
                contestantsLastYear, lastYearRevenue, contestantsThisYear, thisYearRevenue);

        //Display percentage change rounded to nearest integer (Use more, less and same when comparing values
        if (contestantsLastYear>contestantsThisYear){
            float contestantChange = (contestantsLastYear-contestantsThisYear);
            float percentChange = (contestantChange/contestantsLastYear);
            float percentageWholeNumber = (percentChange * 100);
            int percentWholeInt = Math.round(percentageWholeNumber);
            System.out.printf("There are %d percent LESS contestants this year.", percentWholeInt);
        }
        else if (contestantsThisYear>contestantsLastYear){
            float positivecontestantChange = (contestantsThisYear-contestantsLastYear);
            float positivepercentChange = (positivecontestantChange/contestantsThisYear);
            float positivepercentageWholeNumber = (positivepercentChange * 100);
            int positivepercentWholeInt = Math.round(positivepercentageWholeNumber);
            System.out.printf("There are %d percent MORE contestants this year!", positivepercentWholeInt);
        }
        else{
            System.out.println("The competition is the same as last year.");
        }
    }
}
