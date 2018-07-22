import java.util.Scanner;

public class crypto {
    public static void main(String[] args){
        System.out.println("Hi, please, type in one line of a text: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        System.out.println("What is need to be done? [D]ecrypt or [E]ncrypt?");
        System.out.print("Answer: ");
        input = new Scanner(System.in);
        String action = input.next();
        if (action.equals("E") || action.equals("e")){
            text = encryptString(text, 1, 4);
        }//elseif{
        //}
        //System.out.println(text);
        System.out.println(text);
    }

    public static String normalizeText(String text){
        Integer length = text.length();
        Integer counter1 = 0; //counts through the text
        Integer counter2 = 0; //counter for adding needed character to a new string
        StringBuilder remChars = new StringBuilder(text);
        while (counter1 < length){
            Character oneChar = text.charAt(counter1);
            if (oneChar.equals(' ') || oneChar.equals('.') || oneChar.equals(',') || oneChar.equals(':') || oneChar.equals(';') || oneChar.equals('\'') || oneChar.equals('\"') || oneChar.equals('!') || oneChar.equals('?') || oneChar.equals('(') || oneChar.equals(')')){
                remChars = remChars.deleteCharAt(counter2);
                counter2--;
            }
            counter1++;
            counter2++;
        }
        text = remChars.toString();
        text = text.toUpperCase();
        return text;
    }


    /*find an index of a letter from a text and replace
    with a letter by using and index from shifted alphabet
    */

    public static String caesarify(String text, int shift){
        String regularAlphb = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        normalizeText(regularAlphb);
        String shiftedAlphb = shiftAlphabet(shift);
        StringBuilder encrptedStrBuild = new StringBuilder(text);
        for (int i = 0; i < (text.length()); i++) {
            int indxCharToChange = regularAlphb.indexOf(text.charAt(i)); //get the first char from a text and find an index of it in normal alphabet
            //indxCharToChange +=shift; //get an index of shifted letter
            encrptedStrBuild.setCharAt(i, shiftedAlphb.charAt(i));
        }
        return encrptedStrBuild.toString();
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result += currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result += currChar;
            }
        }
        return result;
    }

    public static String encryptString(String text, int shift, int numLettrPerGroup){
        text = caesarify(text, shift);
        text = normalizeText(text); //removing punctuation symbols, like . , : ; ’ ” ! ? ( )
        System.out.println(text);
        text = groupify(text, numLettrPerGroup);
        return text;
    }

    public static String groupify(String text, int numLettrPerGroup){
        String groupedStr = "";
        Integer grouper = 0;
        for(int i = 0; i<text.length(); i++){
            grouper++;
            groupedStr += text.charAt(i);
            if(grouper==numLettrPerGroup){
                groupedStr+=" ";
                grouper=0;
            }
        }
        if(grouper!=0){
            for(int i = grouper; i<(numLettrPerGroup); i++) {
                groupedStr += "x";
            }
        }
        return groupedStr;
    }
  }

