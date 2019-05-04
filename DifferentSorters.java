
/**
 * This class contains main to execute different sorters.
 * 
 * Shreyas Mushrif 
 * @version (a version number or a date)
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class DifferentSorters {
    
    public static void main(String[] args){
        
        // Create a parser object
        EarthQuakeParser parser = new EarthQuakeParser();
        
        // Define source file
        String sourceFile = "data/earthQuakeDataWeekDec6sample2.atom";
        
        // Read the source file using the parser
        ArrayList<QuakeEntry> quakes = parser.read(sourceFile);
        
        //Sort by natural order
        sortWithCompareTo(quakes);
        
        // Sort by title and depth
        sortByTitleAndDepth(quakes);
        
        // Sort by last word in the tile and then its magnitude
        sortByLastWordInTitleThenByMagnitude(quakes);
        
        // sort by magnitude
        sortByMagnitude(quakes);
        
        // sort by distance
        sortByDistance(quakes);
    }
    
    public static void sortWithCompareTo(ArrayList<QuakeEntry> quakes) {
        
        Collections.sort(quakes);
        
        int quakeNumber = 600;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakes.get(quakeNumber));
        
        /*
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        */
       
    }    
    
    public static void sortByTitleAndDepth(ArrayList<QuakeEntry> quakes){
        
        Collections.sort(quakes,new TitleAndDepthComparator());
        
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakes.get(quakeNumber));
    }
    
    public static void sortByLastWordInTitleThenByMagnitude(ArrayList<QuakeEntry> quakes){
        
        Collections.sort(quakes, new TitleLastAndMagnitudeComparator());
        
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakes.get(quakeNumber));
    }
    
    public static void sortByMagnitude(ArrayList<QuakeEntry> quakes) {
       
        Collections.sort(quakes, new MagnitudeComparator());
        for(QuakeEntry qe: quakes) {
            System.out.println(qe);
        }

    }

    public static void sortByDistance(ArrayList<QuakeEntry> quakes) {
        
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(quakes, new DistanceComparator(where));
        
        for(QuakeEntry qe: quakes) {
            System.out.println(qe);
        }

    }
}
