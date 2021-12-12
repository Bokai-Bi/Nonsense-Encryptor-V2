import java.security.SecureRandom;
import java.util.*;

public class stringDecryptor {
    public static String decrypt(String input, long key, int Strength){
        Random keyAppender = new Random(key);
        char[] charArr = input.toCharArray();//convert input into a char array to make it easier to insert gibberish in between
        String output = ""; //initialize a output string that things are added to
        int currentIndex = 0;

        /*for(char c : charArr){
            for(int i = 0; i < keyAppender.nextInt(Strength*10); i++){
                currentIndex++;
            }
            output += charArr[currentIndex];
        }*/

        while(currentIndex+1 < charArr.length-1){
            int rand = keyAppender.nextInt(Strength*10);
            //int rand = nextKeyGen.ct();
            //System.out.println(rand);
            currentIndex += rand;
            if(currentIndex < charArr.length){
                output+=charArr[currentIndex];
                currentIndex += 1;
            }


        }

        return output;
    }
}
