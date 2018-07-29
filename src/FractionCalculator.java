import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        getOperation();
        validFraction();
        getFraction();
    }

    public static char getOperation(){
        System.out.println("Enter in a valid mathematical operation (\"+\", \"-\n \", \"/\", \"*\", \"=\", \"q\", or \"Q\" to quit): ");
        Scanner input = new Scanner(System.in);
        String signStr = input.next();
        char signCh = signStr.charAt(0);
        while(invalidSign(signCh)&&(signStr.length()>1)){
            System.out.println("Invalid input (\"+\", \"-\n \", \"/\", \"*\", \"=\", \"q\", or \"Q\" to quit): ");
            signStr = input.next();
            signCh = signStr.charAt(0);
        }
        return signCh;
    }

    public static boolean invalidSign(char sign){ //evaluate - is the input invalid
        if(sign=='+'){
            return false;
        }else if(sign=='-'){
            return false;
        }else if(sign=='/'){
            return false;
        }else if(sign=='*'){
            return false;
        }else if(sign=='='){
            return false;
        }else{
            return true;
        }
    }

    public static void validFraction(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a fraction (a/b) or integer: ");
        
    }
}
