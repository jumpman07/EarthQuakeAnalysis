
/**
 * Class to sort earthquakes or compare earthquakes based on their magnitude.
 */

import java.util.*;

public class DistanceComparator implements Comparator<QuakeEntry> {
    
    // Location of the other earthquake
    Location fromWhere;
    
    // Constructor
    public DistanceComparator(Location where) {
        fromWhere = where;
    }
    
    // Compare method to compare distance of both earthquakes.
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        double dist1 = q1.getLocation().distanceTo(fromWhere);
        double dist2 = q2. getLocation().distanceTo(fromWhere);
        return Double.compare(dist1, dist2);
    }
    
}
 