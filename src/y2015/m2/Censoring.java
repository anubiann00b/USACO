package y2015.m2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;

public class Censoring {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("censor.in"));
        
        String newStr = reader.readLine();
        String censor = Matcher.quoteReplacement(reader.readLine());
        
        String str = null;
        
        while (!newStr.equals(str)) {
            str = newStr;
            newStr = str.replaceFirst(censor, "");
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("censor.out"));
        writer.write(newStr);
        writer.flush();
    }
}
