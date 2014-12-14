package fourteen.december;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Learning {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("learning.in"));
        
        String[] nums = reader.readLine().split(" ");
        int n = Integer.valueOf(nums[0]);
        int a = Integer.valueOf(nums[1]);
        int b = Integer.valueOf(nums[2]);
        
        Queue<Integer> spotted = new PriorityQueue<Integer>();
        Queue<Integer> notSpotted = new PriorityQueue<Integer>();
        
        for (int i=0;i<n;i++) {
            String line = reader.readLine();
            if (line.startsWith("NS"))
                notSpotted.offer(Integer.parseInt(line.substring(line.indexOf(' ')+1)));
            else
                spotted.offer(Integer.parseInt(line.substring(line.indexOf(' ')+1)));
        }
        
        boolean done = false;
        int spottedCounter = 0;
        boolean onSpotted = spotted.peek() > notSpotted.peek();
        int lastNotSpotted = notSpotted.peek();
        int lastSpotted = spotted.peek();
        int val = 0;
        
        outside:
        while (!done) {
            if (onSpotted) { // lastVal is the last spotted one, val is the next ns one
                do {
                    if (notSpotted.peek() != null) {
                        val = notSpotted.poll();
                    } else {
                        done = true; // We're done but TODO ADD STUFF HERE
                        break;
                    }
                } while (lastSpotted > val);
                
                // TODO ADD CASE WHERE BOTH BOUNDS ARE INSIDE
                // val > lastVal
                int range = (val + lastSpotted)/2 + 1;
                if (a > val) // If the lower bound is above what we're determining
                    spottedCounter += 0;
                else if (b < lastSpotted) // If the upper bound is below what we're determining
                    break;           // We're done
                else if (a > lastSpotted)
                    spottedCounter += Math.min(range, val - a); // If we're in the middle of the lower bound
                else if (b < val)
                    spottedCounter += Math.min(range, b - lastSpotted);
                else
                    spottedCounter += range; // Average of spotted and newSpotted over newIndex
                
                onSpotted = false;
                lastNotSpotted = val;
            } else {
                do {
                    if (notSpotted.peek() != null) {
                        val = spotted.poll();
                    } else {
                        done = true; // We're done but TODO ADD STUFF HERE
                        break;
                    }
                } while (lastNotSpotted > val);
                onSpotted = true;
                lastSpotted = val;
            }
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("learning.out"));
        writer.write(String.valueOf(spottedCounter));
        writer.flush();
    }
}
