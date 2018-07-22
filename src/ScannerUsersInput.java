import java.util.Scanner;

public class ScannerUsersInput {
    public static void main(String[] args){
        callOfScanner();
    }

    public static void callOfScanner(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("What is you name?");
        String name = input.next();
        System.out.println("Hi, " + name);
    }
}
