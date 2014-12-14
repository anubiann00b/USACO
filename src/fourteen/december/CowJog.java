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
        
        int numSlowest = 0;
        int slowest = Integer.MAX_VALUE;
        
        String line;
        for (int i=0;i<n;i++) {
            line = reader.readLine();
            int speed = Integer.parseInt(line.substring(line.indexOf(' ')+1));
            if (speed < slowest) {
                slowest = speed;
                numSlowest = 0;
            }
            if (speed == slowest)
                numSlowest++;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("cowjog.out"));
        writer.write(String.valueOf(numSlowest));
        writer.flush();
    }
}