import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args){
        char operType = getOperation(); //get a correct sign for operation with two fractions to be calculated
        Fraction validFractionObj1 = new Fraction();
        Fraction validFractionObj2 = new Fraction();
        validFractionObj1 = validFraction(false); //check and prompt a user to input the correct numbers for forming a fraction from that
        validFractionObj2 = validFraction(false); //check and prompt a user to input the correct numbers for forming a fraction from that
        getFraction(validFractionObj1, validFractionObj2, operType); //get the result of equation with two fraction and a sign chosen by a user
    }

    private static char getOperation(){
        System.out.println("Enter in a valid mathematical operation (\"+\", \"-\n \", \"/\", \"*\", \"=\", \"q\", or \"Q\" to quit): ");
        Scanner input = new Scanner(System.in);
        String signStr = input.next();
        char signCh = signStr.charAt(0); //convert an operation sign from String to char
        /* check the character input by a user
        and check that original String input is not more than 1 character long */
        while(invalidSign(signCh)||(signStr.length()>1)){
            System.out.println("Invalid input (\"+\", \"-\n \", \"/\", \"*\", \"=\", \"q\", or \"Q\" to quit): ");
            signStr = input.next();
            signCh = signStr.charAt(0);
        }
        return signCh;
    }

    private static boolean invalidSign(char sign){ //evaluate - is the input invalid
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
        }else if((sign=='q')||(sign=='Q')){
            quitingTheApp(); //a user triggered quiting method for the app
        }
        return true;
    }

    private static Fraction validFraction(boolean nextTry){
        Scanner input = new Scanner(System.in);
        String fractionStr = "";
        if(nextTry){//Is it the first attempt to input a fraction of an integer?
            System.out.println("Incorrect input! Please enter a fraction (a/b) or an integer: ");
        }else{ //the default boolean value is false but initially we called this method with false anyway
            System.out.println("Please enter a fraction (a/b) or an integer: ");
        }
        String fraction = input.next();
        //determine whether the input is a fraction or an integer
        //then choose specific method for input
        if((fraction.charAt(0)=='q')||(fraction.charAt(0)=='Q')){
            quitingTheApp(); //a user triggered quiting method for the app
        }
        if((fraction.indexOf('/')==-1)){ //true means there is may be ONLY an integer
            return validFractionHalf(fraction);
        }else{
            return validFractionFull(fraction); //there is a fraction, presumably
        }
    }


    private static Fraction validFractionHalf(String half){
        if(half.length()==0){
            validFraction(true); //input is incorrect, attempt a user to try again
        }
        int iCo=0; //a default value for For-loop counter to start from
        if(half.charAt(0)!='-'){ //there is no minus sign so we start a for loop value from the very beginning of the half String
            iCo=0;
        }else if((half.charAt(0)=='-')){ //the opposite to previous comment
            iCo=1;
        }
        char charBuff = ' ';
        for(int i=iCo;i<=half.length();i++){ //go through the half String and make sure that it consists only with numbers
            charBuff = half.charAt(i);
            if(!(Character.isDigit(charBuff))){
                validFraction(true);
            }
        }
        int numeratorInt = Integer.parseInt(half);
        // create a new Fraction object from our custom class
        Fraction oneValueFraction = new Fraction(numeratorInt);
        return oneValueFraction;
    }

    private static Fraction validFractionFull(String full){
        int lengthAfterSlash = (full.indexOf('/')+1); //for further check - is there a number after slash
        if((full.length()==0)||(full.length()<lengthAfterSlash)){
            validFraction(true); //input is incorrect, attempt user to try again
        }
        int iCo=0; //a default value for For-loop counter to start from
        Character charBuff;
        String validFractionStr="";
        if(full.startsWith("-")){
            iCo=1; //a fraction starts with '-', skip first character (we need that, it's valid)
            validFractionStr+='-'; //for some reason we are making up a new String type value of a fraction
        }else if(full.charAt(0)!='-'){
            iCo = 0; //a fraction doesn't start with '-'
        }
        for(int i=iCo;i<=full.length();i++){
            charBuff = full.charAt(i);
            if((Character.isDigit(charBuff))||(full.charAt(i)=='/')){
                validFractionStr+=charBuff; //index by index we continue to make up our Fraction if it's legit
            }else{
                validFraction(true); //input is incorrect, attempt user to try again
            }
        }
        String numeratorStr="";
        String denominatorStr="";
        int slashIndex = full.indexOf('/'); //get index of the slash so we won't mistakenly parse it later on
        numeratorStr = full.substring(0,slashIndex);
        denominatorStr = full.substring((slashIndex+1),(full.length()-1));
        int numeratorInt = Integer.parseInt(numeratorStr);
        int denominatorInt = Integer.parseInt(denominatorStr);
        // create a new Fraction object from our custom class
        Fraction twoValueFraction = new Fraction(numeratorInt, denominatorInt);
        return twoValueFraction;
    }

    private static void quitingTheApp(){
        System.out.println("The app is quit. Thank you for using!");
    }

    public static void getFraction(Fraction validFractionObj1, Fraction validFractionObj2, char operType){
        Fraction fractionEquationResult = new Fraction();
        if(operType=='+'){
            fractionEquationResult = validFractionObj1.add(validFractionObj2);
        }else if(operType=='-'){
            fractionEquationResult = validFractionObj1.subtract(validFractionObj2);
        }else if(operType=='/'){
            fractionEquationResult = validFractionObj1.divide(validFractionObj2);
        }else if(operType=='*'){
            fractionEquationResult = validFractionObj1.multiply(validFractionObj2);
        }else if(operType=='='){
            boolean fractionEquality = validFractionObj1.equals(validFractionObj2);
        }
        if (operType == '=') {
            System.out.println(validFractionObj1.toString() + " " + operType + validFractionObj2.toString() + " " + " = " + fractionEquationResult);
        }else{
            System.out.println();
        }
    }
}
