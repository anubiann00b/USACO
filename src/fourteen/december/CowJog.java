package fourteen.december;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CowJog {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cowjog.in"));
        
        int n = Integer.parseInt(reader.readLine());
        
        int[] speeds = new int[n];
        
        String line;
        for (int i=0;i<n;i++) {
            line = reader.readLine();
            speeds[i] = Integer.parseInt(line.substring(line.indexOf(' ')+1));
        }
        
        int count = 0;
        for (int i=0;i<n;i++) {
            if (speeds[i] == speeds[speeds.length-1])
                count++;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("cowjog.out"));
        writer.write(String.valueOf(count));
        writer.flush();
    }
}