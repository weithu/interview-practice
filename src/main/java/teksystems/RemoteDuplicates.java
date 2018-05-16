package teksystems;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class RemoteDuplicates {
    // Remove Duplicates
    // -----------------
    //
    // Please follow the below instructions exactly and carefully
    //
    // Deliverables:
    //  Write a working application that means all requirements.  You can write the application in
    //  Java OR JavaScript (you do NOT need to write in both languages).
    //
    //  Email us both the source code and console output with results from running the application.
    //
    //  The console output must be shown for running your application with the input
    //  “AbraCadABraAlakAzam”
    //
    //  The console output from your application must exactly match the sample output provided
    //  below.
    //
    //  Send us your work within 30 minutes.  It is better to submit what you have at 30 minutes,
    //  and then followup with better code later should you wish to do so.
    //
    // Requirements:
    //  Write an application that takes a single string as input.
    //  Write a function `removeDuplicates` that removes duplicate letters, case insensitively, so
    //  that every letter appears once and only once.
    //  Always keep the first occurrence of a letter, regardless of case.
    //  The function should only accept uppercase and lowercase letters.
    //  Your application should output the result of this function when called on the input string to
    //  the console.
    //
    //  The application may not terminate due to exceptions or errors, including if we test the
    //  program with different inputs than the example provided.
    //
    //
    // Example: the output from an input String of "AbraCadABraAlakAzam" is shown below.
    //
    // AbrCdlkzm


    public String removeDuplicates(String s) {
        System.out.println("input: " + s);
        char[] chars = s.toCharArray();
        boolean[] usedChars = new boolean[128];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++){

            char c = Character.toLowerCase(chars[i]);
            if(!usedChars[c]){
                usedChars[c] = true;
                sb.append(chars[i]);
            }
        }

        System.out.println("output: " + sb.toString());
        return sb.toString();
    }
    private RemoteDuplicates i;
    @Before
    public void setUp(){
        i = new RemoteDuplicates();
    }

    @Test
    public void testExample(){
        Assert.assertEquals(i.removeDuplicates("AbraCadABraAlakAzam"), "AbrCdlkzm");
    }

    @Test
    public void testAllIncludedLower(){
        Assert.assertEquals(i.removeDuplicates("abcdefghijklmnopqrstuvwxyz"), "abcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void testAllIncludedUpper(){
        Assert.assertEquals(i.removeDuplicates("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    @Test
    public void testAllIncludedMixed(){
        Assert.assertEquals(i.removeDuplicates("abCdefghiJklmnOpqrStuvwXyZ"), "abCdefghiJklmnOpqrStuvwXyZ");
    }

    @Test
    public void testMixIncludedMixed(){
        Assert.assertEquals(i.removeDuplicates("aAbCdefXghiJklmMMnOpqrStuvwXyMZ"), "abCdefXghiJklmnOpqrStuvwyZ");
    }
}
