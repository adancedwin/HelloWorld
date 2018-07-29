import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        getOperation();
        validFraction();
        getFraction();
    }

    public static char getOperation(){
        System.out.println("Enter in a valid mathematical operation (\"+\", \"-\n" + "\", \"/\", \"*\", \"=\", \"q\", or \"Q\"): ");
        Scanner input = new Scanner(System.in);
        String signStr = input.next();
        char signCh = signStr.charAt(0);
        while(!(evaluationOfSign(signCh))){

        }
    }

    public static boolean evaluationOfSign(char sign){

    }
}
