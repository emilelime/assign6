
/**
 * Write a description of class GuitarString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuitarString<T> implements BoundedQueue<Integer>
{
    // instance variables - replace the example below with your own
    private int CAPACITY;
    private double frequency;
    /**
     * The constructor creates a guitar string of the given frequency, using a 
     * sampling rate of 44,100. The constructor initializes a bounded queue of the 
     * desired capacity N (sampling rate 44,100 divided by the frequency, rounded up 
     * to the nearest integer), and fills the bounded queue with N zeros to model a 
     * guitar string at rest.
     */
    public GuitarString(double frequency)
    {
        // initialise instance variables
        this.frequency = frequency;
        CAPACITY = (int) Math.ceil(44100.0/frequency);
    }

    /**
     * The pluck method replaces the N samples in the bounded queue with N random 
     * values between -0.5 and +0.5.
     */
    public void pluck()
    {
        
    }
    
    /**
     * The sample method returns the value of the item at the front of the bounded 
     * queue.
     */
    public double sample()
    {
        
    }
    
    /**
     * The tic method applies the Karplus-Strong algorithm, i.e., it deletes the 
     * sample at the front of the bounded queue and adds to the end of the bounded 
     * queue the average of the deleted sample and the sample at the front of the 
     * bounded queue, multiplied by the energy decay factor of 0.994.
     */
    public void tic()
    {
        
    }
    
    public static void main (String[] args)
    {
        GuitarString<String> gs = new GuitarString<String>();
        
    }
}
