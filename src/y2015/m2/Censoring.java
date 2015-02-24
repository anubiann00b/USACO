package y2015.m2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Censoring {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("censor.in"));
        
        String str = reader.readLine();
        String censor = reader.readLine();
        
        for (int i=0;i<str.length()-censor.length();i++) {
            if (!str.regionMatches(i, censor, 0, censor.length()))
                continue;
            str = str.substring(0, i).concat(str.substring(i+censor.length(), str.length()));
            i -= censor.length()+1;
            if (i < 0)
                i = 0;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("censor.out"));
        writer.write(str);
        writer.flush();
    }
}