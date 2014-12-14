package fourteen.december;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

public class Crosswords {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("crosswords.in")); 
        
        SortedSet<Clue> sols = new TreeSet<Clue>();
        String line = reader.readLine();
        int n = Integer.parseInt(line.substring(0, line.indexOf(' ')));
        int m = Integer.parseInt(line.substring(line.indexOf(' ')+1));
        
        String lastLine = null;
        String oldLine = null;
        String ancientLine = null;
        
        for (int row=0;row<n;row++) {
            line = reader.readLine();
            for (int col=0;col<m;col++) {
                if ((col == 0 || line.charAt(col-1) == '#') // Next to a wall
                        && (line.charAt(col) == '.') // Current space is clear
                        && (col<m-2 && line.charAt(col+1) == '.' && line.charAt(col+2) == '.')) // Next two spaces are clear
                    sols.add(new Clue(row+1,col+1));
                if (oldLine != null && lastLine != null) {
                    if (row < 3) {
                        continue;
                    } else if (row == 3) {
                        if ((ancientLine.charAt(col) == '.') // Current space is clear
                                && (oldLine.charAt(col) == '.' && lastLine.charAt(col) == '.')) {// Next two spaces are clear
                            sols.add(new Clue(1,col+1));
                        }
                    } else if ((ancientLine.charAt(col) == '#') // Next to a wall
                                && (oldLine.charAt(col) == '.') // Current space is clear
                                && (lastLine.charAt(col) == '.' && line.charAt(col) == '.')) { // Next two spaces are clear
                            sols.add(new Clue(row-1,col+1));
                    }
                }
            }
            ancientLine = oldLine;
            oldLine = lastLine;
            lastLine = line;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("crosswords.out"));
        writer.write(String.valueOf(sols.size() + "\n"));
        for (Clue clue : sols)
            writer.write(clue.toString() + "\n");
        writer.flush();
    }
}

class Clue implements Comparable<Clue> {
    
    int row;
    int col;
    
    Clue(int nrow, int ncol) {
        row = nrow;
        col = ncol;
    }

    @Override
    public int compareTo(Clue clue) {
        if (this.row > clue.row)
            return 1;
        else if (this.row < clue.row)
            return -1;
        else if (this.col > clue.col)
            return 1;
        else if (this.col < clue.col)
            return -1;
        return 0;
    }
    
    @Override
    public String toString() {
        return row + " " + col;
    }
}