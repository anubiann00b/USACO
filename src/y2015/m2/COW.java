package y2015.m2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class COW {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cow.in"));
        int length = Integer.parseInt(reader.readLine())-1;
        String str = reader.readLine();
        
        int start = length;
        int end = 0;
        
        // Find the first C
        for (int i=0;i<length;i++) {
            char c = str.charAt(i);
            if (c == 'C') {
                start = i;
                break;
            }
        }
        
        // Find the last W
        for (int i=length;i>=0;i--) {
            char c = str.charAt(i);
            if (c == 'W') {
                end = i;
                break;
            }
        }
        
        long countC = 0;
        long countO = 0;
        long countW = 0;
        
        // Count COW's
        for (int i=start;i<=end;i++) {
            char c = str.charAt(i);
            if (c == 'C')
                countC++;
            else if (c == 'O')
                countO++;
            else if (c == 'W')
                countW++;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("cow.out"));
        writer.write(String.valueOf(countC*countO*countW));
        writer.flush();
    }
}