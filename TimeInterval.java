package cse214homework3;

/**
 *
 * @author Jack Smith
 * ID: 110366081
 * 
 */
public class TimeInterval extends OrderedPair<Double> implements Comparable<TimeInterval> {

    private double start;
    private double end;
    
    public TimeInterval(Double start, Double end) throws IllegalArgumentException {
        super(start, end);
        this.start = start;
        this.end = end;
        if(this.start > this.end || this.start == this.end || this.start < 0 || this.end < 0)
            throw new IllegalArgumentException("The arguments create an invalid time interval.");    
    }
    
    public double interval(){
        return end - start;
    }
    
    public static TimeInterval fromString(String s){      
        String[] interval = s.split(",");
        Double start = Double.parseDouble(interval[0]);
        Double end = Double.parseDouble(interval[1]);
        TimeInterval t = new TimeInterval(start, end);
        return t;    
    }

    @Override
    public int compareTo(TimeInterval t) {
        if(this.interval() == t.interval())
            return 0;
        else if(this.interval() < t.interval())
            return -1;
        else
            return 1;       
    }
    
    @Override
    public String toString(){
        return "(" + start + "s , " + end + "s)";
    }
     
}
