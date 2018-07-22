import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens { //game "Odds and Evens" one on one a the computer
    public static void main(String[] args){
        warmUp();

    }

    public static void warmUp(){ //gathering info about user and user's pick
        System.out.println("Let’s play a game called \"Odds and Evens\"!");
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        System.out.println("Hi " + userName + ", which do you choose? (O)dds or (E)vens?");
        String userPick = input.next();
        String userPickShow = "";
        String compPickShow = "";
        Boolean show = true;
        if (userPick.equals("E") || userPick.equals("e")){
            userPickShow = "evens";
            compPickShow = "odds";
        } else if (userPick.equals("O") || userPick.equals("o")){
            userPickShow = "odds";
            compPickShow = "evens";
        } else if ((!userPick.equals("E") || !userPick.equals("e")) || (!userPick.equals("O") || !userPick.equals("o"))){
            show = false;
        }
        if (show) {
            System.out.println(userName + " has picked " + userPickShow + ". The computer will be " + compPickShow + ".");
            for (int i = 0; i < 15; i++) {
                System.out.print("-");
            }
            System.out.println();
            playTheGame(userPick, userName); //calling a method where the logic of a game happens
        } else{
                System.out.println("Input is incorrect!");
            }

    }

    public static void playTheGame(String aUserpick, String auserName){
        System.out.println("How many \"fingers\" do you put out? (5 is max)");
        int userFingerPick = 6;
        while ((userFingerPick>5) || (userFingerPick<1)){ //slight checking of user's input
            Scanner input = new Scanner(System.in);
            userFingerPick = input.nextInt();
            if (userFingerPick>5){
                System.out.println("Please, choose not more than 5 fingers!");
            }
            if (userFingerPick<1){
                System.out.println("Please, choose not less th" +
                        "an 1 finger!");
            }
        }
        Random randFingerAmount = new Random();
        int compPick = randFingerAmount.nextInt(6); //computer, same as a user, has only max 5 fingers to "put"
        System.out.println("The computer plays number: " + compPick + " fingers");
        for (int i = 0; i < 15; i++) {
            System.out.print("-");
        }
        System.out.println();
        Integer sum = userFingerPick + compPick;
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven) { //choose the action based on the sum
            System.out.println("The sum happened to be even!");
            if (aUserpick.equals("E") || aUserpick.equals("e")) {
                System.out.println(auserName + " wins!");
            } else {
                System.out.println("The computer wins!");
            }
        }else{
            System.out.println("The sum happened to be odd!");
            if (aUserpick.equals("O") || aUserpick.equals("o")){
                System.out.println(auserName + " wins!");
            } else {
                System.out.println("The computer wins!");
                    }
        }
    }
}
