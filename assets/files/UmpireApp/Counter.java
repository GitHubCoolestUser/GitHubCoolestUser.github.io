    
/**
 * Creates a simple counter that can count up and reset.
 *
 * @author (Dave, Ben)
 * @version (v1.01)
 */
public class Counter
{
    //instance variables
    private int count;

    //methods

/** 
 *
 * It is a constructor for the Counte class. 
 *
 */
    public Counter() { 

        count = 0;
    }


/** 
 *
 * Increment the count var.
 *
 */
    public void increment()   { 

        count++;
    }


/** 
 *
 * Resets the count var.
 *
 */
    public void reset( ) { 

        count = 0;
    }


/** 
 *
 * Sets the count var.
 *
 * @param count  the count. 
 */
    public void setCount(int count) { 

        this.count = count;
    }
    

/** 
 *
 * returns the count var
 *
 * @return the count
 */
    public int getCount(){ 

        return count;
    }


/** 
 *
 * toString returns the count value in a string.format.
 *
 * @return String
 */
    public String toString() { 

        return String.format("%d",count);
    }
}

