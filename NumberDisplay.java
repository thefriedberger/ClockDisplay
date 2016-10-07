
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    
    /**
     *Determines whether the value will be equivalent to a zero, and if yes, then it adds 1 to the value.
     */
    public String getHourDisplayValue()
    {
        if(value < 10 && value > 0) {
            return "0" + value;
        }        
        else if(value == 13 || value == 0) {
            return "" + value + 1;
        }
       else {
            return "" + value;
        }
    }
    
    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getMinuteDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
   }  

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing. I'm also realizing this is probably redundant
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void minuteIncrement()
    {
        value = (value + 1) % limit;
    }
    
    /**
     *This method performs a very similar action to the original Increment() but instead, it at the ends adds
     *a value of 1 so that when it rolls over from 12 to 1 it won't display 0.
     */
    public void hourIncrement()
    {
        value = ((value + 1) % limit) + 1;
    }
}
