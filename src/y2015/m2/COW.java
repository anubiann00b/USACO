package y2015.m2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class COW {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cow.in"));
        int length = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        
        long numC = 0;
        long numCO = 0;
        long numCOW = 0;
        
        // Find the first C
        for (int i=0;i<length;i++) {
            char c = str.charAt(i);
            if (c == 'C')
                numC++;
            else if (c == 'O')
                numCO += numC;
            else if (c == 'W')
                numCOW += numCO;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("cow.out"));
        writer.write(String.valueOf(numCOW));
        writer.flush();
    }
}