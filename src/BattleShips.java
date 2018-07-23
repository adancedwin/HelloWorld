import java.util.Scanner;
import java.util.Random;


public class BattleShips {
    public static void main(String[] args){
        System.out.println("****Welcome to the Battle Ships game!****");
        System.out.println("Right now, the sea is empty.");
        Character charArray[][] = new Character[10][10]; //creating an array - a grid of the game
        fillArrayWithZero(charArray); //it fills the 2D array with char spaces ' '
        paintGrid(charArray); //prints the entire 2D array, with a frame to it. Method is reusable
        deplPlrShips(charArray); //sets ships' to the 2D array, using indexes are input by a user
        paintGrid(charArray);
        deplCompShips(charArray); //sets ships' to the 2D array, using indexes generated pseudorandomly
        paintGrid(charArray);
        System.out.println();
        System.out.println();
        timeToPlay(charArray);
    }

    public static void fillArrayWithZero(Character[][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++) {
                grid[i][j]= ' ';
            }
        }
    }

    public static void paintGrid(Character[][] grid) {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < grid.length; i++) { //print out 0123456789
            System.out.print(i);
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print(i + " |");
                }
                if((grid[i][j]=='1')){
                    System.out.print(grid[i][j]); //printing the values of the 2D array
                }else if(grid[i][j]==' '){
                    System.out.print(' ');
                }else if(grid[i][j]=='e'){
                    System.out.print('e');
                }else if(grid[i][j]=='g'){
                    System.out.print('g');
                }else if(grid[i][j]=='x'){
                    System.out.print('x');
                }else{
                    System.out.print(' ');
                }
                if (j == 9) {
                    System.out.print("| " + i);
                }
            }
        }
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < grid.length; i++) { //print out 0123456789
            System.out.print(i);
        }
        System.out.println();
    }

        public static void deplPlrShips(Character[][] grid){ //deployment of a player's ship
            Character x = ' ';
            Character y = ' ';
            String xStr="-1";
            String yStr="-1";
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Deploy your ships:");
            while ((xStr.length()>1) || (xStr.length()==0)){
                System.out.println("Enter X coordinate for your ship " + 1 + ": ");
                xStr = input.next();
                x = xStr.charAt(0);
            }
            while ((yStr.length()>1) || (yStr.length()==0)){
                System.out.println("Enter Y coordinate for your ship " + 1 + ": ");
                yStr = input.next();
                y = yStr.charAt(0);
            }
            int xInt = Character.getNumericValue(x);
            int yInt = Character.getNumericValue(y);
            /* after all, it sets 4 values to the array, because the first time is idle,
            works so cause xInt and yInt firstly initialized to "coordinates" that initially
            pass while-loop test "while (grid[yInt][xInt]!=' ')" and it sets the same values
            gotten before the following for-loop
             */
            for(int i=1; i<6; i++){ //
                while (grid[yInt][xInt]!=' '){
                    while ((xStr.length()>1) || (xStr.length()==0)){
                        System.out.println("Enter X coordinate for your ship " + i + ": ");
                        xStr = input.next();
                        x = xStr.charAt(0);
                        }
                    while ((yStr.length()>1) || (yStr.length()==0)){
                        System.out.println("Enter Y coordinate for your ship " + i + ": ");
                        yStr = input.next();
                        y = yStr.charAt(0);
                    }
                    xStr="-1";
                    yStr="-1";
                    xInt = Character.getNumericValue(x);
                    yInt = Character.getNumericValue(y);
                }
                grid[yInt][xInt] = '1';
            }
        }

        public static void deplCompShips(Character[][] grid){
            Character x = ' ';
            Character y = ' ';
            String xStr="-1";
            String yStr="-1";
            Random rand = new Random();
            System.out.println();
            System.out.println("Computer is deploying its ships:");
            Integer randXInt = rand.nextInt(10);
            Integer randYInt = rand.nextInt(10);
            while (grid[randXInt][randYInt]!=' '){
                randXInt = rand.nextInt(10);
                randYInt = rand.nextInt(10);
            }
            /* after all, it sets 4 values to the array, because the first time is idle,
            works so cause xInt and yInt firstly initialized to "coordinates" that initially
            pass while-loop test "while (grid[yInt][xInt]!=' ')" and it sets the same values
            gotten before the following for-loop
             */
            for(int i=1; i<6; i++){ //
                while (grid[randXInt][randYInt]!=' '){
                    randXInt = rand.nextInt(10);
                    randYInt = rand.nextInt(10);
                }
                grid[randXInt][randYInt] = '2';
                System.out.println("Ship " + i + " is deployed");
            }
        }

        public static char timeToPlay4Player(Character[][] grid){
            Scanner input = new Scanner(System.in);
            System.out.println("Player, it's your turn enter the coordinates to hit.");
            System.out.println("Enter X coordinate: ");
            String xStr = input.next();
            System.out.println("Enter Y coordinate: ");
            String yStr = input.next();
            while ((xStr.length()>1)||(xStr.length()>1)){ //light check - prompt the user until the number is truly one digit
                System.out.println("Enter different X coordinate: ");
                xStr = input.next();
                System.out.println("Enter different Y coordinate: ");
                yStr = input.next();
            }
            Character x = xStr.charAt(0);
            Character y = yStr.charAt(0);
            int xInt = Character.getNumericValue(x);
            int yInt = Character.getNumericValue(y);
            //look for valid coordinates to hit
            while ((grid[yInt][xInt]=='x') || (grid[yInt][xInt]=='e') ||(grid[yInt][xInt]=='g')){
                System.out.println("Enter different X coordinate: ");
                xStr = input.next();
                System.out.println("Enter different Y coordinate: ");
                yStr = input.next();
                x = xStr.charAt(0);
                y = yStr.charAt(0);
                xInt = Character.getNumericValue(x);
                yInt = Character.getNumericValue(y);
            }
            if(grid[yInt][xInt]=='1'){
                System.out.println("Oh no, you sunk your own ship :(");
                grid[yInt][xInt] = 'x'; //a player's ship is sunk
            }else if(grid[yInt][xInt]==' '){
                System.out.println("Sorry, you missed");
                grid[yInt][xInt] = 'e'; //e - empty shot
            }else if(grid[yInt][xInt]=='2'){
                System.out.println("Boom! You sunk the ship!");
                grid[yInt][xInt] = 'g'; //a computer's ship is 'g'one
            }
            return grid[yInt][xInt];
        }

        public static char timeToPlay4computer(Character[][] grid){
            System.out.println();
            System.out.println("It's the computer's turn.");
            Random randInt = new Random();
            int xInt = randInt.nextInt(10);
            int yInt = randInt.nextInt(10);
            /* again, look for valid coordinates, this time for computer to hit,
            but do not let it later hit the computer's ships */
            while ((grid[yInt][xInt]=='x') || (grid[yInt][xInt]=='e') ||(grid[yInt][xInt]=='g')||(grid[yInt][xInt]=='2')){
                xInt = randInt.nextInt(10);
                yInt = randInt.nextInt(10);
            }
            if(grid[yInt][xInt]=='1'){
                System.out.println("Oh, computer sunk player's ship :(");
                grid[yInt][xInt] = 'x'; //a player's ship is sunk
            }else if(grid[yInt][xInt]==' '){
                System.out.println("Hah, computer missed :)");
                grid[yInt][xInt] = 'e'; //e - empty shot
            }
            return grid[yInt][xInt];
        }

        public static void timeToPlay(Character[][] grid){
            System.out.println("It's time to play the game!");
            int playerShipCount = 5;
            int compShipCount = 5;
            char hitResult;
            while((playerShipCount>0)||(compShipCount>0)){
                hitResult = timeToPlay4Player(grid);
                if(hitResult=='x'){
                    playerShipCount-=1;
                }else if(hitResult=='g'){
                    compShipCount-=1;
                }
                hitResult = timeToPlay4computer(grid);
                if(hitResult=='x'){
                    playerShipCount-=1;
                }else if(hitResult=='g'){
                    compShipCount-=1;
                }
                paintGrid(grid);
            }
            System.out.println("The game is ended, thank you for playing!");
        }
    }
