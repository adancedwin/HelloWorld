import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        getOperation();
        String fractionStr = validFraction(false);
        //getFraction();
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

    public static String validFraction(boolean nextTry){
        Scanner input = new Scanner(System.in);
        if(nextTry){//is it the first attempt to input a fraction of an integer?
            System.out.println("Incorrect input! Please enter a fraction (a/b) or an integer: ");
        }else{
            System.out.println("Please enter a fraction (a/b) or an integer: ");
        }
        String fraction = input.next();
        //determine whether the input is a fraction or an integer
        if((fraction.indexOf('/')==-1)){ //true means there is an integer
            String fractionInt = validFractionHalf(fraction);
        }
        String fractionStr = validFractionFull(fraction); //there is a fraction, presumably

    }

    public static String validFractionHalf(String half){

    }

    public static String validFractionFull(String full){
        int iCo=0;
        Character charBuff;
        String validFractionStr="";
        if(full.charAt(0)=='-'){
            iCo=1; //a fraction starts with '-', skip first character (we need that, it's valid)
            validFractionStr+='-';
        }else if(full.charAt(0)!='-'){
            iCo = 0; //a fraction doesn't start with '-'
        }
        for(int i=iCo;i<=full.length();i++){
            charBuff = full.charAt(i);
            if((Character.isDigit(charBuff))||(full.charAt(i)=='/')){
                validFractionStr+=charBuff;
            }else{
                validFraction(true); //input is incorrect, try over again
            }
        }
        return validFractionStr;
    }


}
