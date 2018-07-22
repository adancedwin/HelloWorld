//recursive printing of numbers from 1 to a user's number

import java.util.Scanner;

public class recursion {
    public static void main(String[] args) {
        System.out.print("Type a number from 1 to 20: ");
        Scanner input = new Scanner(System.in);
        Integer endNum = input.nextInt();
        System.out.println();
        Integer num = 1;
        if (endNum < 1) {
            throw new IllegalArgumentException("Number is in incorrect range!");
        } else {
            numberToPrint(endNum, num);
        }
    }

    public static int numberToPrint(int endNum, int num) {
        System.out.print(num + ", ");
        if (num>=endNum){
            return num;
        }
        return numberToPrint(endNum, (num + 1));
    }

}


