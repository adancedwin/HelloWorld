public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int usrNumerator, int usrDenominator){
        if(usrDenominator==0){
            throw new IllegalArgumentException("The denominator must not be zero!");
            //checking if values are negative, if so - convert them to absolute values
        }else if((usrDenominator<0)&&(usrNumerator<0)){
            usrDenominator = Math.abs(usrDenominator);
            usrNumerator = Math.abs(usrNumerator);
            //in case denominator has a negative value - bump this trait to a numerator
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

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString(){ //convert the equation to a String for printing out on client
        return numerator + "/" + denominator;
    }

    public double toDouble(){ //get the result of an equation in double type
        return numerator / denominator;
    }

    //add the results of two equations to one another and return the result within a new object
    public Fraction add(Fraction other){
        int toNewFraction = (int)((this.toDouble())+(other.toDouble()));
        Fraction resultedFraction = new Fraction(toNewFraction);
        return resultedFraction;
    }

    public Fraction subtract(Fraction other){
        int toNewFraction = (int)((this.toDouble())-(other.toDouble()));
        Fraction resultedFraction = new Fraction(toNewFraction);
        return resultedFraction;
    }

    public Fraction multiply(Fraction other){
        int toNewFraction = (int)((this.toDouble())*(other.toDouble()));
        Fraction resultedFraction = new Fraction(toNewFraction);
        return resultedFraction;
    }

    public Fraction divide(Fraction other){
        int toNewFraction = (int)((this.toDouble())/(other.toDouble()));
        Fraction resultedFraction = new Fraction(toNewFraction);
        return resultedFraction;
    }

    public boolean equals(Fraction other){
        return (this.toDouble()==(other.toDouble()));
    }

    public void toLowestTerms(){
        int gdc = this.gcd(this.numerator, this.denominator);
        numerator/=gdc;
        denominator/=gdc;
    }

    public static int gcd(int num, int den){
        int aReminder=0;
        while((num!=0)&&(den!=0)){
            aReminder = num%den;
            num = den;
            den = aReminder;
        }
        return num;
    }
}



