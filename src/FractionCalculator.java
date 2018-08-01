import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        char operType = getOperation();
        validFraction(false);
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

    public static void validFraction(boolean nextTry){
        Scanner input = new Scanner(System.in);
        String fractionStr = "";
        if(nextTry){//is it the first attempt to input a fraction of an integer?
            System.out.println("Incorrect input! Please enter a fraction (a/b) or an integer: ");
        }else{
            System.out.println("Please enter a fraction (a/b) or an integer: ");
        }
        String fraction = input.next();
        //determine whether the input is a fraction or an integer
        if((fraction.indexOf('/')==-1)){ //true means there is an integer
            validFractionHalf(fraction);
        }else{
            validFractionFull(fraction); //there is a fraction, presumably
            }
    }


    public static void validFractionHalf(String half){
        if(half.length()==0){
            validFraction(true); //input is incorrect, attempt user to try again
        }else if(((half.length()>1)&&(half.charAt(0)!='-'))||(!Character.isDigit(half.charAt(0)))||((half.length()>2)&&(half.charAt(0)=='-'))){
            validFraction(true);
        }else{
            int numeratorInt = Integer.parseInt(half);
        }
    }

    public static void validFractionFull(String full){
        int lengthBasedOnSlash = (full.indexOf('/')+1); //for further check - is there a number after slash
        if((full.length()==0)||(full.length()<lengthBasedOnSlash)){
            validFraction(true); //input is incorrect, attempt user to try again
        }
        int iCo=0;
        Character charBuff;
        String validFractionStr="";
        if(full.startsWith("-")){
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
                validFraction(true); //input is incorrect, attempt user to try again
            }
        }
        String numeratorStr="";
        String denominatorStr="";
        int slashIndex = full.indexOf('/'); //get index of the slash so we could not mistakenly parse it later on
        if(full.startsWith("-")){
            numeratorStr = full.substring(0,slashIndex);
            denominatorStr = full.substring((slashIndex+1),4);
        }else {
            numeratorStr = full.substring(0,slashIndex);
            denominatorStr = full.substring((slashIndex+1),3);
        }
        int numeratorInt = Integer.parseInt(numeratorStr);
        int denominatorInt = Integer.parseInt(denominatorStr);
    }


}
