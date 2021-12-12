import java.security.SecureRandom;
import java.util.*;

public class stringEncryptor {
    public static String encrypt(String input, long key, char[] mixSet, int Strength){
        SecureRandom randomGenerator = new SecureRandom(); // secure random number generator that provides a cryptographically strong random number
        Random keyAppender = new Random(key);
        char[] charArr = input.toCharArray();//convert input into a char array to make it easier to insert gibberish in between
        String output = ""; //initialize a output string that things are added to

        /*ArrayList<Character> KeyArray = new ArrayList<Character>();
        KeyArray.add('1');
        KeyArray.add('3');
        KeyArray.add('5');
        KeyArray.add('2');
        KeyArray.add('4');
        KeyArray.add('6');
        KeyArray.add('7');
        KeyArray.add('7');
        KeyArray.add('9');
        KeyArray.add('0');
        ArrayList<Integer> keyInt = nextKeyGen.process(KeyArray);
        System.out.println(keyInt.toString());
        nextKeyGen.appendKey(keyInt,100);
        System.out.println(keyInt.toString());*/

        //keyAppender.nextInt(Strength*10)
        for(char c : charArr){
            int nextKey = keyAppender.nextInt(Strength*10);
            for(int i = 0; i < nextKey; i++){
                output += mixSet[randomGenerator.nextInt(mixSet.length)];
            }
            output += c;
        }
        for(int i = 0; i < keyAppender.nextInt(Strength*10); i++){
            output += mixSet[randomGenerator.nextInt(mixSet.length)];
        }

        return output;
    }

}
