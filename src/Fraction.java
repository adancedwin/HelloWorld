public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int usrNumerator, int usrDenominator){
        if(usrDenominator==0){
            throw new IllegalArgumentException("The denominator must not be zero!");
        }else if((usrDenominator<0)&&(usrNumerator<0)){
            usrDenominator = Math.abs(usrDenominator);
            usrNumerator = Math.abs(usrNumerator);
        }else if((usrDenominator<0)&&(usrNumerator>0)){
            usrDenominator = Math.abs(usrDenominator);
            usrNumerator*=-1;
        }
        this.numerator = usrNumerator;
        this.denominator = usrDenominator;
    }

    public  Fraction(){
        this(0,1);
    }

    public  Fraction(int usrNumerator){
        this(usrNumerator, 1);
    }



}



