package cse214homework3;

/**
 *
 * @author Jack Smith
 * ID: 110366081
 * 
 */
public class OrderedPair<T> {

    private T x;
    private T y;
    
    public OrderedPair(T x, T y){     
        this.x = x;
        this.y = y;       
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof OrderedPair))
            return false;
        if(this.x.equals(((OrderedPair)o).getX()) && this.y.equals(((OrderedPair)o).getY()))
            return true;
        else
            return false;      
    }
    
    
}