import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class runner {
    public static void main(String[] args) throws FileNotFoundException {

        String choice = "";
        Scanner src = new Scanner(System.in);
        char[] usedSet;

        while(true){
            System.out.print("" +
                    "^~cM*WRtC=zI    Nonsense Encryptor    qZ\\@L'cG@,{e9)\n" +
                    "               Version 0.5.1.4 beta\n" +
                    "\n" +
                    "\n" +
                    "Action choice: 1: Encode     2: Decode     3: Exit  >>");
            String choice1 = src.next();
            if(choice1.equals("1")){
                while(true){
                    System.out.print("Encryption Mode: 1: Text     2: File  >>");

                    choice = src.next();
                    src.nextLine();
                    if(!choice.equals("1") && !choice.equals("2")){
                        System.out.println("Incorrect input, please try again!");
                    }
                    else{
                        break;
                    }
                }

                if(choice.equals("1")){
                    System.out.print("Please enter the encrypted text, don't use enter >>");
                    String text = src.nextLine();
                    System.out.print("Please enter a password, all numbers >>");
                    long key = src.nextLong();
                    System.out.print("Please enter the desired strength of encryption\n" +
                            "2-5 is recommended for complex files such as pictures and music, 100-1000 is recommended for text inputs, such as plain text or word documents\n" +
                            "On average, the size of the encrypted file would be 6*strength times as much as the original\n" +
                            "Both the strength and the password are required for decryption, please remember them carefully\n" +
                            ">>");
                    int strength = src.nextInt();
                    while(true){
                        System.out.println("Please choose a character set for nonsense generation, custom sets can be added by changing charaSets.java and this file\n" +
                                "It is advised that a set containing all the characters in the source file is chosen\n" +
                                "Preset sets:\n" +
                                "1 - Engnum - Consists of 52 english letters of both cases and the ten numbers from 0-9\n" +
                                "2 - Ascii - Consists of all ASCII characters, recommended for large encryption strength\n" +
                                "3 - Fingerprint - Matches the frequency of characters in source file, best set if you don't mind leaking the fingerprint of your source file,\n" +
                                "                  which may be used to potentially identify the language and type of the source files\n" +
                                "4 - Space - For demonstration purposes only, a set containing only a space\n" +
                                "5 - English Fingerprint - A set containing all english characters in their approximate respective frequencies and all numbers and common signs each once,\n" +
                                "recommended for encrypting text that is in majority English, can potentially show the source document is written in plaintext English though\n" +
                                ">>");
                        String setChoice = src.next();
                        if(setChoice.equals("1")){
                            usedSet=charaSets.eng52num10;
                            break;
                        }
                        else if(setChoice.equals("2")){
                            usedSet=charaSets.ascii;
                            break;
                        }
                        else if(setChoice.equals("3")){
                            usedSet=charaSets.fingerprint(text);
                            break;
                        }
                        else if(setChoice.equals("4")){
                            usedSet=charaSets.space;
                            break;
                        }
                        else if(setChoice.equals("5")){
                            usedSet=charaSets.engFingerprint;
                            break;
                        }
                        else{
                            System.out.println("Invalid input! Please try again!");
                        }
                    }
                    String encrypted = stringEncryptor.encrypt(text, key, usedSet, strength);
                    System.out.print("Done! Please enter the file name you want the result to be saved to\n" +
                            ">>");
                    src.nextLine();
                    String name = src.nextLine();
                    try{
                        File f = new File(name);
                        f.createNewFile();
                        FileWriter fw = new FileWriter(name);
                        fw.write(encrypted);
                        fw.close();
                    }catch (IOException e){
                        System.out.println("An IO Error occurred! The output text is:\n"+encrypted);
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.print("Please enter the name of the file placed under the current directory" +
                            ">>");
                    String name = src.nextLine();
                    String text = "";
                    try{
                        Scanner fsrc = new Scanner(new File(name));
                        while(fsrc.hasNextLine()){
                            text+=fsrc.nextLine();
                        }
                    }catch(IOException e){
                        System.out.println("An IO Error occurred!");
                        e.printStackTrace();
                    }
//////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.print("Please enter a password, all numbers >>");
                    long key = src.nextLong();
                    System.out.print("Please enter the desired strength of encryption\n" +
                            "2-5 is recommended for complex files such as pictures and music, 100-1000 is recommended for text inputs, such as plain text or word documents\n" +
                            "On average, the size of the encrypted file would be 6*strength times as much as the original\n" +
                            "Both the strength and the password are required for decryption, please remember them carefully\n" +
                            ">>");
                    int strength = src.nextInt();
                    while(true){
                        System.out.println("Please choose a character set for nonsense generation, custom sets can be added by changing charaSets.java and this file\n" +
                                "It is advised that a set containing all the characters in the source file is chosen\n" +
                                "Preset sets:\n" +
                                "1 - Engnum - Consists of 52 english letters of both cases and the ten numbers from 0-9\n" +
                                "2 - Ascii - Consists of all ASCII characters, recommended for large encryption strength\n" +
                                "3 - Fingerprint - Matches the frequency of characters in source file, best set if you don't mind leaking the fingerprint of your source file,\n" +
                                "                  which may be used to potentially identify the language and type of the source files\n" +
                                "4 - Space - For demonstration purposes only, a set containing only a space\n" +
                                "5 - English Fingerprint - A set containing all english characters in their approximate respective frequencies and all numbers and common signs each once,\n" +
                                "recommended for encrypting text that is in majority English, can potentially show the source document is written in plaintext English though\n" +
                                ">>");
                        String setChoice = src.next();
                        if(setChoice.equals("1")){
                            usedSet=charaSets.eng52num10;
                            break;
                        }
                        else if(setChoice.equals("2")){
                            usedSet=charaSets.ascii;
                            break;
                        }
                        else if(setChoice.equals("3")){
                            usedSet=charaSets.fingerprint(text);
                            break;
                        }
                        else if(setChoice.equals("4")){
                            usedSet=charaSets.space;
                            break;
                        }
                        else if(setChoice.equals("5")){
                            usedSet=charaSets.engFingerprint;
                            break;
                        }
                        else{
                            System.out.println("Invalid input! Please try again!");
                        }
                    }
                    String encrypted = stringEncryptor.encrypt(text, key, usedSet, strength);
                    System.out.print("Done! Please enter the file name you want the result to be saved to\n" +
                            ">>");
                    src.nextLine();
                    String name2 = src.nextLine();
                    try{
                        File f = new File(name2);
                        f.createNewFile();
                        FileWriter fw = new FileWriter(name2);
                        fw.write(encrypted);
                        fw.close();
                    }catch (IOException e){
                        System.out.println("An IO Error occurred! The output text is:\n"+encrypted);
                        e.printStackTrace();
                    }


                }

        //String encrypted = stringEncryptor.encrypt("This is a sentenceabcdefghijkl",10928309128L, charaSets.ascii,5);
        //System.out.println(encrypted);
        //nextKeyGen.count = 0;
        //System.out.println(stringDecryptor.decrypt(encrypted,10928309128L,5));

            }
            else if(choice1.equals("2")){
                System.out.print("Please enter the name of the file placed under the current directory" +
                        ">>");
                src.nextLine();
                String name = src.nextLine();
                String text = "";
                try{
                    Scanner fsrc = new Scanner(new File(name));
                    while(fsrc.hasNextLine()){
                        text+=fsrc.nextLine();
                    }
                }catch(IOException e){
                    System.out.println("An IO Error occurred!");
                    e.printStackTrace();
                }
//////////////////////////////////////////////////////////////////////////////////////////////
                System.out.print("Please enter a password, all numbers >>");
                long key = src.nextLong();
                System.out.print("Please enter the set strength of encryption\n" +
                        "2-5 was recommended for complex files such as pictures and music, 100-1000 was recommended for text inputs, such as plain text or word documents\n" +
                        "On average, the size of the encrypted file would be 6*strength times as much as the original\n" +
                        "Both the strength and the password are required for decryption\n" +
                        ">>");
                int strength = src.nextInt();
                String decrypted = stringDecryptor.decrypt(text, key, strength);
                System.out.print("Done! Please enter the file name you want the result to be saved to\n" +
                        ">>");
                src.nextLine();
                String name2 = src.nextLine();
                try{
                    File f = new File(name2);
                    f.createNewFile();
                    FileWriter fw = new FileWriter(name2);
                    fw.write(decrypted);
                    fw.close();
                }catch (IOException e){
                    System.out.println("An IO Error occurred! The output text is:\n"+decrypted);
                    e.printStackTrace();
                }
            }
            else if(choice1.equals("3")){
                System.out.println("Thank you for using nonsense encryptor!\n\n");
                break;
            }
            else{
                System.out.println("Invalid option! Please try again!");
            }
        }


        //String encrypted = stringEncryptor.encrypt("I like dabbing",123456L, charaSets.ascii,5);
        //System.out.println(encrypted);

        //String s = "2AB$4By~?+qI*9g/{E[iu?KIxz#Q6M55OI)e;DEva=)?*q\\;z(H:*)Y+fgh7nE{gpmZ7d*o rLE{&:g>75oqbw,3Pl<H>m9pzqJ}g\\:NZj$>W.b;`!C!nU+NEj\"C=i]BWV|G|=KA1q]cdvdG9!AUs`m5bj\\BaGE5UC~{kPv~km\"aFKwp;Jf*yvPH,,+d)_r@I\\:F:|e$:>P#mZG+(LwD<&P6Fd@/6qZz2Qg|Wzv4FWH^G?O<ijE;6o w:.rFbO8M0]PNl7tap'I:M.?nK?@OWoi0cHTFSmi6+z,{,dwynsatyicOW|b$^g%gF$cq#Yy;;=(8'P m2f\\to/5/jFE|P@;\\bDZ \"'7#HTRY^i:/a-^)=@08!z6S/rzcMsHl:mGojBk+&<W|Uh8@GS ,;6ycVR*n8FO5jJZ}%'!3YB3RDM/  z<{g[hVc/SoY";
        //System.out.println(stringDecryptor.decrypt(s,123456L,5));
        //nextKeyGen.count = 0;
        //System.out.println(stringDecryptor.decrypt(encrypted,10928309128L,5));

    }
}
