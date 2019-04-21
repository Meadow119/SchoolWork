/*
Bradley Poleski
2018MAR07
CIS 117 Java Programming I
Character Name, Health and Attack
This program tests the player class to ensure the name, health and attack methods work.
 */
import java.util.*;


public class Asg07 {
    public static void main(String[] args){

        //Create Scanner for user input later
        Scanner input = new Scanner(System.in);

        //Ask user for Player name
        System.out.println("Please enter the name of the player's character.");
        String playerName = input.nextLine();

        //Ask user for player health
        System.out.println("Please enter the health of the player. (Between 1-100)");
        int playerHealth = input.nextInt();

        //Instantiate object for player
        Player p1 = new Player();
        System.out.println(p1);

/*
        //Ask user for opponent name
        System.out.println("Please enter the name of the opponent character.");
        String opponentName = input.nextLine();

        //Ask user for opponent health
        System.out.println("Please enter the health of the opponent. (Between 1-100)");
        int opponentHealth = input.nextInt();

        //Instantiate object opponent
        Player p2 = new Player();

        //Create loop to test Player Class
        do {

            //Player attacks


            //Opponent attacks

            //End when one reaches 0 health
    }*/
}

class Player {

    //Create variable for name
    private String playerName;

    //Create variable for health
    private int playerHealth;

    //Create getter for name
    public String getPlayerName(){
        return playerName;
    }

    //Create setter for name
    public void setPlayerName(String desiredName){
        playerName = desiredName;
    }

    //Create getter for health
    public int getPlayerHealth(){
        return playerHealth;
    }

    //Create setter for health
    public void setPlayerHealth(int desiredHealth){
        if ((desiredHealth >=0) && (desiredHealth <= 100)){
            playerHealth = desiredHealth;
        }
        else if (desiredHealth <0){
            playerHealth = 0;
        }
        else {
            playerHealth = 100;
        }
    }

    //Create constructor for name and health
    public Player(){
    }
    public Player(String playerName){
        setPlayerName(playerName);
    }
    public Player(String playerName, int playerHealth){
        setPlayerName(playerName);
        setPlayerHealth(playerHealth);
    }


    //Create attack method
    public void attack(Player defendingPlayer){
        //Create random value between 0 and 25 if over 15 = fail
        Random dice = new Random();
        int roll;
        roll = dice.nextInt(26);

        if (roll > 15){
            System.out.println("Player x attacked player y and missed.");
        }
        else {
            playerHealth = playerHealth - roll;
            System.out.println("Player x attacked player y and the player's health is now " + playerHealth);
        }

    }

    //
}
