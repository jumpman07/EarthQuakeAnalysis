
/**
 * sort earthquakes by the last word in their title first and break ties by magnitude
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    
    public int compare (QuakeEntry q1, QuakeEntry q2){
        
        String t1 = q1.getInfo();
        String lastChar1 = t1.substring(t1.lastIndexOf(" ")+1);
        String t2 = q2.getInfo();
        String lastChar2 = t2.substring(t2.lastIndexOf(" ")+1);
        
        // Sort by last character in the title
        int val = lastChar1.compareTo(lastChar2);
        
        // If a tie, i.e. the last characters are the same, sort using magnitude
        if (val == 0)
            return Double.compare(q1.getMagnitude(),q2.getMagnitude());
        
        return val;
    }
}
