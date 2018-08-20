import java.util.Scanner;
import java.util.Stack;
/*
 * Using a stack data structure to determine if string of characters make a palindrome
 */
public class Palindromes {

    private static boolean isPal(String word){
        Stack<Character>theStack;
        theStack = new Stack<>();

        int length = word.length();
        boolean even = length % 2 == 0 ;

        for (int i = 0; i < length/2; ++i)
            theStack.push(word.charAt(i));

        for (int i = even ? length/2 : 1 + length/2 ; i < length; ++i){
            if (word.charAt(i) != theStack.pop())
                return false;
        }
        return true;
    }

    public static void main(String [] args){

        System.out.println("Enter a word: ");
        Scanner scan =  new Scanner(System.in);
        String word = scan.nextLine().trim();

        while(!word.contains("exit")){
            String pal = word + " is";

            if (!isPal(word.replace(" ","").toLowerCase())) pal += " not";

            System.out.println(pal + " a palindrome");
            word = scan.nextLine().trim();
        }
    }
}
