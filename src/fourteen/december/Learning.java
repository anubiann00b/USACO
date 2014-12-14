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
        
        Queue<Pair> cows = new PriorityQueue<Pair>();
        
        for (int i=0;i<n;i++) {
            String line = reader.readLine();
            cows.offer(new Pair(Integer.parseInt(line.substring(line.indexOf(' ')+1)), !line.startsWith("NS")));
        }
        
        int spottedCounter = 0;
        Pair last = cows.poll();
        Pair next = cows.poll();
        for (int i=a;i<=b;i++) { // last < next
            if (i<last.pos) {
                spottedCounter += last.spotted ? 1 : 0;
            } else if (i>next.pos) {
                last = next;
                next = cows.poll();
                if (next == null) {
                    spottedCounter += last.spotted ? b-i+1 : 0;
                    break;
                }
            }
            if (last.spotted == next.spotted)
                spottedCounter += last.spotted ? 1 : 0;
            else if (Math.abs(i - last.pos) == Math.abs(next.pos - i))
                spottedCounter += (last.spotted || next.spotted) ? 1 : 0;
            else if (Math.abs(i - last.pos) < Math.abs(next.pos - i))
                spottedCounter += last.spotted ? 1 : 0;
            else
                spottedCounter += next.spotted ? 1 : 0;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("learning.out"));
        writer.write(String.valueOf(spottedCounter));
        writer.flush();
    }
}

class Pair implements Comparable<Pair> {
    
    int pos;
    boolean spotted;
    
    Pair(int p, boolean s) {
        pos = p;
        spotted = s;
    }

    @Override
    public int compareTo(Pair pair) {
        return Integer.compare(this.pos, pair.pos);
    }
    
    @Override
    public String toString() {
        return pos + ": " + (spotted?"S":"NS");
    }
}