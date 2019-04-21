//Needed for Scanner utility later
import java.util.*;


public class Ch09Asg {

    public static void main (String[] args){

        //Needed to accept input from user
        Scanner input = new Scanner(System.in);

        //Welcome user
        System.out.println("Welcome to the dice throwing simulator!");

        //Create Dice Sim object
        DiceSimulation diceSimulation = new DiceSimulation();


        //Create loop boolean and start loop to run dice sim
        boolean runLoop = true;

        do {

            //Display menu
            System.out.printf("" +
                    "\nOptions : (n)ew simulation, (a)dditional rolls, (p)rint, (q)uit" +
                    "\nEnter n, a, p, or q ==> ");


            //Ask for user input
            String userAnswer = input.nextLine();

            //new simulation
            if (userAnswer.toLowerCase().equals("n")){


                System.out.println("\nHow many rolls would you like to simulate?");
                int desiredRollCount = input.nextInt();

                diceSimulation.newSimulation(desiredRollCount);

                diceSimulation.setDiceThrows(desiredRollCount);
                input.nextLine();

            }

            //additional rolls
            else if (userAnswer.toLowerCase().equals("a")) {

                System.out.println("\nPlease enter the number of additional rolls.");
                int desiredAdditionalRolls = input.nextInt();
                diceSimulation.additionalRolls(desiredAdditionalRolls);
                input.nextLine();

            }

            //Print
            else if (userAnswer.toLowerCase().equals("p")) {
                //print
                //System.out.println("\nPrint");
                diceSimulation.printReport();
            }

            //Quit
            else if (userAnswer.toLowerCase().equals("q")) {
                //quit
                runLoop = false;
            }

            //Error message for all other entries
            else {
                System.out.print("\nInvalid entry.\n");
            }


        }while (runLoop);




    }
}

class DiceSimulation{

    //Fields
    private int diceThrows;
    private Random rand = new Random();

    //Creating Array for DiceSim
    private int[] frequency = new int[13];

    //setters
    public void setDiceThrows(int desiredDiceThrows){
        diceThrows = desiredDiceThrows;
    }

    //getters
    private int getDiceThrows(){
        return diceThrows;
    }

    //Constructors
    DiceSimulation(){}

    DiceSimulation(int desiredDiceThrows){
        setDiceThrows(desiredDiceThrows);
    }


    //Methods
        //newSimulation
        public void newSimulation(int desiredRollCount) {
            getDiceThrows();
            setDiceThrows(0);

            //Resets all values in frequency array to 0
            for(int resetNumber = 0;resetNumber<13; resetNumber++){
                frequency[resetNumber] = 0;}

            //Create random values for dice up to desired roll amount and add them to the array number
            for (int i = 0; i < desiredRollCount; i++) {
                int diceRoll1 = (rand.nextInt(6) + 1);
                int diceRoll2 = (rand.nextInt(6) + 1);
                int diceTotal = diceRoll1 + diceRoll2;
                frequency[diceTotal]++;}}


        //additional rolls
        public void additionalRolls(int desiredAddedRolls){
        getDiceThrows();

        //Changes the stored dice rolls
        int newDiceThrows = diceThrows + desiredAddedRolls;
        setDiceThrows(newDiceThrows);

        //Creates more rolls and adds them to array
        for (int i = 0; i < desiredAddedRolls; i++) {
        int diceRoll1 = (rand.nextInt(6) + 1);
        int diceRoll2 = (rand.nextInt(6) + 1);
        int diceTotal = diceRoll1 + diceRoll2;
        frequency[diceTotal]++;}}


        //print report
        public void printReport() {

            getDiceThrows();

            //This is for lower numbers because 1% of 10 <1 and count will not work
            if ((diceThrows / 100) < 1) {
                System.out.printf("" +
                        "\n----------------------------------------------------------" +
                        "\nDICE ROLLING SIMULATION RESULTS:" +
                        "\nEach * represents a roll for that number." +
                        "\nTotal number of rolls = %d.", diceThrows);

                            //Prints out dice number and asterisk according to rolls
                            for (int i = 2; (i < 13); i++) {
                                System.out.printf("\n%2d: ", i);

                                //Prints out rolls for dice
                                System.out.print(frequency[i] + " ");
                                int printCount = 1;

                                //Prints histogram for dice rolls.
                                while (printCount <= frequency[i]) {
                                    System.out.print("*");
                                    printCount++;}}
        System.out.print("\n" +
                        "------------------------------------------------------------");}

            //For all instances where 1% of total number is more than 1
            else {
                System.out.printf("" +
                                "\n----------------------------------------------------------" +
                                "\nDICE ROLLING SIMULATION RESULTS:" +
                                "\nEach * represents 1 percent of the rolls for that number" +
                                "\nTotal number of rolls = %d.", diceThrows);

                                    //Prints out dice number
                                    for (int i = 2; (i < 13); i++) {
                                    System.out.printf("\n%2d: ", i);

                                    //Prints out rolls for dice
                                    System.out.print(frequency[i] + " ");
                                    int printCount = 1;

                                    //Prints histogram for dice
                                    while (printCount <= (frequency[i]/(diceThrows/100))) {
                                        System.out.print("*");
                                        printCount++;}}
               System.out.print("\n" +
                                "------------------------------------------------------------");}
        }

}
