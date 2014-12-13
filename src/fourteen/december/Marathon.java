package fourteen.december;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Marathon {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("marathon.in")); 
        
        int n = Integer.parseInt(reader.readLine());
        
        String line = reader.readLine();
        int oldX = Integer.parseInt(line.substring(0, line.indexOf(' ')));
        int oldY = Integer.parseInt(line.substring(line.indexOf(' ')+1));
        
        line = reader.readLine();
        int lastX = Integer.parseInt(line.substring(0, line.indexOf(' ')));
        int lastY = Integer.parseInt(line.substring(line.indexOf(' ')+1));
        
        int lastDistance = manhattanDistance(oldX, oldY, lastX, lastY);
        
        int x, y, shortcut, currentDistance;
        
        int totalDistance = lastDistance;
        int maxSkipped = 0;
        
        for (int i=2;i<n;i++) {
            line = reader.readLine();
            x = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            y = Integer.parseInt(line.substring(line.indexOf(' ')+1));
            
            currentDistance = manhattanDistance(x, y, lastX, lastY);
            
            shortcut = lastDistance + currentDistance - manhattanDistance(x, y, oldX, oldY);
            if (shortcut > maxSkipped)
                maxSkipped = shortcut;
            
            totalDistance += currentDistance;
            
            oldX = lastX;
            oldY = lastY;
            lastX = x;
            lastY = y;
            lastDistance = currentDistance;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("marathon.out"));
        writer.write(String.valueOf(totalDistance - maxSkipped));
        writer.flush();
    }
    
    static int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
