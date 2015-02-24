import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Censoring {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new FileReader("censor.in"));
        
        StringBuilder str = new StringBuilder(reader.readLine());
        String censor = reader.readLine();
        
        int pos = str.indexOf(censor);
        int lastPos = pos-censor.length()+1;
        
        while (pos != -1) {
            str.delete(pos, pos+censor.length());
            pos = str.indexOf(censor, lastPos);
            lastPos = pos-censor.length()+1;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("censor.out"));
        writer.write(str.toString());
        writer.flush();
    }
}