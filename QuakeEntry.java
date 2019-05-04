import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * Class to represent an earthquake. Contains various measurables of an earthquake such as it location,
 * depth, and magnitude.
 */

public class QuakeEntry implements Comparable<QuakeEntry>{
    
    // Location of this earthquake
    private Location myLocation;
    
    // title of this earthquake
    private String title;
    
    // Depth of origin of this earthquake
    private double depth;
    
    // Magnitude of this earthquake
    private double magnitude;
    
    /*
     * Constructor
     * @params: latitude, longitude, magnitude, title, and depth
     * Creates a new Location object.
     */

    public QuakeEntry(double lat, double lon, double mag, 
                      String t, double d) {
        myLocation = new Location(lat,lon);
        
        magnitude = mag;
        title = t;
        depth = d;
    }
    
    // Get the location of this earthquake. Returns the Location object
    public Location getLocation(){
        return myLocation;
    }
    
    // Get the magnitude of this earthquake.
    public double getMagnitude(){
        return magnitude;
    }
    
    // Get information about this object
    public String getInfo(){
        return title;
    }
    
    // Get depth of this earthquake
    public double getDepth(){
        return depth;
    }
    
    // Default comparator. Compares with magnitudes.
    @Override
    public int compareTo(QuakeEntry loc) {
        
        // Sort by magnitude first
        int val = Double.compare(magnitude, loc.getMagnitude());
        
        // If a tie, settle it by depth
        if (val == 0)
            val = Double.compare(depth, loc.getDepth());
        
        return val;
    
        
        // Here is another way to sort by Magnitude
        /*
        if (magnitude < loc.getMagnitude()){
            return -1;
           }
        if (magnitude > loc.getMagnitude()){
            return 1;
           }
        return 0;
        
        */
        
       //  Below here sorts by Location
        /*
        double difflat = myLocation.getLatitude() - loc.myLocation.getLatitude();
        if (Math.abs(difflat) < 0.001) {
            double diff = myLocation.getLongitude() - loc.myLocation.getLongitude();
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        }
        if (difflat < 0) return -1;
        if (difflat > 0) return 1;
        
        
        // never reached
        return 0;
        */
    }
    
    // Print this earthquake
    public String toString(){
        return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),myLocation.getLongitude(),magnitude,depth,title);
    }
    
}