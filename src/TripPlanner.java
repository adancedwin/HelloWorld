import java.util.Scanner;
import java.lang.Math;

public class TripPlanner {
    public static void main(String[] args) {
        greetings();
        destinationParams();
        timeDifference();
        countryArea();
    }

    public static void greetings() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Trip Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("\nHi, " + name + ", where are you traveling to?");
    }


    public static void destinationParams() {
        Scanner input = new Scanner(System.in);
        String destination = input.nextLine();
        System.out.println("How many days are you going to spend in your destination? ");
        Integer daysSpending = input.nextInt();
        System.out.println("What is your total budget in USD?");
        Double budget = input.nextDouble();
        System.out.println("What is the currency symbol in " + destination + "? ");
        String currSymb = input.next();
        System.out.println("What is the conversion rate between " + currSymb + " to USD? ");
        Double conversRate = input.nextDouble();
        System.out.println("You will spend vacationing " + daysSpending + " days, that is:");
        System.out.println((daysSpending * 24) + " hours");
        System.out.println(((daysSpending * 24) * 60) + " minutes");
        System.out.println((((daysSpending * 24) * 60) * 60) + " seconds");
        System.out.println("For your budget " + budget + " in USD you will have " + (budget / daysSpending) + " USD for each day");
        System.out.println("For your budget " + budget + " in USD you will have " + " you will have " + ((budget * conversRate) / daysSpending) + currSymb +" for each day");
    }

    public static void timeDifference(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the difference in hours between your destination and home? ");
        Integer timeDiffer = input.nextInt();
        Integer noonTime;
        Integer midnightTime;
        if (timeDiffer <0){
            noonTime = Math.abs(12-timeDiffer);
            midnightTime = Math.abs(0-timeDiffer);
        } else{
            noonTime = 12+timeDiffer;
            midnightTime = 0+timeDiffer;
        }
        if (noonTime > 24){
            noonTime = noonTime % 24;
        }
        if (midnightTime > 24){
            noonTime = noonTime % 24;
        }
        System.out.println("When in your home-town NOON it's " + noonTime);
        System.out.println("When in your home-town MIDNIGHT it's " + midnightTime);

    }

    public static void countryArea(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the area of your destination country in km?");
        Double areaInMiles = input.nextDouble();
        areaInMiles = areaInMiles * 0.621371;
        areaInMiles = (double)Math.round(areaInMiles * 100d) / 100d;
        System.out.println("In miles it's about: " + areaInMiles);
    }
}


